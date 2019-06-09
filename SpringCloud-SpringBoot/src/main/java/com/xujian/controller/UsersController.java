package com.xujian.controller;

import java.util.List;

import com.xujian.pojo.Users;
import com.xujian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users) {
        this.usersService.addUser(users);
        return "ok";
    }

    /**
     * 查询全部用户
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model) {
        List<Users> list = this.usersService.findUserAll();
        model.addAttribute("list", list);
        return "showUsers";
    }

    /**
     * 根据用户id查询用户
     */
    @RequestMapping("/findUserById")
    public String findUserById(Integer id, Model model) {
        Users user = this.usersService.findUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/editUser")
    public String editUser(Users users) {
        this.usersService.updateUser(users);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delUser")
    public String delUser(Integer id) {
        this.usersService.deleteUserById(id);
        return "redirect:/users/findUserAll";
    }

    /**
     *
     * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")这表示当前传递的对象的key为aa。
     * 那么我们在页面中获取该对象的key也需要修改为aa
     * @param users
     * @return
     */
    @RequestMapping("/add")
    public String showPage(@ModelAttribute("aa") Users users){
        return "add";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("aa") @Valid Users users,BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        System.out.println(users);
        return "ok";
    }
}
