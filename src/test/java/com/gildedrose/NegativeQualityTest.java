package com.gildedrose;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE;
import static com.gildedrose.GildedRose.CONJURED;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NegativeQualityTest {

    @ParameterizedTest
    @DisplayName("quality should be never negative")
    @MethodSource("provideItemsForNegativeCheck")
    void testQualityIsNeverNegative(Item item) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertFalse(app.items[0].quality < 0);
    }

    private static Stream<Arguments> provideItemsForNegativeCheck() {
        return Stream.of(
                Arguments.of(new Item(CONJURED, 1, 1)),
                Arguments.of(new Item(AGED_BRIE, 1, 1)),
                Arguments.of(new Item(BACKSTAGE, 1, 1)),
                Arguments.of(new Item("normal", 1, 1)),
                Arguments.of(new Item(CONJURED, 0, 1)),
                Arguments.of(new Item(AGED_BRIE, 0, 1)),
                Arguments.of(new Item(BACKSTAGE, 0, 1)),
                Arguments.of(new Item("normal", 0, 1))
        );
    }
}
