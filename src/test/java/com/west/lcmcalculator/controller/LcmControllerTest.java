package com.west.lcmcalculator.controller;

import com.west.lcmcalculator.service.LcmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;

import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link LcmController}.
 * Ensures that the API correctly handles valid and invalid inputs.
 */
@WebMvcTest(LcmController.class)
class LcmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LcmService lcmService;

    /**
     * Tests valid LCM calculation request.
     */
    @Test
    void testGetLcm_ValidInput() throws Exception {
        when(lcmService.calculateLcmOfRange(10)).thenReturn(BigInteger.valueOf(2520));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/lcm/v1/lcmofrange/10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("2520"));
    }

    /**
     * Tests invalid input (negative number) handling.
     */
    @Test
    void testGetLcm_NegativeInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/lcm/v1/lcmofrange/-5"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Input must be a positive integer greater than zero."));
    }

    /**
     * Tests invalid input (non-numeric) handling.
     */
    @Test
    void testGetLcm_NonNumericInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/lcm/v1/lcmofrange/abc"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Invalid input. Please enter a valid positive integer."));
    }
}