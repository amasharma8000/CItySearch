package com.paramati.citysearch.dao;

import com.paramati.citysearch.domain.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aman on 5/22/18.
 */
@Repository
public interface CityDao extends CrudRepository<City, Long>, JpaSpecificationExecutor<City> {

    List<City> findByNameStartsWithIgnoreCase(String keyword, Pageable pageable);

}
