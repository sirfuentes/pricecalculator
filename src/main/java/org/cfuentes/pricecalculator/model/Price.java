package org.cfuentes.pricecalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRICES")
public class Price {
    public Price() {
    }

    public Price(Long priceList, Long brandId, Date startDate, Date endDate, Long productId, Long priority, Double price, String curr) {
        this.priceList = priceList;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    @Column(name = "START_DATE")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    @JsonIgnore
    private Long priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    @JsonIgnore
    private String curr;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
