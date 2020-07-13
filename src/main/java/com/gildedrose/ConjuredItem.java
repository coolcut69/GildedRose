package com.gildedrose;

public class ConjuredItem extends AbstractGood implements Good {

    protected ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item, DOUBLE_DEGRADE_FACTOR);
    }

    @Override
    public void updateQualityAfterExpiration() {
        decreaseQuality(item, DOUBLE_DEGRADE_FACTOR);
    }
}
