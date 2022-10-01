package com.company;

import org.junit.jupiter.api.Test;


import static com.company.Main.makeReadableWithHashMap;
import static com.company.Main.makeReadableWithIf;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void test_makeReadableWithHashMap_62() {
        assertEquals("1 minute 2 second ", makeReadableWithHashMap(62));
    }

    @Test
    void test_makeReadableWithHashMap_3662() {
        assertEquals("1 hour 1 minute 2 second ", makeReadableWithHashMap(3662));
    }

    @Test
    void test_makeReadableWithHashMap_11200() {
        assertEquals("3 hour 6 minute 40 second ", makeReadableWithHashMap(11200));
    }

    @Test
    void test_makeReadableWithHashMap_zero() {
        assertEquals("now", makeReadableWithHashMap(0));
    }

    @Test
    void test_makeReadableWithHashMap_negative() {
        assertThrows(IllegalArgumentException.class, () -> makeReadableWithHashMap(-33));
    }

    @Test
    void test_makeReadableWithIf_62() {
        assertEquals("1 minute 2 second", makeReadableWithIf(62));
    }

    @Test
    void test_makeReadableWithIf_3662() {
        assertEquals("1 hour 1 minute 2 second", makeReadableWithIf(3662));
    }

    @Test
    void test_makeReadableWithIf_11200() {
        assertEquals("3 hour 6 minute 40 second", makeReadableWithIf(11200));
    }

    @Test
    void test_makeReadableWithIf_zero() {
        assertEquals("now", makeReadableWithIf(0));
    }

    @Test
    void test_makeReadableWithIf_negative() {
        assertThrows(IllegalArgumentException.class, () -> makeReadableWithIf(-33));
    }

}
