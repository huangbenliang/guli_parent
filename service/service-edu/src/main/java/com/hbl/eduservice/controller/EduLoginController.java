package com.hbl.eduservice.controller;

import com.hbl.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class EduLoginController {

    //login
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }
    
    //info
    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","admin").data("name","黄uu").data("avatar","http://www.weixintouxiang.cn/weixin/20140607090832328.gif");
    }
    
}
