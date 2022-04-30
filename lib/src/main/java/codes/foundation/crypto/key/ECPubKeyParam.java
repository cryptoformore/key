package codes.foundation.crypto.key;

import lombok.Builder;
import lombok.Getter;

/**
 * @author cryptoformore
 */
@Builder
@Getter
public class ECPubKeyParam {

    private String curveName;
}
