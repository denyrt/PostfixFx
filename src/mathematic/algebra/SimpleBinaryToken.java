package mathematic.algebra;

import mathematic.BinaryToken;
import mathematic.OperandToken;

import java.util.function.BinaryOperator;

public final class SimpleBinaryToken<T> extends BinaryToken<T> {

    private final String key;
    private final int priority;
    private final BinaryOperator<OperandToken<T>> binaryOperator;

    public SimpleBinaryToken(String key, int priority, BinaryOperator<OperandToken<T>> binaryOperator) {
        if (key == null)
            throw new NullPointerException("Key was null.");

        if (binaryOperator == null)
            throw new NullPointerException("'binaryOperator' was null");

        this.key = key;
        this.priority = priority;
        this.binaryOperator = binaryOperator;
    }

    @Override
    public OperandToken<T> calculate(OperandToken<T> left, OperandToken<T> right) {
        return this.binaryOperator.apply(left, right);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }
}