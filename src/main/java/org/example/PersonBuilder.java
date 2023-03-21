package org.example;

import java.util.OptionalInt;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private Integer age = null;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
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
            throw new IllegalStateException("Поле город пустое");
        } else this.address = address;
        return this;
    }


    @Override
    public Person build() {

        Person person;
        if (this.name == null) {
            throw new IllegalStateException("Поле имя пустое");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Поле фамилия пустое");
        }

        if (this.age == null) {
            person = new Person(name, surname);

        } else person = new Person(name, surname, this.age);
        person.setAddress(address);
        return person;


    }
}

