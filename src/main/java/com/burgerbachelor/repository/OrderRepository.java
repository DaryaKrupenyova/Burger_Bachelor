package com.burgerbachelor.repository;

import com.burgerbachelor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
