package com.indiamart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "SELLER_ID")
    private String sellerId;

    public Product withName(String name){
        this.name = name;
        return this;
    }
    public Product withType(String type){
        this.type = type;
        return this;
    }
    public Product withCategory(String category){
        this.category = category;
        return this;
    }
    public Product withPrice(String price){
        this.price = price;
        return this;
    }
    public Product withSellerId(String sellerId){
        this.sellerId = sellerId;
        return this;
    }
}
