package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkerMapper {
    List<Worker> queryWorkerList();
    User queryWorkerByID(int id);

    int addWorker(Worker worker);

    int updateWorker(Worker worker);

    int deleteWorker(int id);

}
