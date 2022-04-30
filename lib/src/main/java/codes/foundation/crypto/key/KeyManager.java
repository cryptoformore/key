package codes.foundation.crypto.key;

import codes.foundation.crypto.model.PairItem;

/**
 * @author cryptoformore
 */
public interface KeyManager {

    PairItem<byte[], byte[]> signatureAndPubKey(short version, byte[] seed, byte[] data, boolean compressed);

    boolean verify(short version, byte[] pubKey, byte[] signed, byte[] data);
}
