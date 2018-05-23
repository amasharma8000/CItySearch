package com.paramati.citysearch.service;

import com.paramati.citysearch.dao.CityDao;
import com.paramati.citysearch.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aman on 5/23/18.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> findByNameStartsWithIgnoreCase(String keyword, int atmost) {
        return cityDao.findByNameStartsWithIgnoreCase(keyword, new PageRequest(0, atmost));
    }

    @Override
    public void saveAll(List<City> cities) {
        cityDao.saveAll(cities);

    }

    @Override
    public long getCount() {
        return cityDao.count();
    }

    @Override
    public void deleteAll() {
        cityDao.deleteAll();
    }


}
