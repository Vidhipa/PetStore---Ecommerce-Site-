package com.ecommerce.products.controller;

import org.apache.commons.lang.StringUtils;

public class PojoMerchantDetails {
    private int merchantId;
    private String merchantName;
    private double merchantRating;

    public double getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(double merchantRating) {
        this.merchantRating = merchantRating;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String mechantName) {
        this.merchantName = mechantName;
    }


    public PojoMerchantDetails(int merchantId, String merchantName) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }

}
