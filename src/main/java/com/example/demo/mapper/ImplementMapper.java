package com.example.demo.mapper;

import com.example.demo.pojo.Implements;
import com.example.demo.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImplementMapper {
    List<Implements> queryImplementList();
}
