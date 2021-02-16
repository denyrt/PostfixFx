package mathematic;

public interface CloseTagToken<T> extends OperationToken<T> {

    OpenTagToken<T> getCloseTag();
}