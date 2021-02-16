package mathematic;

public interface OperandToken<T> extends Token<T> {

    T getValue();
}