package mathematic;

public interface BinaryToken<T> extends OperationToken<T> {

    OperandToken<T> calculate(OperandToken<T> left, OperandToken<T> right);
}