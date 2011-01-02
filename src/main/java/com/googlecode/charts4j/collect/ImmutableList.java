/**
 *
 * The MIT License
 *
 * Copyright (c) 2011 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.googlecode.charts4j.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * Immutable list wrapper class. It is a shallow notion of immutability. It may
 * not be perfect, it is only for charts4j internal purposes anyway.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @param <E>
 *            Type parameter of list elements.
 */
public final class ImmutableList<E> implements List<E>, RandomAccess {

    /** List. **/
    private final List<E> list;

    /**
     * Construct an immutable list with the provided list.
     *
     * @param list list to wrap in this immutable list.
     */
    ImmutableList(final List<? extends E> list) {
        this.list = Collections.unmodifiableList(list);
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(final E o) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public void add(final int index, final E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(final Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(final int index, final Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(final Object o) {
        return list.contains(o);
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsAll(final Collection<?> c) {
        return list.containsAll(c);
    }

    /**
     * {@inheritDoc}
     */
    public E get(final int index) {
        return list.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(final Object o) {
        return list.indexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public int lastIndexOf(final Object o) {
        return list.lastIndexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<E> listIterator() {
        return list.listIterator();
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<E> listIterator(final int index) {
        return list.listIterator(index);
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public E remove(final int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean retainAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public E set(final int index, final E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     */
    public List<E> subList(final int fromIndex, final int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    /**
     * {@inheritDoc}
     */
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * {@inheritDoc}
     */
    public <T> T[] toArray(final T[] a) {
        return list.toArray(a);
    }
}
