package com.paramati.citysearch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.paramati.citysearch.domain.City;
import com.paramati.citysearch.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by aman on 5/23/18.
 */

@Component
public class CityDataInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityDataInit.class);

    @Autowired
    private CityService cityService;


    @EventListener
    public void createAdminUser(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            System.out.println("Init City Data...");
            Resource resource = new ClassPathResource("cities.json");
            Gson gson = new Gson();
            List<City> cities = gson.fromJson(new BufferedReader(new InputStreamReader(resource.getInputStream())), new TypeToken<List<City>>() {
            }.getType());
            if (cityService.getCount() != cities.size()) {
                cityService.deleteAll();
                cityService.saveAll(cities);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
