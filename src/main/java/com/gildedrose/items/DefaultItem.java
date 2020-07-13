package com.gildedrose.items;

import com.gildedrose.Item;

class DefaultItem extends AbstractGood implements Good {

    protected DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item);
    }

    @Override
    public void updateQualityAfterExpiration() {
        decreaseQuality(item);
    }
}
