package org.example;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;
    Person person;


    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Поле имя пустое");
        } else {
            this.name = name;
            return this;
        }
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

        if (name == null || surname == null) {
            throw new IllegalArgumentException("Нету поля \"имя\" или \"фамилия\" ");
        }
        if (age < 1) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;

    }


}

