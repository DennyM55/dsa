package org.learn;

import java.util.Objects;

public class ReverseString {

    public static void main(String[] s) {
        System.out.println(reverString("a,b$c"));
        System.out.println(reverString("Abc,de!f"));
        System.out.println(reverString(" "));
        System.out.println(Objects.equals(null,"a"));
    }

    private static String reverString(String s) {

        if (s == null || s.isBlank())
            return " null or empty string ";
        else return "valid string";
    }
}
