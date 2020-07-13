package com.gildedrose;

public class ConjuredItem extends AbstractGood implements Good {

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item, DOUBLE_DEGRADE_FACTOR);
    }

    @Override
    public void checkExpiration() {
        decreaseQuality(item, DOUBLE_DEGRADE_FACTOR);
    }
}
