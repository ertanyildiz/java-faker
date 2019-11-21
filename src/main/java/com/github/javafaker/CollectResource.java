package com.github.javafaker;

import java.util.ArrayList;
import java.util.List;

public class CollectResource {
    private final Faker faker;
    private final List<String> tagList;

    protected CollectResource(Faker faker) {
        this.faker = faker;
        tagList = new ArrayList<String>();
    }

    private String getSourceType() {
        return String.format("sourcetype:%s", faker.fakeValuesService().resolve("game.sourcetype", this, faker)).toLowerCase();
    }

    private String getSource() {
        return String.format("source:%s", faker.fakeValuesService().resolve("game.source", this, faker));
    }

    private String getAmount() {
        return String.format("amount:%s", faker.number().digits(2));
    }

    private String getResourceType() {
        return String.format("resourcetype:%s", faker.fakeValuesService().resolve("game.resourcetype", this, faker)).toLowerCase();
    }

    public List<String> tags() {
        tagList.add(getSourceType());
        tagList.add(getSource());
        tagList.add(getAmount());
        tagList.add(getResourceType());
        return tagList;
    }

}
