package com.kuzmin.sitefordatabase.reposetdao;

import com.kuzmin.sitefordatabase.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
