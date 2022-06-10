package king.drug.controller;

import king.drug.api.UserApi;
import king.drug.api.dtoreq.BuyerReqDTO;
import king.drug.api.dtoreq.UserReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:56
 */
@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController implements UserApi {
    @Autowired
    private UserService userService;

    @Override
    @RequestMapping("/login")
    public AjaxInfoResDTO login(@RequestBody UserReqDTO user, HttpSession session) {
        log.info("调用了登录接口");
        return userService.login(user, session);
    }

    @Override
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        return userService.logout(session);
    }

    @Override
    @RequestMapping("/registUser")
    public AjaxInfoResDTO regist(@RequestBody UserReqDTO user, HttpSession session) {
        return userService.regist(user, session);
    }

    @Override
    @RequestMapping("/queryUser")
    public AjaxInfoResDTO queryUser(@RequestBody UserReqDTO user, HttpSession session) {
        return userService.queryUser(user, session);
    }

    @Override
    @RequestMapping("/deleteUser")
    public AjaxInfoResDTO deleteUser(@RequestBody UserReqDTO user, HttpSession session) {
        return userService.deleteUser(user, session);
    }

    @Override
    @RequestMapping("/registBuyer")
    public AjaxInfoResDTO registBuyer(@RequestBody BuyerReqDTO buyer, HttpSession session) {
        return userService.registBuyer(buyer, session);
    }

    @Override
    @RequestMapping("/queryBuyer")
    public AjaxInfoResDTO queryBuyer(@RequestBody BuyerReqDTO buyer, HttpSession session) {
        return userService.queryBuyer(buyer, session);
    }

    @Override
    @RequestMapping("/deleteBuyer")
    public AjaxInfoResDTO deleteBuyer(@RequestBody BuyerReqDTO buyer, HttpSession session) {
        return userService.deleteBuyer(buyer, session);
    }

    @Override
    @RequestMapping("/updateBuyer")
    public AjaxInfoResDTO updateBuyer(@RequestBody BuyerReqDTO buyer, HttpSession session) {
        return userService.updateBuyer(buyer, session);
    }
}
