package mathematic;

public abstract class OpenTagToken<T> extends OperationToken<T>  {

    public abstract CloseTagToken<T> getCloseTag();
}