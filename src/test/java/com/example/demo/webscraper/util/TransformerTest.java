package com.example.demo.webscraper.util;

import org.junit.jupiter.api.Test;

import static com.example.demo.webscraper.util.Transformer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TransformerTest {

    @Test
    void transform_to_number_Test() {
        assertEquals(100000000000L, transform_to_number("100B"));
        assertEquals(100123000000L, transform_to_number("100.123B"));
        assertEquals(100000000L, transform_to_number("100M"));
        assertEquals(100120000L, transform_to_number("100.12M"));
        assertEquals(100000L, transform_to_number("100k"));
        assertEquals(100100L, transform_to_number("100.1k"));
        assertEquals(100, transform_to_number("100"));
        assertEquals(-3, transform_to_number("-3"));
        assertEquals(-1, transform_to_number("a"));
        assertEquals(-1, transform_to_number("10AB"));
    }

    @Test
    void transform_to_unit_Test() {
        assertEquals("1B", transform_to_unit(1000000000));
        assertEquals("1M", transform_to_unit(1000000));
        assertEquals("1k", transform_to_unit(1000));
        assertEquals("100", transform_to_unit(100));
    }

    @Test
    void unit_multiplier_Test() {
        assertEquals(1000000000, unit_multiplier("B"));
        assertEquals(1000000, unit_multiplier("M"));
        assertEquals(1000, unit_multiplier("k"));
        assertEquals(1, unit_multiplier("1"));
        assertEquals(1, unit_multiplier("100"));
    }


    @Test
    void round_Test(){
        assertEquals(10.01, round(10.0111111111, 2));
        assertEquals(10.00, round(10, 2));
        assertEquals(0.0, round(0.01, 1));
        assertEquals(10, round(10.111, 0));
        assertEquals(-1.8, round(-1.7894325,1));
        assertEquals(-1.5, round(-1.4894325,1));
    }
}