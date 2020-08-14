package com.example.demo.util;

import com.example.demo.controllers.messages.MorningPanicEnvelope;
import org.junit.jupiter.api.Test;

import static com.example.demo.util.Validate.isTime;
import static com.example.demo.util.Validate.validate_MorningPanicEnvelope;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    @Test
    void isTime_Test() {
        assertEquals(false, isTime("HOOPLA"));
        assertEquals(false, isTime("AA:AA"));
        assertEquals(false, isTime("109:30"));
        assertEquals(false, isTime("a9:30"));
        assertEquals(true,  isTime("9:30"));
        assertEquals(true,  isTime("10:30"));
    }

    @Test
    void validate_MorningPanicEnvelope_Test() {
        MorningPanicEnvelope envelope = new MorningPanicEnvelope();
        assertEquals(true, validate_MorningPanicEnvelope(envelope).valid);
    }

}