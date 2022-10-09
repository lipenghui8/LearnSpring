package com.liph.boot.mapper;

import com.liph.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from t_city where id=#{id}")
    public City getById(Long id);

    public void insert(City city);
}
