package com.gildedrose;


import static com.gildedrose.ItemType.AGED_BRIE;
import static com.gildedrose.ItemType.BACKSTAGE;
import static com.gildedrose.ItemType.CONJURED;
import static com.gildedrose.ItemType.SULFURAS;

public class GoodsFactory {

    private GoodsFactory() {
        //don't instantiate
    }

    public static Good createInstance(Item item) {
        Good result;

        if (item.name.equals(AGED_BRIE.getLabel())) {
            result = new BrieItem(item);
        } else if (SULFURAS.getLabel().equals(item.name)) {
            result = new SulfurasItem(item);
        } else if (BACKSTAGE.getLabel().equals(item.name)) {
            result = new BackStageItem(item);
        } else if ((item.name.startsWith(CONJURED.getLabel()))) {
            result = new ConjuredItem(item);
        } else {
            result = new DefaultItem(item);
        }
        return result;
    }

}
