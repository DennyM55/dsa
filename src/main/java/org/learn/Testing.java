package org.learn;

public interface Testing extends X{
    String name = "Hi";
    String MESSAGE = "Hello, World!";

    default void printMessage() {
        sayHello(MESSAGE);
    }
     static void sayHello(String m){
        System.out.println(m);
    }

}
interface X{}