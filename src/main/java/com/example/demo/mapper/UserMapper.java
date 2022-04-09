package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
//表示这是一个mybatis的mapper类 ; Dao类

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
