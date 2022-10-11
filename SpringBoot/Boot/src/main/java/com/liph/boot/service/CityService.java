package com.liph.boot.service;

import com.liph.boot.bean.City;
import com.liph.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Li
 * @create: 2022-10-09 10:52
 **/
public interface CityService {
    City getById(Long id);

    void saveCity(City city);
}
