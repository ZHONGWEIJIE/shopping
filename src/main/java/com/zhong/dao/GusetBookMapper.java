package com.zhong.dao;

import com.zhong.entity.GuestBook;

import java.util.List;

public interface GusetBookMapper {
    public List<GuestBook> selectGusetBookByAdminId();


}
