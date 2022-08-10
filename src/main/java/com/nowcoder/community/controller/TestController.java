package com.nowcoder.community.controller;

import com.nowcoder.community.service.TestService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by lh on 2022/8/8
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot!";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getDatasources() {
        return testService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("name"));
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("<h1>SpringMVC中response返回数据</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path ="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name = "limit",required = false,defaultValue = "10")  int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path ="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    @RequestMapping(path ="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","张三");
        mv.addObject("age", 30);
        mv.setViewName("/demo/view");
        return mv;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 100);
        return "/demo/view";
    }

    //异步请求,返回json数据
    @RequestMapping(path = "/emp",name = "RequestMethod.Get")
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("age", 18);
        return map;
    }

    @RequestMapping(path = "/emps",name = "RequestMethod.Get")
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("age", 18);
        list.add(map);
        map = new HashMap();
        map.put("name", "李四");
        map.put("age", 28);
        list.add(map);
        map = new HashMap();
        map.put("name", "王五");
        map.put("age", 38);
        list.add(map);
        return list;
    }



}
