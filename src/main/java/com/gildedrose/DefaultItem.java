package com.gildedrose;

public class DefaultItem extends AbstractGood implements Good {

    public DefaultItem(Item item) {
        this.item = item;
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
