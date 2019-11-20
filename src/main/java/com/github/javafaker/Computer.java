package com.github.javafaker;

public class Computer {

    private final Faker faker;

    protected Computer(Faker faker) {
        this.faker = faker;
    }
    public String osName() {
        return faker.fakeValuesService().resolve("computer.os_names", this, faker);
    }
}
