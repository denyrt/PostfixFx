package mathematic.algebra;

import mathematic.CloseTagToken;
import mathematic.OpenTagToken;

public final class SimpleCloseTagToken<T> extends CloseTagToken<T> {

    private final String key;
    private final int priority;

    private OpenTagToken<T> openTagToken;

    public SimpleCloseTagToken(String key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    public void setOpenTag(OpenTagToken<T> openTagToken) {
        this.openTagToken = openTagToken;
    }

    @Override
    public OpenTagToken<T> getOpenTag() {
        return this.openTagToken;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}