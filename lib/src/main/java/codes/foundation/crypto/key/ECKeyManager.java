package codes.foundation.crypto.key;

import codes.foundation.crypto.model.PairItem;
import lombok.Getter;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

/**
 * @author cryptoformore
 */
public class ECKeyManager implements KeyManager {

    @Getter
    final KeyGenerateStrategy keyGenerateStrategy;

    @Getter
    final static KeyFactory keyFactory;

    static {
        try {
            keyFactory = KeyFactory.getInstance(ECKeyGenerateStrategy.DEFAULT_ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("KeyFactory get failed");
        }
    }

    public ECKeyManager(KeyGenerateStrategy keyGenerateStrategy) {
        this.keyGenerateStrategy = keyGenerateStrategy;
    }

    @Override
    public PairItem<byte[], byte[]> signatureAndPubKey(short version, byte[] seed, byte[] data, boolean compressed) {

        var keyPairs = this.getKeyGenerateStrategy().restoreKeyPair(seed);

        var signature = new byte[0];

        if (Objects.nonNull(data)) {
            signature = signAndVerify(keyPairs, data);
        }

        return new PairItem<>(signature, keyPairs.getTheOther());
    }

    @Override
    public boolean verify(short version, byte[] rawPublicKey, byte[] signed, byte[] data) {
        return verify(rawPublicKey, signed, data);
    }

    private static byte[] signAndVerify(PairItem<byte[], byte[]> keyPairs, byte[] data) {

        try {
            var privateKey = KeyGenerateStrategy.getEncodedKey(keyFactory, () -> new PKCS8EncodedKeySpec(keyPairs.getTheOne()), true);

            var signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign((PrivateKey) privateKey);
            signature.update(data);

            var signed = signature.sign();

            if (!verify(keyPairs.getTheOther(), signed, data)) {
                throw new SignatureException("generate signature failed");
            }

            return signed;
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("generate signature failed");
    }

    private static boolean verify(byte[] rawPubKey, byte[] signed, byte[] data) {

        try {
            var publicKey = KeyGenerateStrategy.getEncodedKey(keyFactory, () -> new X509EncodedKeySpec(rawPubKey), false);

            var signature = Signature.getInstance("SHA256withECDSA");
            
            signature.initVerify((PublicKey) publicKey);
            signature.update(data);

            return signature.verify(signed);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return false;
    }
}
