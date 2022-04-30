package codes.foundation.crypto.key;

import codes.foundation.crypto.model.PairItem;
import lombok.Getter;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author cryptoformore
 */
public class ECKeyGenerateStrategy implements KeyGenerateStrategy {

    public static final String DEFAULT_ALGORITHM_NAME = "EC";

    @Getter
    private final byte[] salt;

    protected final ECPubKeyParam pubKeyParam;

    ECKeyGenerateStrategy(ECPubKeyParam pubKeyParam) {
        this(DEFAULT_SALT, pubKeyParam);
    }

    ECKeyGenerateStrategy(byte[] salt, ECPubKeyParam pubKeyParam) {
        this.salt = Objects.requireNonNull(salt);
        this.pubKeyParam = pubKeyParam;
    }

    @Override
    public PairItem<byte[], byte[]> restoreKeyPair(byte[] seed) {

        var keyPairGenerator = keyGenerator(seed);
        var keyPair = keyPairGenerator.generateKeyPair();

        return new PairItem<>(keyPair.getPrivate().getEncoded(), keyPair.getPublic().getEncoded());
    }

    protected static byte[] combineData(byte[]... items) {

        var output = new ByteArrayOutputStream();

        if (Objects.nonNull(items) && items.length > 0) {
            Arrays.stream(items).filter(Objects::nonNull)
                    .forEach(item -> output.write(item, 0, item.length));
        }

        return output.toByteArray();
    }

    protected KeyPairGenerator keyGenerator(byte[] seed) {

        try {
            var random = SecureRandom.getInstanceStrong();
            random.setSeed(combineData(seed, getSalt()));

            var keyPairGenerator = KeyPairGenerator.getInstance(DEFAULT_ALGORITHM_NAME);
            keyPairGenerator.initialize(new ECGenParameterSpec(this.pubKeyParam.getCurveName()), random);

            return keyPairGenerator;
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("key generate failed");
        }
    }
}
