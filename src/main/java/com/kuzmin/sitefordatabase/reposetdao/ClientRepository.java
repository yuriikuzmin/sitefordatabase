package com.kuzmin.sitefordatabase.reposetdao;

import com.kuzmin.sitefordatabase.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<OrderClient, Long> {
}
