package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    void passingTest() {

        int a = 10;
        int b = 5;
        String name = "Abhiram";
        String empty = null;

        assertEquals(15, a + b);
        assertTrue(a > b);
        assertFalse(a < b);
        assertNull(empty);
        assertNotNull(name);
        assertNotEquals(20, a + b);
        assertSame(name, name);
        assertNotSame(name, new String("Abhiram"));
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertThrows(ArithmeticException.class, () -> {
            int x = 10 / 0;
        });
    }

    @Test
    void failingTest() {

        assertEquals(10, 2 + 3);
        assertTrue(5 < 3);
        assertFalse(5 > 3);
        assertNull("Hello");
        assertNotNull(null);
        assertNotEquals(5, 2 + 3);
        assertSame(new String("Java"), new String("Java"));
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2, 3});
    }
}