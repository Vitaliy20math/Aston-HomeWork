package javaHomeWork;

import java.util.Collection;
import java.util.Comparator;

/**
Класс представляющий кастомную реализацию ArrayList cо следующими методами:
 - boolean isEmpty() - проверка на пустоту коллекции
 - void add(int index, E element) - добавляет элемент по индексу
 - void addAll(Collection<? extends E> c) - добавляет коллекцию в кастомный ArrayList
 - void clear() - чистит коллекцию
 - E get(int index) - получает элемент по индексу
 - E remove(int index) - удаляет элемент коллекции по индексу
 - boolean contains(Object element) - проверка на наличие элемента в коллекции
 - E remove(Object o) - удаляет определенный элемент коллекции (первое вхождение)
 - void sort(Comparator<? super E> c) - сортирует динамический массив методом quicksort
 */
public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public CustomArrayList(Collection<? extends E> collection) {
        this.elements = (E[]) collection.toArray();
        this.size = elements.length;
    }

    public CustomArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = (E[]) new Object[initialCapacity];
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    void add(int index, E element) {
        if (index < 0 | index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    void add(E element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }
    E get(int index) {
        return elements[index];
    }
    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    E remove(int index) {
        elements[index] = null;
        for (int i = index + 1; i < elements.length; ++i) {
            elements[i-1] = elements[i];
        }
        size = elements.length - 1;
        return elements[index];
    }
    E remove(Object o) {
        for (int i = 0; i < elements.length; ++i) {
            if (elements[i].equals(o)) {
                for (int j = i + 1; j < elements.length; ++j) {
                    elements[j-1] = elements[j];
                }
                size = elements.length - 1;
                return elements[i];
            }
        }
        return null;
    }
    void addAll(Collection<? extends E> collection) {
        int collectionSize = collection.toArray().length + elements.length + 1;
        E[] newElements = (E[]) new Object[collectionSize];
        for (int i = elements.length; i < collectionSize; ++i) {
            newElements[i] = (E)collection.toArray()[i];
        }
    }
    boolean contains(Object o) {
        for (E e : elements) {
            if (e.equals(o)) {
                return e.equals(o);
            }
        }
        return false;
    }
    void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    void sort(Comparator<? super E> c) {
        quicksort(elements, 0, elements.length - 1, c);
    }
    private void quicksort(E[] arr, int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pi = partition(arr, low, high, c);
            quicksort(arr, low, pi - 1, c);
            quicksort(arr, pi + 1, high, c);
        }
    }

    private int partition(E[] arr, int low, int high, Comparator<? super E> c) {
        E pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
