package me.rexim.algotsoding.collections;

import java.util.List;

public interface Set<E> {
    void add(E element);
    void delete(E element);
    boolean isEmpty();
    boolean contains(E element);
    List<E> toList();
}
