package com.gildedrose;

public class SulfurasItem extends AbstractGood implements Good {

    protected SulfurasItem(Item item) {
        super(item);
        item.quality = 80;
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
