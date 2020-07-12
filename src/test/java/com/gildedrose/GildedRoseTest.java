package com.gildedrose;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE;
import static com.gildedrose.GildedRose.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    @DisplayName("quality should decrease faster when sell by date is passed")
    void testQualityDecreasesFasterAfterSellByDate() {
        // given
        Item[] items = new Item[]{new Item("normal", 0, 12)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(10, app.items[0].quality);
    }

    @Test
    @DisplayName("quality should be never negative")
    void testQualityIsNeverNegative() {
        // given
        Item[] items = new Item[]{new Item("normal", 1, 0)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertFalse(app.items[0].quality < 0);
    }

    @Test
    @DisplayName("quality of Aged Brie should increase")
    void testQualityForBrieShouldIncrease() {
        // given
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("quality should increase faster when sell by date is passed for Aged Brie")
    void testQualityIncreasesFasterAfterSellByDateForBrie() {
        // given
        Item[] items = new Item[]{new Item(AGED_BRIE, -1, 12)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(14, app.items[0].quality);
    }


    @Test
    @DisplayName("quality should be never be greater then 50")
    void testQualityShouldNeverBeGreaterThen50() {
        // given
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 50)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    @DisplayName("quality of Sulfuras should never change, it has a fixed value of 80")
    void testQualityOfSulfuras() {
        // given
        Item[] items = new Item[]{new Item(SULFURAS, 10, 80)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("quality of Backstage should increase by 1 when sell by date is greater then 10")
    void testQualityShouldIncreaseBy1ForBackstage() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE, 11, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("quality of Backstage should increase by 2 when sell by date is between 10 and 5")
    void testQualityShouldIncreaseBy2ForBackstage() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE, 9, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("quality of Backstage should increase by 3 when sell by date is between 5 and 0")
    void testQualityShouldIncreaseBy3ForBackstage() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE, 3, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(13, app.items[0].quality);
    }

    @Test
    @DisplayName("quality of Backstage should be 0 when concert is over")
    void testQualityShould0ForBackstageAfterConcert() {
        // given
        Item[] items = new Item[]{new Item(BACKSTAGE, 0, 10)};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(0, app.items[0].quality);
    }

}
