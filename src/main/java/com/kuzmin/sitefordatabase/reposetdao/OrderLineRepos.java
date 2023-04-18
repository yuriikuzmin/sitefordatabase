package com.kuzmin.sitefordatabase.reposetdao;

import com.kuzmin.sitefordatabase.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepos extends JpaRepository <OrderLine, Long> {
}
