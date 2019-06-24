package com.zhong.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhong.entity.GuestBook;
import com.zhong.service.GuestBookService;
import com.zhong.utils.EmailUtils;
import com.zhong.utils.Result;
import com.zhong.utils.StatysInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/GuestBook")
public class GuestBookController {

    @Resource
    GuestBookService guestBookService;


    @GetMapping({"/getAll" })
    public Map<String,Object> test( ){
        Map<String,Object> map = new HashMap<>();
        map.put("guestBookLisr",guestBookService.selectGuestBookByAdminId("2"));
        return map;
}

    @GetMapping({"/getAll/{adminId}" })
    public Result selectGuestBook(@PathVariable String adminId){
        if (guestBookService.isAdmin(adminId)) {
            Map<String, Object> map = guestBookService.selectGuestBookByAdminId(adminId);
            return Result.makeSuccessResult(map);
        }
        else {
            return Result.makeResult("400",new StatysInfo("没有权限","对不起，您没有权限"));
        }
    }

    @GetMapping({"/reply/{determine}" })
    public Result selectGuestBookByAdminIdAndIsReply(@PathVariable String determine,String adminId){
        Map<String, Object> map = new HashMap<>();
        if (determine.equals("true")||determine=="true"){
            map.put("guestBookList",guestBookService.selectGuestBookByAdminIdAndIsReply(adminId,1));
            return Result.makeSuccessResult(map);
        }else if (determine.equals("false")||determine == "false"){
            map.put("guestBookList",guestBookService.selectGuestBookByAdminIdAndIsReply(adminId,0));
            return Result.makeSuccessResult(map);
        }else {
            map.put("guestBookList",new ArrayList<GuestBook>());
            return Result.makeResult("404",new StatysInfo("404 Not Found"),map);
        }
    }

    @PostMapping({"/reply/content" })
    public Result updateReplyById(String id,String content){
        Map<String, Object> map = new HashMap<>();
        if (guestBookService.updateReplyById(id,content)){
            return Result.makeSuccessResult(new StatysInfo("Success","回复成功"));
        }else {
            return  Result.makeResult("10002",new StatysInfo("Fail","回复失败"));
        }

    }
}
