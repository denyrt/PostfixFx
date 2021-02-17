package mathematic;

public abstract class CloseTagToken<T> extends OperationToken<T> {

    public abstract OpenTagToken<T> getOpenTag();
}