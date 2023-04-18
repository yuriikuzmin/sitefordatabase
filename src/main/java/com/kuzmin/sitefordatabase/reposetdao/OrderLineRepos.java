package com.kuzmin.sitefordatabase.reposet;

import com.kuzmin.sitefordatabase.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepos extends JpaRepository <OrderLine, Long> {
}
