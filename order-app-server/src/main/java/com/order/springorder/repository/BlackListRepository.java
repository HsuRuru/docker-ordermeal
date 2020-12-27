package com.order.springorder.repository;

import com.order.springorder.model.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList,Long> {
    BlackList findByBlackToken(String blackToken);
}
