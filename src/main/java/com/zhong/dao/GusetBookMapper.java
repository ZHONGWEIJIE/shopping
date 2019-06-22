package com.zhong.dao;

import com.zhong.entity.GuestBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import java.util.List;

@Mapper
public interface GusetBookMapper {
    public List<GuestBook> selectGusetBookByAdminId();


}
