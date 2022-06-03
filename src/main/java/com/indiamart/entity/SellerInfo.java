package com.indiamart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sellerinfo")
@Getter
@Setter
@ToString
public class SellerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "SELLER_ID")
    private String sellerId;

    @Column(name = "SELLER_NAME")
    private String sellerName;
}
