package org.cfuentes.pricecalculator.controller;

import org.cfuentes.pricecalculator.model.Price;
import org.cfuentes.pricecalculator.service.crud.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PriceService priceService;


    @Test
    void priceByDate1() throws Exception {
        Calendar start = new GregorianCalendar(2020, 05, 14, 00, 00);
        Calendar app = new GregorianCalendar(2020, 5, 14, 10, 00);
        Calendar end = new GregorianCalendar(2020, 11, 31, 23, 59, 59);

        when(priceService.findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1)).thenReturn(new Price(1L, 1L, start.getTime(), end.getTime(), 35455L, 0L, 35.50, "EUR"));

        mockMvc.perform(get("/price?appDate=2020-06-14-10.00.00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("startDate").value("2020-06-14-00.00.00"))
                .andExpect(jsonPath("endDate").value("2020-12-31-23.59.59"))
                .andExpect(jsonPath("priceList").value(1))
                .andExpect(jsonPath("productId").value(35455))
                .andExpect(jsonPath("price").value(35.50));

        verify(priceService).findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1);
    }

    @Test
    void priceByDate2() throws Exception {
        Calendar start = new GregorianCalendar(2020, 05, 14, 15, 00);
        Calendar app = new GregorianCalendar(2020, 5, 14, 16, 00);
        Calendar end = new GregorianCalendar(2020, 5, 14, 18, 30);


        when(priceService.findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1)).thenReturn(new Price(2L, 1L, start.getTime(), end.getTime(), 35455L, 1L, 25.45, "EUR"));

        mockMvc.perform(get("/price?appDate=2020-06-14-16.00.00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("startDate").value("2020-06-14-15.00.00"))
                .andExpect(jsonPath("endDate").value("2020-06-14-18.30.00"))
                .andExpect(jsonPath("priceList").value(2))
                .andExpect(jsonPath("productId").value(35455))
                .andExpect(jsonPath("price").value(25.45));

        verify(priceService).findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1);
    }

    @Test
    void priceByDate3() throws Exception {
        Calendar app = new GregorianCalendar(2020, 5, 14, 21, 00);
        Calendar end = new GregorianCalendar(2020, 11, 31, 23, 59, 59);
        Calendar start = new GregorianCalendar(2020, 05, 14, 00, 00);

        when(priceService.findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1)).thenReturn(new Price(1L, 1L, start.getTime(), end.getTime(), 35455L, 0L, 35.50, "EUR"));

        mockMvc.perform(get("/price?appDate=2020-06-14-21.00.00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("startDate").value("2020-06-14-00.00.00"))
                .andExpect(jsonPath("endDate").value("2020-12-31-23.59.59"))
                .andExpect(jsonPath("priceList").value(1))
                .andExpect(jsonPath("productId").value(35455))
                .andExpect(jsonPath("price").value(35.50));

        verify(priceService).findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1);
    }

    @Test
    void priceByDate4() throws Exception {
        Calendar start = new GregorianCalendar(2020, 5, 15, 00, 00);
        Calendar app = new GregorianCalendar(2020, 5, 15, 10, 00);
        Calendar end = new GregorianCalendar(2020, 5, 15, 11, 00);

        when(priceService.findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1)).thenReturn(new Price(3L, 1L, start.getTime(), end.getTime(), 35455L, 1L, 30.5, "EUR"));

        mockMvc.perform(get("/price?appDate=2020-06-15-10.00.00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("startDate").value("2020-06-15-00.00.00"))
                .andExpect(jsonPath("endDate").value("2020-06-15-11.00.00"))
                .andExpect(jsonPath("priceList").value(3))
                .andExpect(jsonPath("productId").value(35455))
                .andExpect(jsonPath("price").value(30.5));

        verify(priceService).findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1);
    }

    @Test
    void priceByDate5() throws Exception {
        Calendar start = new GregorianCalendar(2020, 05, 15, 16, 00);
        Calendar app = new GregorianCalendar(2020, 5, 16, 21, 00);
        Calendar end = new GregorianCalendar(2020, 11, 31, 23, 59, 59);

        when(priceService.findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1)).thenReturn(new Price(4L, 1L, start.getTime(), end.getTime(), 35455L, 1L, 38.95, "EUR"));

        mockMvc.perform(get("/price?appDate=2020-06-16-21.00.00&productId=35455&brandId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("startDate").value("2020-06-15-16.00.00"))
                .andExpect(jsonPath("endDate").value("2020-12-31-23.59.59"))
                .andExpect(jsonPath("priceList").value(4))
                .andExpect(jsonPath("productId").value(35455))
                .andExpect(jsonPath("price").value(38.95));

        verify(priceService).findPriceListByDateProductBrand(app.getTime(), (long)(35455), (long)1);
    }
}