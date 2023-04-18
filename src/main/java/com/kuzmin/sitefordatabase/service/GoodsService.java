package com.kuzmin.sitefordatabase.service;


import com.kuzmin.sitefordatabase.model.Goods;
import com.kuzmin.sitefordatabase.reposetdao.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    GoodsRepository goodsRepository;
    public GoodsService() {
        this.goodsRepository = goodsRepository;
    }

    public void save(Goods goods){
        goodsRepository.save(goods);
    }

    public List<Goods> getAll(){
       List<Goods> all= goodsRepository.findAll();
       return goodsRepository.findAll();
    }
}
