package org.cfuentes.pricecalculator.service.commons;

import org.cfuentes.pricecalculator.exception.PriceCalculatorExcepcion;

import java.io.Serializable;
import java.util.List;

public interface CrudServiceCustom<T, ID> extends Serializable {
    T findById(ID id) throws PriceCalculatorExcepcion;

    List<T> findAll() throws PriceCalculatorExcepcion;

    boolean exists(T entity) throws PriceCalculatorExcepcion;

    boolean existsById(ID id) throws PriceCalculatorExcepcion;

    T saveOrUpdate(T entity) throws PriceCalculatorExcepcion;

    void validate(T entity) throws PriceCalculatorExcepcion;

    void delete(T entity) throws PriceCalculatorExcepcion;

    void deleteById(ID id) throws PriceCalculatorExcepcion;
}
