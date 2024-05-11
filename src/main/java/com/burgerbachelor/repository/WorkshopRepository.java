package com.burgerbachelor.repository;

import com.burgerbachelor.entity.Product;
import com.burgerbachelor.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer>
{
    Workshop getWorkshopByProduct(Product product);
}
