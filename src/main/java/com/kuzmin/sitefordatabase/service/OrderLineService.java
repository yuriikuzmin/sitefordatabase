package com.kuzmin.sitefordatabase.service;

import com.kuzmin.sitefordatabase.model.Goods;
import com.kuzmin.sitefordatabase.model.OrderLine;
import com.kuzmin.sitefordatabase.reposetdao.GoodsRepository;
import com.kuzmin.sitefordatabase.reposetdao.OrderLineRepos;

import java.util.List;

public class OrderLineService {
   OrderLineRepos orderLineRepos;

    public OrderLineService() {
        this.orderLineRepos = orderLineRepos;
    }

    public void save(OrderLine orderLine){
        orderLineRepos.save(orderLine);
    }
    public List<OrderLine> getAll(){
        List<OrderLine> all=orderLineRepos.findAll();
        return orderLineRepos.findAll();
    }
}
