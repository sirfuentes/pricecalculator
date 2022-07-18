package org.cfuentes.pricecalculator.service.crud;

import org.cfuentes.pricecalculator.model.Price;
import org.cfuentes.pricecalculator.service.commons.CrudServiceCustom;

import java.util.Date;

public interface PriceService extends CrudServiceCustom<Price, Long> {
    Price findPriceListByDateProductBrand(Date appDate, Long productId, Long brandId);
}
