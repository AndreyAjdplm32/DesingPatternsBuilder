package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public boolean hasAge() {

        if (this.age == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (OptionalInt.of(this.age).isEmpty()) {
            return null;
        } else {
            return OptionalInt.of(this.age);
        }
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address).setAge(1);
    }

    @Override
    public String toString() {

        try {
            return "name - " + name + " surname - " + surname + " age - " + age.intValue() + " address - " + address;
        } catch (NullPointerException e) {
            return "name - " + name + " surname - " + surname + " age - неуказан " + address + " + address";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
