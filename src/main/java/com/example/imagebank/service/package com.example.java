package com.example.imagebank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImageBankApplicationTestsTest {

    @Test
    void testContextLoadsDoesNotThrow() {
        ImageBankApplicationTests tests = new ImageBankApplicationTests();
        assertDoesNotThrow(tests::contextLoads, "contextLoads should not throw any exception");
    }
}