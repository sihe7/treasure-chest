package king.drug.service.impl;

import king.drug.api.dtoreq.BuyerReqDTO;
import king.drug.api.dtoreq.UserReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.dal.mapper.UserMapper;
import king.drug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 14:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxInfoResDTO login(UserReqDTO user, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(session.getId());
        UserReqDTO user1 = userMapper.findUser(user);
        if (user1 != null) {
            ajaxInfo.setCode(user1.getUserRight());
            ajaxInfo.setMsg("登陆成功！");
            ajaxInfo.setData(user1.getUserName());
            session.setAttribute("userName", user1.getUserName());
            System.out.println(session.getAttribute("userName"));
        } else {
            ajaxInfo.setCode(-1);
            ajaxInfo.setMsg("账号或密码错误！");
        }
        return ajaxInfo;
    }

    @Override
    public String logout(HttpSession session) {
        System.out.println(session.getId());
        System.out.println(session.getAttribute("userName"));
        session.removeAttribute("userName");
        return "success";
    }

    @Override
    public AjaxInfoResDTO regist(UserReqDTO user, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();

        UserReqDTO userByAcc = userMapper.getUserByAcc(user.getUserAcc());
        if (session.getAttribute("userName") != null) {
            if (userByAcc == null) {
                userMapper.registUser(user);
                ajaxInfo.setMsg("注册成功！");
            } else {
                ajaxInfo.setMsg("账号已存在！请重新输入~");
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryUser(UserReqDTO user, HttpSession session) {
        System.out.println(user);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();

        if (session.getAttribute("userName") != null) {
            UserReqDTO userByAcc = userMapper.getUserByAcc(user.getUserAcc());
            if (userByAcc == null || userByAcc.getUserRight() != 2) {
                ajaxInfo.setMsg("该取药员不存在，请重新输入！");
                ajaxInfo.setCode(-1);
            } else {
                ajaxInfo.setMsg("查询成功！");
                ajaxInfo.setCode(0);
                ajaxInfo.setData(userByAcc);
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO deleteUser(UserReqDTO user, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();

        if (session.getAttribute("userName") != null) {
            userMapper.deleteUser(user.getUserAcc());
            ajaxInfo.setMsg("删除成功！");
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO registBuyer(BuyerReqDTO buyer, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println("======" + buyer);
        BuyerReqDTO buyerByUserId = userMapper.getBuyerById(buyer.getBuyerId());
        if (session.getAttribute("userName") != null) {
            if (buyerByUserId == null) {
                userMapper.registBuyer(buyer);
                ajaxInfo.setMsg("注册成功！");
            } else {
                ajaxInfo.setMsg("ID已存在！");
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryBuyer(BuyerReqDTO buyer, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(buyer);

        if (session.getAttribute("userName") != null) {
            BuyerReqDTO buyer1 = userMapper.getBuyerById(buyer.getBuyerId());
            if (buyer1 == null) {
                ajaxInfo.setMsg("该采购员不存在，请重新输入！");
                ajaxInfo.setCode(-1);
            } else {
                ajaxInfo.setMsg("查询成功！");
                ajaxInfo.setData(buyer1);
                ajaxInfo.setCode(0);
            }

        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        System.out.println("=================" + ajaxInfo.getCode());
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO deleteBuyer(BuyerReqDTO buyer, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            userMapper.deleteBuyer(buyer.getBuyerId());
            ajaxInfo.setMsg("删除成功！");
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO updateBuyer(BuyerReqDTO buyer, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            userMapper.updateBuyer(buyer);
            ajaxInfo.setMsg("更新成功！");
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }
}
