package com.denghb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppd on 2017/7/31.
 */
@Controller
public class IndexController {
    // TODO 内置接口
    static List<String> urls = new ArrayList<String>();

    static {
        urls.add("/v2/api-docs");
        urls.add("/swagger-resources/configuration/security");
        urls.add("/swagger-resources/configuration/ui");
        urls.add("/swagger-resources");
    }


    @RequestMapping(value = "/", produces = "text/html")
    @ResponseBody
    public String index() {


        String html = "";
        for (String url : urls) {
            html += "<a href='" + url + "'>" + url + "</a><br/>";
        }

        return html;
    }
}
