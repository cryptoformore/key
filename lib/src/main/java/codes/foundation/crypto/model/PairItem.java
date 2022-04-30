package codes.foundation.crypto.model;

import lombok.Getter;

/**
 * @author cryptoformore
 */
@Getter
public class PairItem<O, T> {

    private final O theOne;
    private final T theOther;

    public PairItem(O theOne, T theOther) {
        this.theOne = theOne;
        this.theOther = theOther;
    }
}