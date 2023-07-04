package java.homeworks.firstHomework;

import java.util.Collection;

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

    public CustomArrayList(E[] elements) {
        this.elements = elements;
        this.size = elements.length;
    }

    public CustomArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
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

    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    void addAll(Collection<? extends E> collection) {
        int collectionSize = collection.toArray().length + elements.length + 1;
        E[] newElements = (E[]) new Object[collectionSize];
        for (int i = elements.length; i < collectionSize; ++i) {
            newElements[i] = (E)collection.toArray()[i];
        }
    }


}
