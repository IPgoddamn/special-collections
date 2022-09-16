package com.efimchick.ifmo.collections;

import java.util.*;

class PairStringList<String> extends ArrayList<String> {
    private List<String> list;
    private int count = -1;
    PairStringList(){
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    @Override
    public boolean add(String e) {
        list.add(e);
        list.add(e);
//        for(String s : list){
//            System.out.println(s);
//        }
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends String> c) {
        int in = list.size();
        Object s [] = c.toArray();
        for(int i = 0; i < s.length; i++){
            list.add(in++, (String) s[i]);
            list.add(in++, (String) s[i]);
        }
        return true;
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        int in = index;
        Object s [] = c.toArray();
        if(index % 2 == 1 && index != list.size()-1){
            in +=1;
            for(int i = 0; i < s.length; i++){
                list.add(in++, (String) s[i]);
                list.add(in++, (String) s[i]);
            }
            return true;
        }
        for(int i = 0; i < s.length; i++){
            list.add(in++, (String) s[i]);
            list.add(in++, (String) s[i]);
        }
        return true;
    }
    @Override
    public String set (int index, Object o){
        if(index % 2 == 1 && index != list.size()-1){
            list.set(index, (String) o);
            list.set(index-1, (String) o);
            return (String) "";
        }
        list.set(index, (String) o);
        list.set(index+1, (String) o);
    return (String)"";
    }
    @Override
    public void add(int index, Object o) {
        if(index % 2 == 1 && index != list.size()-1){
            list.add(index+1, (String) o);
            list.add(index+1, (String) o);
            return;
        }
        list.add(index, (String) o);
        list.add(index, (String) o);

    }
    @Override
    public String get(int index) {
        return list.get(index);
    }
    @Override
    public boolean remove(Object o) {
        list.remove(o);
        list.remove(o);
        return true;
    }
    @Override
    public void clear(){
        list.clear();
    }
    @Override
    public String remove(int index) {
        list.remove(index);
        for(String s : list){
            System.out.println(s);
        }
        return list.remove(index-1);
    }
    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }


    class MyIterator implements Iterator<String>{
        private int n = -1;
        @Override
        public boolean hasNext() {
            n++;
            if (list == null) return false;
            return !(list.size() == n);
        }
        @Override
        public String next() {
            return list.get(n);
        }
    }

}

