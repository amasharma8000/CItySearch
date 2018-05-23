package com.paramati.citysearch.controller;

import com.paramati.citysearch.domain.City;
import com.paramati.citysearch.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by aman on 5/22/18.
 */
@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/suggest_cities", method = RequestMethod.GET,
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity getSuggestedCities(@RequestParam(value = "start") String start, @RequestParam(value = "atmost") int atmost
    ) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
        List<City> cityList = cityService.findByNameStartsWithIgnoreCase(start, atmost);
        StringBuilder cities = new StringBuilder();
        cityList.forEach(city -> {
            cities.append(city.getName()).append("\n");
        });
        return new ResponseEntity(cities.toString().isEmpty() ? "NA" : cities.toString(), httpHeaders, HttpStatus.OK);

    }
}
