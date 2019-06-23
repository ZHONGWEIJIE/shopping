package com.zhong.service;

import com.zhong.entity.GuestBook;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GuestBookService {
    public Map<String, Object> selectGuestBookByAdminId(String adminId);

    public boolean isAdmin(String userName);

    public List<GuestBook> selectGuestBookByAdminIdAndIsReply(String adminId, int isReply);

    public boolean updateReplyById
            (@Param("id") String id , @Param("replyContent")String replyContent );

}
