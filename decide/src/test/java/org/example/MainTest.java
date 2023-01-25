package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @DisplayName("Square")
    void square() {
        assertEquals(4, Main.square(2));
        assertEquals(4, Main.square(-2));
        assertEquals(16, Main.square(4));
        assertEquals(9, Main.square(3));
        assertEquals(64, Main.square(8));
    }
}