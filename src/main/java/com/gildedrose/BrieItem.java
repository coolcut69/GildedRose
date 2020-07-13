package com.gildedrose;

public class BrieItem extends AbstractGood implements Good {

    public BrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        increaseQuality(item);
    }

    @Override
    public void checkExpiration() {
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
