package com.gildedrose.items;

import com.gildedrose.Item;

class BrieItem extends AbstractGood implements Good {

    protected BrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality(item);
    }

    @Override
    public void updateQualityAfterExpiration() {
        increaseQuality(item);
    }
}
