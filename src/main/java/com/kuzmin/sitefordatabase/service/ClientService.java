package com.kuzmin.sitefordatabase.service;

import com.kuzmin.sitefordatabase.model.OrderClient;
import com.kuzmin.sitefordatabase.reposetdao.ClientRepository;

import java.util.List;


public class ClientService {

    ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository=clientRepository;
    }
    public void save(OrderClient client){
        clientRepository.save(client);
    }
    public List<OrderClient> getAll(){
        List<OrderClient> allClient= clientRepository.findAll();
        return clientRepository.findAll();
    }
}
