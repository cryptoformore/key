package codes.foundation.crypto.model;

import lombok.Getter;

/**
 * @author cryptoformore
 */
@Getter
public class TripleItem<O, A, T> extends PairItem<O, T> {

    private final A another;

    public TripleItem(O theOne, A another, T theOther) {
        super(theOne, theOther);
        this.another = another;
    }
}