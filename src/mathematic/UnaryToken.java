package mathematic;

public interface UnaryToken<T> extends OperationToken<T> {

    OperandToken<T> calculate(OperandToken<T> value);
}