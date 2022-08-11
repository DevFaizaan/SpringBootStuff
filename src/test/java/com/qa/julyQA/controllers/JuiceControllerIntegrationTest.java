package com.qa.julyQA.controllers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.julyQA.domain.Juice;

import jdk.jfr.ContentType;
import org.springframework.http.MediaType;
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:juiceSchema.sql",
"classpath:juiceData.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class JuiceControllerIntegrationTest {

	
	@Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        Juice testJuice = new Juice("caprisun",500, 2.99);
        RequestBuilder req = post("/makeJuice").content(this.mapper.writeValueAsString(testJuice))
        		.contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        Juice testSavedFlower = new Juice("caprisun", 500, 2.99);
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedFlower));

    }
    
   
    @Test
    void testCreateButHardToRead() throws Exception {
        this.mock.perform(post("/createJuice").content(this.mapper.writeValueAsString(new Juice("caprisun",500, 2.99)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.mapper.writeValueAsString(new Juice(1,"caprisun",500, 2.99))));
    }
    
    @Test
	void testGet() throws Exception {
		List<Juice> juice = List.of(new Juice(1, "juices", 12, 44.94),
				new Juice(2, "juice", 24, 50));

		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(juice));
		this.mock.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
	}

	@Test
	void testGetById() throws Exception {
		ResultMatcher checkBody = content()
				.json(this.mapper.writeValueAsString(new Juice(1, "juice", 12, 44.94)));

		this.mock.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
	}
	
    @Test
    void testUpdateById() throws Exception {
        this.mock.perform(
                        patch("/update/1")
                                .param("name", "Caprisun")
                                .param("amount", "500")
                                .param("cost", "2.99"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(new Juice(1, "Caprisun", 500, 2.99))));
    }
	
	
	@Test
	void testDelete() throws Exception{
		List<Juice> juice = List.of(new Juice(1, "juice", 12, 44.94),
				new Juice(2, "juice", 24, 50));
		ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(juice));
		this.mock.perform(delete("/remove/1"));
	}

    
}
