package com.gildedrose;

public abstract class AbstractGood implements Good {

    static final int HIGHEST_QUALITY_VALUE = 50;
    static final int NORMAL_DEGRADE_FACTOR = 1;
    static final int DOUBLE_DEGRADE_FACTOR = 2;

    protected Item item;

    @Override
    public void processItem() {
        this.updateQuality();
        item.sellIn = item.sellIn - 1;
        this.checkExpiration();
    }

    void increaseQuality(Item item) {
        if (item.quality < HIGHEST_QUALITY_VALUE) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQuality(Item item) {
        decreaseQuality(item, NORMAL_DEGRADE_FACTOR);
    }

    void decreaseQuality(Item item, int factor) {
        for (int i = 0; i < factor; i++) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
