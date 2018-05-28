package com.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sap.entity.Country;


public interface CountryRepository extends JpaRepository<Country, Integer>{

}
