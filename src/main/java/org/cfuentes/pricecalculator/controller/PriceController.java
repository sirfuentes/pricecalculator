package org.cfuentes.pricecalculator.controller;

import org.cfuentes.pricecalculator.model.Price;
import org.cfuentes.pricecalculator.service.crud.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("price")
public class PriceController {

    @Autowired
    PriceService priceService;


    @GetMapping()
    @ResponseBody
    public ResponseEntity<Price> priceByDate(@RequestParam(value="appDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date appDate,
                                             @RequestParam(value="productId", required = true) Long productId,
                                             @RequestParam(value="brandId", required = true) Long brandId) {
        try {
            return new ResponseEntity<>(
                    priceService.findPriceListByDateProductBrand(appDate, productId, brandId),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            return new ResponseEntity<Price>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
