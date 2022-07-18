package org.cfuentes.pricecalculator.service.crud.impl;

import org.cfuentes.pricecalculator.dao.repository.PriceRepository;
import org.cfuentes.pricecalculator.exception.PriceCalculatorExcepcion;
import org.cfuentes.pricecalculator.model.Price;
import org.cfuentes.pricecalculator.service.crud.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price findById(Long aLong) throws PriceCalculatorExcepcion {
        return priceRepository.findById(aLong).get();
    }

    @Override
    public List<Price> findAll() throws PriceCalculatorExcepcion {
        return null;
    }

    @Override
    public boolean exists(Price entity) throws PriceCalculatorExcepcion {
        return false;
    }

    @Override
    public boolean existsById(Long aLong) throws PriceCalculatorExcepcion {
        return false;
    }

    @Override
    public Price saveOrUpdate(Price entity) throws PriceCalculatorExcepcion {
        return null;
    }

    @Override
    public void validate(Price entity) throws PriceCalculatorExcepcion {

    }

    @Override
    public void delete(Price entity) throws PriceCalculatorExcepcion {

    }

    @Override
    public void deleteById(Long aLong) throws PriceCalculatorExcepcion {

    }

    @Override
    public Price findPriceListByDateProductBrand(Date appDate, Long productId, Long brandId) {
        return priceRepository.findPriceListByDateProductBrand(appDate, productId, brandId);
    }
}
