package codes.foundation.crypto.key;

import codes.foundation.crypto.model.PairItem;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.function.Supplier;

/**
 * @author cryptoformore
 */
public interface KeyGenerateStrategy {

    byte[] DEFAULT_SALT = "y²=x³+ax+b(mod p)".getBytes(StandardCharsets.UTF_8);

    PairItem<byte[], byte[]> restoreKeyPair(byte[] seed);

    static Key getEncodedKey(KeyFactory keyFactory, Supplier<KeySpec> keySpecSupplier, boolean privateKey) {

        var keySpec = keySpecSupplier.get();

        try {
            return privateKey ? keyFactory.generatePrivate(keySpec) : keyFactory.generatePublic(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
