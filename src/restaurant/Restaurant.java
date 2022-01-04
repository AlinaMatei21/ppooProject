package restaurant;

import java.io.*;
import java.util.*;

public class Restaurant <T> implements Serializable {
    protected List<T> contents;
    private Locations location;


    public Restaurant(Locations location) {
        this.location = location;
        contents = new ArrayList<T>();
    }

    public int getSize() {
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


    public void show(){
        System.out.println("Restaurant in " + location + " has: " + getSize());

        for(Iterator i = contents.iterator();i.hasNext();) {
            System.out.println(i.next().toString());
        }
    }

    public List<T> getContents() {
        return contents;
    }


    public void setContents(List<T> contents) {
        this.contents = contents;
    }

}
