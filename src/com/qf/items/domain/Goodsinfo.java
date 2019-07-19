package com.qf.items.domain;

public class Goodsinfo {
    private Integer id;
    private String goodsinfoName;
    private String goodsinfoPrice;
    private String goodsinfoDescription;
    private String goodsStock;

    public Goodsinfo() {
    }

    public Goodsinfo(Integer id, String goodsinfoName, String goodsinfoPrice, String goodsinfoDescription, String goodsStock) {
        this.id = id;
        this.goodsinfoName = goodsinfoName;
        this.goodsinfoPrice = goodsinfoPrice;
        this.goodsinfoDescription = goodsinfoDescription;
        this.goodsStock = goodsStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsinfoName() {
        return goodsinfoName;
    }

    public void setGoodsinfoName(String goodsinfoName) {
        this.goodsinfoName = goodsinfoName;
    }

    public String getGoodsinfoPrice() {
        return goodsinfoPrice;
    }

    public void setGoodsinfoPrice(String goodsinfoPrice) {
        this.goodsinfoPrice = goodsinfoPrice;
    }

    public String getGoodsinfoDescription() {
        return goodsinfoDescription;
    }

    public void setGoodsinfoDescription(String goodsinfoDescription) {
        this.goodsinfoDescription = goodsinfoDescription;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }
}