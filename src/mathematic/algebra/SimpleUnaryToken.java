package mathematic.algebra;

import mathematic.OperandToken;
import mathematic.UnaryToken;

import java.util.function.UnaryOperator;

public final class SimpleUnaryToken<T> extends UnaryToken<T> {

    private final String key;
    private final int priority;
    private final UnaryOperator<OperandToken<T>> unaryOperator;

    public SimpleUnaryToken(String key, int priority, UnaryOperator<OperandToken<T>> unaryOperator) {
        if (key == null)
            throw new NullPointerException("Key was null.");

        if (unaryOperator == null)
            throw new NullPointerException("'binaryOperator' was null");

        this.key = key;
        this.priority = priority;
        this.unaryOperator = unaryOperator;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public OperandToken<T> calculate(OperandToken<T> value) {
        return this.unaryOperator.apply(value);
    }
}