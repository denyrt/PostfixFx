package mathematic;

public interface OperationToken<T> extends Token<T> {

    String getKey();

    int getPriority();
}