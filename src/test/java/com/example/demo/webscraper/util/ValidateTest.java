package com.example.demo.webscraper.util;

import org.junit.jupiter.api.Test;

import static com.example.demo.webscraper.util.Validate.validateJavaDate;
import static com.example.demo.webscraper.util.Validate.validateSymbol;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateTest {

    @Test
    void validateJavaDate_Test() {
        assertEquals(false, validateJavaDate("sd"));
        assertEquals(false, validateJavaDate("1900/05/10"));

        assertEquals(true, validateJavaDate("1900-10-05"));
    }

    @Test
    void validateSymbol_Test() {
        assertEquals(false, validateSymbol("ASDFGH"));
        assertEquals(false, validateSymbol("MAR1"));

        assertEquals(true, validateSymbol("MARA"));
        assertEquals(true, validateSymbol("MARAK"));
    }
}