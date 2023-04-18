package com.kuzmin.sitefordatabase.reposet;

import com.kuzmin.sitefordatabase.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderClient, Long> {
}