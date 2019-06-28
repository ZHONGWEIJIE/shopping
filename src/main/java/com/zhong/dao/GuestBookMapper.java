package com.zhong.dao;

import com.zhong.entity.GuestBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface GuestBookMapper {
    public List<GuestBook> selectGuestBookByAdminId(@Param("adminId") String adminId);

    public int selectRoleByAdminId(@Param("id") String userName);

    public List<GuestBook> selectGuestBookByAdminIdAndIsReply
            (@Param("adminId") String adminId ,@Param("isReply")int isReply);

    public void updateReplyById(@Param("id") String id ,@Param("replyTimeDate")Date replyTimeDate,@Param("replyContent")String replyContent );



}
