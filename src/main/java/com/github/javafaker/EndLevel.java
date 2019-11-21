package com.github.javafaker;

import java.util.ArrayList;
import java.util.List;

public class EndLevel {

    private final Faker faker;
    private final List<String> tagList;

    protected EndLevel(Faker faker) {
        this.faker = faker;
        tagList = new ArrayList<String>();
    }

    private String getWorld() {
        return String.format("world:%s", faker.fakeValuesService().resolve("game.world", this, faker)).toLowerCase() + faker.number().digit();
    }

    private String getLevelOne() {
        return String.format("level:%s", faker.number().digits(1));
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