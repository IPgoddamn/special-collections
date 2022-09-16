package com.efimchick.ifmo.collections;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

class SortedByAbsoluteValueIntegerSet<E> extends TreeSet<E>{
    SortedByAbsoluteValueIntegerSet(){

        super(Comparator.comparingInt(o -> Math.abs((Integer)o)));
    }
}
