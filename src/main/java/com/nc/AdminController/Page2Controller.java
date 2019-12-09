package com.nc.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Page2Controller {
      
	@RequestMapping("/home")
	public String home() {
		return "badmin/home";
	}
	
	//品牌管理
	@RequestMapping("/brand")
	public String brand() {
		return "badmin/brand";
	}
	//分类管理
	@RequestMapping("/item_cat")
	public String item_cat() {
		return "badmin/item_cat";
	}
	//规格管理
	@RequestMapping("/specification")
	public String specification() {
		return "badmin/specification";
	}
	//模板管理
	@RequestMapping("/type_template")
	public String type_template() {
		return "badmin/type_template";
	}
	//商品审核
	@RequestMapping("/goods")
	public String goods() {
		return "badmin/goods";
	}
	
	
	
}
