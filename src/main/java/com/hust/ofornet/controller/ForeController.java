package com.hust.ofornet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.util.Page;

@Controller
@RequestMapping("")
public class ForeController {
	
	@Autowired
	JobService jobService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        jobService.fill(cs);
        jobService.fillByRow(cs);
        System.out.println(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
	
	@RequestMapping("foresearch")
    public String search( String keyword,Model model,Page page){
        /*PageHelper.offsetPage(0,20);*/
		page.setCount(8);
		PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Job> job= jobService.search(keyword);
        int total = (int) new PageInfo<>(job).getTotal();//通过PageInfo获取总数
		page.setTotal(total);
        //jobService.setSaleAndReviewNumber(ps);
        System.out.println(job);
        model.addAttribute("page",page);
        model.addAttribute("ps",job);
        model.addAttribute("keywords", keyword);
        //return "fore/searchResult";
        return "fore/searchResult";
    }
}
