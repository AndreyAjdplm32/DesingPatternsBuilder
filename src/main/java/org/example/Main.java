package org.example;

import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder().setName("Анна").setSurname("Вольф").setAge(40).setAddress("Сидней").build();
        Person son = mom.newChildBuilder().setName("Антошка").build();
        System.out.println("У " + mom + " -  есть сын: \n" + son);
        System.out.println(mom.hasAge());

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}