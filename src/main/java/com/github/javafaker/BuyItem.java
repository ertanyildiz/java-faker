package com.github.javafaker;

import java.util.ArrayList;
import java.util.List;

public class BuyItem {
    private final Faker faker;
    private final List<String> tagList;
    protected BuyItem(Faker faker) {
        this.faker = faker;
        tagList = new ArrayList<String>();
    }

    private String getItemId() {
        return String.format("itemid:%s", faker.fakeValuesService().resolve("game.itempack", this, faker)).toLowerCase() + faker.number().digit();
    }
    private String getItemType() {
        return String.format("amount:%s", faker.fakeValuesService().resolve("game.itempack", this, faker));
    }
    private String getAmount() {
        return String.format("amount:%s", faker.number().digits(2));
    }
    private String getcurrency() {
        return String.format("currency:%s", faker.fakeValuesService().resolve("currency.code", this, faker)).toLowerCase();
    }
    public List<String> tags(){
        tagList.add(getItemId());
        tagList.add(getItemType());
        tagList.add(getAmount());
        tagList.add(getcurrency());
        return tagList;
    }

}
