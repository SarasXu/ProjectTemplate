package com.saras.template;

import com.google.common.collect.Lists;
import com.saras.template.config.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * description:
 * saras_xu@163.com 2017-03-10 15:31 创建
 */
@Controller
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private ConfigProperty configProperty;

    @RequestMapping("hello")
    public String hello(Model model) {
        List<String> list = Lists.newArrayList();
        list.add("hello");
        list.add(configProperty.getName());
        list.add("velocity");
        model.addAttribute("list", list);
        logger.info("hello info：{}", list);
        logger.error("hello error：{}", list);
        return "hello";
    }
}
