package com.demo.dairy.web.controller;

import com.demo.dairy.services.MilkService;
import com.demo.dairy.web.model.MilkDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@WebMvcTest(MilkController.class)
class MilkControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MilkService milkService;

    @Autowired
    ObjectMapper objectMapper;

    MilkDTO validMilk;

    @BeforeEach
    void setUp() {
        validMilk = MilkDTO.builder()
                .id(UUID.randomUUID())
                .milkName("Aavin")
                .milkType("Green Magic")
                .upc(123456789012L)
                .build();
    }

    @Test
    void getMilk() throws Exception {

        given(milkService.getMilkById(any(UUID.class))).willReturn(validMilk);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/milk/" + UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void handlePost() throws Exception {

        given(milkService.saveNewMilk(any())).willReturn(validMilk);
        String milkDTOJson = objectMapper.writeValueAsString(validMilk);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/milk/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void handleUpdate() throws Exception {

        String milkDTOJson = objectMapper.writeValueAsString(validMilk);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/milk/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        then(milkService).should().updateMilkById(any(),any());
    }

    @Test
    void handleDelete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/milk/" + UUID.randomUUID()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}