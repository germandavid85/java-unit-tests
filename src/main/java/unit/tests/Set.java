package unit.tests;

import java.util.Arrays;

// no tiene datos repetidos
// no conserva el orden de los elementos
public class Set {
    private int size = 0;
    private Object[] elements = new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Object o) {
        if (o == null) {
            return false;
        }

        boolean isContained = contains(o);

        if (isContained) {
            return false;
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }

        elements[size] = o;
        size++;

        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }


    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                elements[i] = null;
                size--;
            }
        }
    }
}
