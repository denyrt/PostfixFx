package mathematic;

public abstract class UnaryToken<T> extends OperationToken<T> {

    public abstract OperandToken<T> calculate(OperandToken<T> value);
}