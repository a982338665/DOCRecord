package org.seckill.web;

import org.seckill.entity.SeckillBean;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * create by lishengbo on 2018-01-02 17:42
 */
@Controller//放入Spring容器
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //列表获取页
        //list.jsp +model=ModelAndView
        List<SeckillBean> seckillList = seckillService.getSeckillList();
        model.addAttribute("list", seckillList);
        return "list";//web-inf/jsp/list.jsp
    }

}
