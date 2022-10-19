package com.example.testjavabcnc;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.testjavabcnc.entity.Price;
import com.example.testjavabcnc.entity.PriceResponse;
import com.example.testjavabcnc.service.MyService;
import java.util.Collections;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestjavabcncApplicationTests {

    @Autowired
    ModelMapper modelMapper;

    @MockBean
    private MyService myService;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        Price price = new Price();
        price.setProduct_id(35455);
        price.setBrand_id(1);
        price.setStart_date(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
        price.setEnd_date(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        price.setPrice_list(1);
        price.setPrice(35.50);
        price.setCurr("EUR");
        price.setEnd_date(LocalDateTime.of(2020, 06, 14, 10, 00, 00));
        price.setLast_update_by("User Test");
        given(myService.getAllPrices()).willReturn(Collections.singletonList(price));
        PriceResponse priceResponse = modelMapper.map(price, PriceResponse.class);
        given(myService.getAllPricesWith(LocalDateTime.of(2020, 06, 14, 00, 00, 00),35455,1)).willReturn(Collections.singletonList(priceResponse));
    }

    @Test
    public void testGetAllPrices() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prices/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].start_date").value("2020-06-14T00:00:00"));
               
    }

    
    @Test
    public void testGet() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prices?date=2020-06-14T00:00:00&productId=35455&brandId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].start_date").value("2020-06-14T00:00:00"));
    }





    @Test
    public void testGetWithNoParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
