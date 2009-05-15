/**
 *
 * The MIT License
 *
 * Copyright (c) 2008 the original author or authors.
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

import static com.googlecode.charts4j.collect.Preconditions.checkContentsNotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Lists static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class Lists {

    /**
     * Static factory class can never be instantiated.
     */
    private Lists() {
        throw new AssertionError();
    }

    /**
     * Static factory method to instantiate a LinkedList.
     *
     * @param <E>
     *            Type parameter for list.
     *
     * @return A newly instantiated LinkedList of type E.
     */
    public static <E> List<E> newLinkedList() {
        return new LinkedList<E>();
    }

    /**
     * Static factory method to instantiate an ArrayList.
     *
     * @param <E>
     *            Type parameter for list.
     *
     * @return A newly instantiated ArrayList of type E.
     */
    public static <E> List<E> newArrayList() {
        return new LinkedList<E>();
    }


    /**
     * Given a vararg, return an immutable list.
     *
     * @param <E>
     *            Type parameter for list.
     * @param a
     *            the vararg list
     * @return an immutable list given the vararg.
     */
    public static <E> ImmutableList<E> of(final E... a) {
        return new ImmutableList<E>(Arrays.asList(a));
    }

    /**
     * A shallow copy of a list.
     *
     * @param <E>
     *            Type parameter for list.
     * @param list
     *            list to copy
     * @return an immutable list given the list
     */
    public static <E> ImmutableList<E> copyOf(final List<? extends E> list) {
        checkContentsNotNull(list, "list cannnot be null");
        final List<E> l = Lists.newLinkedList();
        for (E e : list) {
            l.add(e);
        }
        return new ImmutableList<E>(list);
    }
}
