package org.example;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("Поле фамилия пустое");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("В поле \"возраст\" указан некорректный возраст");
        } else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Поле город пустое");
        } else this.address = address;
        return this;
    }

    @Override
    public Person build() {

        Person person;
        if (name == null) {
            throw new IllegalArgumentException("Поле имя пустое");
        }
        if (surname == null) {
            throw new IllegalArgumentException("Поле фамилия пустое");
        }

        if ((Integer) age == null) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;


    }
}

