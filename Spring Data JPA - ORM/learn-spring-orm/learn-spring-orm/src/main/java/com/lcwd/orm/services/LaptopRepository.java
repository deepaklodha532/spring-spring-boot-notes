package com.lcwd.orm.services;

import com.lcwd.orm.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
