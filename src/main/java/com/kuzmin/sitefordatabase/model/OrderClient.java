package com.kuzmin.dbh2.dbase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERCLIENT")
public class OrderClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="client")
    private String client;

    @Column(name="dateOrder")
    private String dateOrder;

    @Column(name = "address")
    private String address;

    public OrderClient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




}
