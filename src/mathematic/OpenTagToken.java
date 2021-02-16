package mathematic;

public interface OpenTagToken<T> extends OperationToken<T>  {

    CloseTagToken<T> getCloseTag();
}