package mathematic.algebra;

import mathematic.CloseTagToken;
import mathematic.OpenTagToken;

public final class SimpleOpenTagToken<T> extends OpenTagToken<T> {

    private final String key;
    private final int priority;

    private CloseTagToken<T> closeTagToken;

    public SimpleOpenTagToken(String key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    public void setCloseTag(CloseTagToken<T> closeTagToken) {
        this.closeTagToken = closeTagToken;
    }

    @Override
    public CloseTagToken<T> getCloseTag() {
        return this.closeTagToken;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }
}
