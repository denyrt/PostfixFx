package mathematic.algebra;

import mathematic.OperandToken;

public final class SimpleOperandToken<T> extends OperandToken<T> {

    private final T value;

    public SimpleOperandToken(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
