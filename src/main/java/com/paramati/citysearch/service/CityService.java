package com.paramati.citysearch.service;

import com.paramati.citysearch.domain.City;

import java.util.List;

/**
 * Created by aman on 5/23/18.
 */
public interface CityService {
    List<City> findByNameStartsWithIgnoreCase(String startWith, int size);

    void saveAll(List<City> cities);

     long getCount();

     void deleteAll();
}
