package org.example;

import java.util.Comparator;
import java.util.Collections;

public class Person implements Comparator<Person>, Cloneable {
    private String name = "";
    private int age = 0;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(Person p1){

    }
    private void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    private void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public int compare(Person a, Person b){
        if (a.getAge() == b.getAge())
            if(a.getName().equals(b.getName()))
                return 0;
        else if (a.getAge() == b.getAge())
            if(a.getName().compareTo(b.getName()) > 0)
                return 1;
            else if (a.getName().compareTo(b.getName()) < 0)
                return -1;
        else if (a.getAge() > b.getAge())
            return -1;
        return 1;
    }
    @Override
    public boolean equals(Object o){
        Person p = (Person) o;
        if(p.hashCode() == this.hashCode())
            return true;
        return false;
    }
    public Person copy(){
        String name = this.getName();
        int age = this.getAge();
        return new Person(name, age);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String toString(){
        return this.hashCode() + " -> " + this.name + ":" + this.age;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person bob = new Person("bob", 100);
        Person lacy = new Person("lacy", 102);
        Person jack = new Person("jack", 100);
        Person jacklyn = new Person("jack", 100);
        Person suzy = new Person("suzy", 101);
        System.out.println("bob:100 compared to jack:100 --> " + bob.compare(jack,bob));
        System.out.println("jack:100 compared to bob:100 --> " + bob.compare(bob,jack));
        System.out.println("jack:100 compared to self --> " + jack.compare(jack,jack));
        System.out.println("jack:100 compared to jack:100 (BUT NEW PERSON) --> " + jack.compare(jack,jacklyn));
        System.out.println("suzy:101 compared to bob:100 --> " + suzy.compare(suzy,bob));
        System.out.println("lacy:102 compared to suzy:101 --> " + lacy.compare(lacy,suzy));
        System.out.println("bob equals lacy --> " + bob.equals(lacy));
        System.out.println("bob equals bob --> " + bob.equals(bob));
        System.out.println("copy(): " + bob.copy().toString());
        Person clone = (Person) bob.clone();
        System.out.println("bob -> " + bob.hashCode() + ", clone() -> " + clone.hashCode());
        System.out.println("copyByClone(): " + clone.toString());
    }
}
