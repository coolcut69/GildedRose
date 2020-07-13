package com.gildedrose;

public class SulfurasItem extends AbstractGood implements Good {

    public SulfurasItem(Item item) {
        item.quality = 80;
        this.item = item;
    }

    @Override
    public void updateQuality() {
        // do nothing
    }

    @Override
    public void updateQualityAfterExpiration() {
        // do nothing
    }
}
