package com.gildedrose;

class GildedRose {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private static final int HIGHEST_QUALITY_VALUE = 50;
    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (SULFURAS.equals(item.name)) {
                continue;
            }
            updateQuality(item);
            item.sellIn = item.sellIn - 1;
            processExpiredItems(item);
        }
    }

    private void updateQuality(Item item) {
        if (AGED_BRIE.equals(item.name)
                || BACKSTAGE.equals(item.name)) {
            if (item.quality < HIGHEST_QUALITY_VALUE) {
                item.quality = item.quality + 1;

                if (BACKSTAGE.equals(item.name)) {
                    if (item.sellIn < ELEVEN_DAYS) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < SIX_DAYS) {
                        increaseQuality(item);
                    }
                }
            }
        } else {
            decreaseQuality(item);
        }
    }

    private void processExpiredItems(Item item) {
        if (item.sellIn < 0) {
            if (AGED_BRIE.equals(item.name)) {
                increaseQuality(item);
            } else {
                if (BACKSTAGE.equals(item.name)) {
                    item.quality = 0;
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < HIGHEST_QUALITY_VALUE) {
            item.quality = item.quality + 1;
        }
    }
}
