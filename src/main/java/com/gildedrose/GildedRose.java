package com.gildedrose;

import com.gildedrose.items.Good;
import com.gildedrose.items.GoodsFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Good good = GoodsFactory.createInstance(item);
            good.processItem();
        }
    }
}
