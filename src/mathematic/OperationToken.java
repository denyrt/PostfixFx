package mathematic;

public abstract class OperationToken<T> extends Token<T> {

    public abstract String getKey();

    public abstract int getPriority();

    @Override
    public String toString() {
        return getKey();
    }
}