package com.kuzmin.sitefordatabase.model;

import jakarta.persistence.*;

@Entity
@Table(name="GOODS")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    private String nameGoods, price;

    public Goods() {
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Goods(String nameGoods, String price) {
        this.nameGoods = nameGoods;
        this.price = price;

    }


}
