package com.gildedrose;

class GildedRose {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    static final String CONJURED = "Conjured";

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
        switch (item.name) {
            case AGED_BRIE:
                increaseQuality(item);
                break;
            case CONJURED:
                decreaseQuality(item);
                decreaseQuality(item);
                break;
            case BACKSTAGE:
                increaseQuality(item);
                if (item.quality < HIGHEST_QUALITY_VALUE) {
                    if (item.sellIn < ELEVEN_DAYS) {
                        increaseQuality(item);
                    }
                    if (item.sellIn < SIX_DAYS) {
                        increaseQuality(item);
                    }
                }
                break;
            default:
                decreaseQuality(item);
                break;
        }
    }

    private void processExpiredItems(Item item) {
        if (item.sellIn < 0) {
            switch (item.name) {
                case AGED_BRIE:
                    increaseQuality(item);
                    break;
                case CONJURED:
                    decreaseQuality(item);
                    decreaseQuality(item);
                    break;
                case BACKSTAGE:
                    item.quality = 0;
                    break;
                default:
                    decreaseQuality(item);
                    break;
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
