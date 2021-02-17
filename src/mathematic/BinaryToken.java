package mathematic;

public abstract class BinaryToken<T> extends OperationToken<T> {

    public abstract OperandToken<T> calculate(OperandToken<T> left, OperandToken<T> right);
}