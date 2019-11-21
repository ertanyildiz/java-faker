package com.github.javafaker;

import java.util.ArrayList;
import java.util.List;

public class DrainSource {

    private final Faker faker;
    private final List<String> tagList;

    protected DrainSource(Faker faker) {
        this.faker = faker;
        tagList = new ArrayList<String>();
    }

    private String getSinkType() {
        return String.format("sinktype:%s", faker.fakeValuesService().resolve("game.sourcetype", this, faker)).toLowerCase() + faker.number().digit();
    }

    private String getSink() {
        return String.format("sink:%s", faker.fakeValuesService().resolve("game.source", this, faker));
    }

    private String getAmount() {
        return String.format("amount:%s", faker.number().digits(2));
    }

    private String getcurrency() {
        return String.format("resourcetype:%s", faker.fakeValuesService().resolve("game.resourcetype", this, faker)).toLowerCase();
    }

    public List<String> tags() {
        tagList.add(getSinkType());
        tagList.add(getSink());
        tagList.add(getAmount());
        tagList.add(getcurrency());
        return tagList;
    }

}