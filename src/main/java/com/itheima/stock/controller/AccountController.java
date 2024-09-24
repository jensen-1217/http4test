package com.itheima.stock.controller;

import com.itheima.stock.pojo.Account;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by itheima
 * @Date 2021/12/27
 * @Description
 */
@RestController
@RequestMapping("/account")
@SuppressWarnings("all")
public class AccountController {

    /**
     * get请求，接收url地址参数
     * http://localhost:6666/account/getByUserNameAndAddress?userName=zhangsan&address=sh
     * @param userName 用户名
     * @param address 地址
     * @return
     */
    @GetMapping("/getByUserNameAndAddress")
    public Account getById(String userName,String address){
        Account account = Account.builder().id(1).
                userName(userName).
                address(address).build();
        return account;
    }

    /**
     * get请求，接收请求头中数据
     * @param userName 用户名
     * @return http://localhost:6666/account/getHeader
     */
    @GetMapping("/getHeader")
    public String getHeaderData(@RequestHeader("userName") String userName){
        System.out.println(userName);
        return userName;
    }

    /**
     * 添加account form表单提交
     * http://localhost:6666/account/addAccount
     * @param account
     * @return
     */
    @PostMapping("/addAccount")
    public Account addAccount(Account account){
        System.out.println(account);
        return account;
    }

    /**
     * 接口json格式字符串
     * http://localhost:6666/account/updateAccount
     * @param account 更新数据
     * @return
     */
    @PostMapping("/updateAccount")
    public Account updateAccount(@RequestBody Account account){
        System.out.println(account);
        return account;
    }

    /**
     * 响应cookie信息
     * http://localhost:6666/account/getCookie
     * @param response
     * @throws IOException
     */
    @GetMapping("/getCookie")
    public void getCookie(HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("userName", "zhangsan");
        response.addCookie(cookie);
        response.getWriter().write("hello cookie");
    }





}
