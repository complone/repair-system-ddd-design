package com.lizhi.guide.controller;


import com.lizhi.guide.entity.Document;
import com.lizhi.guide.mapper.DocumentMapper;
import com.lizhi.guide.util.DataTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {



    @RequestMapping("/start")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/timeline")
    public String setTimeLine(){
        return "tab_time_axis";
    }

    @RequestMapping(value = "/descrption",method = RequestMethod.POST)
    public String setProjectDescrption(){
        return "tab_project_descrption";
    }

    @RequestMapping(value = "/projectList")
    public String projectList(){
        return  "page_project_list";
    }

    @RequestMapping(value = "/buildProject")
    public String buildProject(){
        return "page_build_new_project";
    }
    @RequestMapping(value = "/testCodeSearch")
    @ResponseBody
    public String TestCodeSearch(){
        return "This is Tab4";
    }

    @RequestMapping(value = "/current_page")
    public String currentPage(){
        return "current_page";
    }

    @RequestMapping("/current_page/{teamId}")
    public String intoCurrentPage(@PathVariable("teamId")int teamId){
        return "current_page";
    }


    @RequestMapping(value = "/api/current_page/{teamId}",method = RequestMethod.POST)
    @ResponseBody
    public String updateCurrentPage(@PathVariable("teamId")int teamId){

        return String.valueOf(teamId);
    }



}
