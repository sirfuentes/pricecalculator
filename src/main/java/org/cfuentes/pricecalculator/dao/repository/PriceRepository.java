package org.cfuentes.pricecalculator.dao.repository;

import org.cfuentes.pricecalculator.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

//    @Query("SELECT p FROM Price p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2 AND p.brandId = ?3 ORDER BY p.priority DESC")
    @Query(value = "SELECT * FROM PRICES P WHERE P.START_DATE <= ?1 AND P.END_DATE >= ?1 AND P.PRODUCT_ID = ?2 AND P.BRAND_ID = ?3 ORDER BY P.PRIORITY DESC LIMIT 1", nativeQuery = true)
    Price findPriceListByDateProductBrand(Date appDate, Long productId, Long brandId);
}
