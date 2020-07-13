package com.gildedrose;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE;
import static com.gildedrose.GildedRose.CONJURED;
import static com.gildedrose.GildedRose.SULFURAS;

public class GoodsFactory {

    private GoodsFactory() {
        //don't instantiate
    }

    public static Good createInstance(Item item) {
        Good result;

        if (item.name.equals(AGED_BRIE)) {
            result = new BrieItem(item);
        } else if (SULFURAS.equals(item.name)) {
            result = new SulfurasItem(item);
        } else if (BACKSTAGE.equals(item.name)) {
            result = new BackStageItem(item);
        } else if ((item.name.startsWith(CONJURED))) {
            result = new ConjuredItem(item);
        } else {
            result = new DefaultItem(item);
        }
        return result;
    }

}
