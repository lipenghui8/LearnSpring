package com.liph.boot.service.impl;

import com.liph.boot.bean.City;
import com.liph.boot.mapper.CityMapper;
import com.liph.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Li
 * @create: 2022-10-11 13:14
 **/
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;


    public City getById(Long id){
        return cityMapper.getById(id);
    }


    public void saveCity(City city){
        cityMapper.insert(city);
    }
}
