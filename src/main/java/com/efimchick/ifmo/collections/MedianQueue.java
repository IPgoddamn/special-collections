package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue extends AbstractQueue {
    LinkedList ls = new LinkedList();
    @Override
    public Iterator iterator() {
        return ls.iterator();

    }

    @Override
    public int size() {
        return ls.size();
    }

    @Override
    public boolean offer(Object o) {
        Collections.sort(ls);
        return ls.offer(o);
    }

    @Override
    public Object poll() {
        if(ls.size() == 0) return null;
        Integer index = (Integer)peek();
        ls.remove(index);
        ls.add(0, index);
        return ls.poll();
    }

    @Override
    public Object peek() {
        ls.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int a = (int)o1;
                int b = (int)o2;
                return a - b;
            }
        });
        int length = 0;
        if(ls.size() % 2 == 0){
            length = ls.size()/2 - 1;
        }
        else {
            length = ls.size() / 2;
        }


        return ls.get(length);
    }
}
