package utils;

import java.util.ArrayList;

public class List<E> extends ArrayList<E> {
    public boolean empty() {
        return super.isEmpty();
    }

    public E first() {
        return this.get(0);
    }

    public E last() {
        return this.get(this.size()-1);
    }

    public int count() {
        return super.size();
    }
}