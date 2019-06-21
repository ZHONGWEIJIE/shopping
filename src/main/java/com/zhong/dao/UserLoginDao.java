package com.zhong.dao;

import com.zhong.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserLoginDao {
    User queryUserByUserIdAndPassword(@Param("userId") int userId, @Param("userPassword") String password);

}
