package mathematic;

public abstract class OperandToken<T> extends Token<T> {

    public abstract T getValue();

    @Override
    public String toString() {
        return getValue().toString();
    }
}