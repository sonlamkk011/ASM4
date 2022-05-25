package com.example.asm4.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConectionHelperTest {

    @Test
    void getConnection() {
        assertNotEquals(null, ConectionHelper.getConnection());
    }
}