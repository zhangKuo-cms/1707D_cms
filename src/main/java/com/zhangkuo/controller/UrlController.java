package com.zhangkuo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangkuo.entity.Url;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午3:28:43 

*/
@RequestMapping("url")
@Controller
public class UrlController {
	
	@GetMapping("add")
	public String add(HttpServletRequest request ) {
		request.setAttribute("url",new Url());
		return "url/add";
	}
	
	@PostMapping("add")
	public String add(HttpServletRequest request, 
			@Validated @ModelAttribute("url") Url url,
			BindingResult result) {
		if(result.hasErrors()) {
			return "url/add";
		}
		
		return "url/list";
	}
}
