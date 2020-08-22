package com.example.demo.common.util;

import com.example.demo.morningpanic.models.Envelope;
import org.junit.jupiter.api.Test;

import static com.example.demo.common.util.Validate.isTime;
import static com.example.demo.common.util.Validate.validateMorningPanicEnvelope;
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
        Envelope envelope = new Envelope();
        assertEquals(true, validateMorningPanicEnvelope(envelope).valid);
    }

}