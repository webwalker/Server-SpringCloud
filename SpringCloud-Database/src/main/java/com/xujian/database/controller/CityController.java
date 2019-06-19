package com.xujian.database.controller;

import com.xujian.database.entity.City;
import com.xujian.database.mapper.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by xujian on 2019-06-19
 */
@RestController
public class CityController {


    @Autowired
    private CityRepository cityRepository;


    //http://localhost:8888/saveCity?cityName=北京&cityIntroduce=中国首都
    @GetMapping(value = "saveCity")
    public String saveCity(String cityName, String cityIntroduce) {
        City city = new City(cityName, cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    //http://localhost:8888/deleteCity?cityId=2
    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId) {
        City city = new City();
        city.setCityId(cityId);
        cityRepository.delete(city);
        return "success";
    }

    //http://localhost:8888/updateCity?cityId=3&cityName=沈阳&cityIntroduce=辽宁省省会
    @GetMapping(value = "updateCity")
    public String updateCity(int cityId, String cityName, String cityIntroduce) {
        City city = new City(cityId, cityName, cityIntroduce);
        cityRepository.save(city);
        return "success";
    }


    //http://localhost:8888/getCityById?cityId=3
    @GetMapping(value = "getCityById")
    public Optional<City> getCityById(int cityId) {
        City city1 = new City();
        city1.setCityId(cityId);
        Example<City> example = Example.of(city1);
        Optional<City> city = cityRepository.findOne(example);
        return city;
    }
}
