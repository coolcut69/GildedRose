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
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < HIGHEST_QUALITY_VALUE) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE)) {
                        if (item.sellIn < ELEVEN_DAYS) {
                            if (item.quality < HIGHEST_QUALITY_VALUE) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < SIX_DAYS) {
                            if (item.quality < HIGHEST_QUALITY_VALUE) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < HIGHEST_QUALITY_VALUE) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
