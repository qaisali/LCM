package com.west.lcmcalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Unit tests for LcmController.
 * Ensures that the API correctly handles valid and invalid inputs.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LcmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests that the API returns 400 Bad Request for negative numbers.
     */
    @Test
    void testNegativeNumber() throws Exception {
        mockMvc.perform(get("/api/lcm/lacmofrange/-5"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Input must be a positive integer greater than zero."));
    }

    /**
     * Tests that the API returns 400 Bad Request for non-numeric input.
     */
    @Test
    void testInvalidStringInput() throws Exception {
        mockMvc.perform(get("/api/lcm/lacmofrange/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input. Please enter a valid positive integer."));
    }

    /**
     * Tests that the API returns 400 Bad Request for non-numeric input.
     */
    @Test
    void testValidInput() throws Exception {
        mockMvc.perform(get("/api/lcm/lacmofrange/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }
}
