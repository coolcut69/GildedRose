package com.gildedrose;

public class BackStageItem extends AbstractGood implements Good {

    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;

    public BackStageItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        increaseQuality(item);
        if (item.quality < HIGHEST_QUALITY_VALUE) {
            if (item.sellIn < ELEVEN_DAYS) {
                increaseQuality(item);
            }
            if (item.sellIn < SIX_DAYS) {
                increaseQuality(item);
            }
        }
    }

    @Override
    public void checkExpiration() {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
