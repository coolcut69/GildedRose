package com.gildedrose;

import static com.gildedrose.ItemType.AGED_BRIE;
import static com.gildedrose.ItemType.BACKSTAGE;
import static com.gildedrose.ItemType.CONJURED;
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
                Arguments.of(new Item(CONJURED.getLabel(), 1, 1)),
                Arguments.of(new Item(AGED_BRIE.getLabel(), 1, 1)),
                Arguments.of(new Item(BACKSTAGE.getLabel(), 1, 1)),
                Arguments.of(new Item("normal", 1, 1)),
                Arguments.of(new Item(CONJURED.getLabel(), 0, 1)),
                Arguments.of(new Item(AGED_BRIE.getLabel(), 0, 1)),
                Arguments.of(new Item(BACKSTAGE.getLabel(), 0, 1)),
                Arguments.of(new Item("normal", 0, 1))
        );
    }
}
