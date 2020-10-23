package restaurant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Restaurant <T> implements Serializable {
    protected List<T> contents;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        contents = new ArrayList<T>();
    }

    public int getSize() {
        System.out.println("There are " + contents.size() + " orders in " + name);
        return contents.size();
    }

    public boolean isEmpty(){
        return (contents.size() == 0);
    }

    public void add(T obj){
        contents.add(obj);
    }

    public void remove(T obj){
        contents.remove(obj);
    }

    public T get(int index) {
        return contents.get(index);
    }

    public void show(){
        System.out.println("Restaurant " + name + " has the following orders:");
        for(Iterator i = contents.iterator(); i.hasNext();)
        {
            System.out.println(i.next().toString());
        }
    }
}
