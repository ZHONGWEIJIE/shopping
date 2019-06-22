package com.zhong.service.impl;

import com.zhong.dao.GuestBookMapper;
import com.zhong.entity.GuestBook;
import com.zhong.service.GuestBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("GuestBookService")
public class GuestBookServiceImpl implements GuestBookService {

    @Resource
    GuestBookMapper gusetBookMapper;
    @Override
    public Map<String, Object> selectGuestBookByAdminId(String adminId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (adminId!=null&&!adminId.equals("")) {
            map.put("GuestBookList",gusetBookMapper.selectGuestBookByAdminId(adminId));
        }else{
            map.put("GuestBookList",new ArrayList<GuestBook>());
        }
        return map;

    }

    @Override
    public boolean isAdmin(String userName) {
        int flag = gusetBookMapper.selectRoleByAdminId(userName);
        if(flag == 1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<GuestBook> selectGuestBookByAdminIdAndIsReply(String adminId, int isReply) {


        List<GuestBook> guestBookList= gusetBookMapper.selectGuestBookByAdminIdAndIsReply(adminId,isReply);

        return guestBookList;

    }

    @Override
    public boolean updateReplyById(String id, String replyContent) {
        if(id!=null && !id.equals("")) {
            if(replyContent==null||replyContent.equals("")){
                replyContent="";
            }
            gusetBookMapper.updateReplyById(id, new Date(), replyContent);
            return true;
        }else {
            return false;
        }

    }
}
