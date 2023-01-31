package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test //getsAllMovies
    public void test_case1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/allMovies")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test //getsSingleMovie
    public void test_case2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    
   @Test //deleteSingleMovie
    public void test_case3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/movie/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test //returnsNotFoundForInvalidSingleRide
    public void test_case4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    
	@Test //getsAllMovies
    public void test_case5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/allBooking")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}





