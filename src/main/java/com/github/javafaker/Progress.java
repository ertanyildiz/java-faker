package com.github.javafaker;

import java.util.ArrayList;
import java.util.List;

public class Progress {

    private final Faker faker;
    private final List<String> tagList;

    protected Progress(Faker faker) {
        this.faker = faker;
        tagList = new ArrayList<String>();
    }

    private String getWorld() {
        return String.format("world:%s", faker.fakeValuesService().resolve("game.world", this, faker)).toLowerCase() + faker.number().digit();
    }

    private String getLevelOne() {
        return "level:" + faker.number().digits(1);
    }
    private String getArea() {
        return String.format("area:%sx%s", faker.number().digits(2), faker.number().digits(2));
    }

    private String getTrailNum() {
        return String.format("trailnum:%s", faker.number().digits(1));
    }


    public List<String> tags() {
        tagList.add(getWorld());
        tagList.add(getLevelOne());
        tagList.add(getTrailNum());
        return tagList;
    }

}