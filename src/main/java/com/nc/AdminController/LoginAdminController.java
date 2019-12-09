package com.nc.AdminController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.nc.pojo.Admin;
import com.nc.pojo.Product;
import com.nc.service.impl.AdminServiceImpl;
import com.nc.util.PageResult;
import com.nc.util.Result;

@Controller
public class LoginAdminController {
    
	@Autowired
	 private AdminServiceImpl adminServiceImpl;
	
	  @RequestMapping("/adminlogin")
	  public String login() {
		    
		  return "login";
	  }
	  
	  @RequestMapping(value="/adminselect")
	  public String selectName(String name,String password,HttpServletRequest req,HttpServletResponse resp) {
		  System.out.print(name+" "+password);
		  String adminname=(String) req.getSession().getAttribute("adminname");
		  if(adminname!=null) {
			  return "badmin/index";
		  }
		  
		  List<Admin> selectName = adminServiceImpl.selectName(name, password);
		   
		  if(selectName.size()>0) {
			  Admin admin = selectName.get(0);
			  req.getSession().setAttribute("adminname", admin.getName());
			  return "badmin/index";
		  }else {
			  return "login";
		  }		  
	  }
	  
	  @RequestMapping("/adminlogout")
	  public String adminlogout(HttpServletRequest req) {
		  req.getSession().removeAttribute("adminname");
		  return "login";
	  }
	  
	  @RequestMapping("/adminshowName")
	  @ResponseBody
	  public Map<String,String> adminshowName(HttpServletRequest req) {
		  String adminname = (String) req.getSession().getAttribute("adminname");
		  Map map=new HashMap<String, String>();
		  map.put("adminname", adminname);
		  return map;
	  }
	  
		@RequestMapping("/adminfindPage")
		@ResponseBody
		public PageResult  findPage(int page,int rows){			
			return adminServiceImpl.findPage(page,rows);
		}
	 
		
		
		@RequestMapping("/adminadd")
		@ResponseBody
		public Result add(@RequestBody Admin admin){
			try {
				adminServiceImpl.add(admin);
				return new Result(true, "增加成功");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}
		
		
		/**
		 * 批量删除
		 * @param ids
		 * @return
		 */
		@RequestMapping("/admindeleteAll")
		@ResponseBody
		public Result deleteAll(Long [] ids){
		    try {
		    	adminServiceImpl.delete(ids);
		     return new Result(true,"删除成功");
		    }catch (Exception e) {
				// TODO: handle exception
		    	e.printStackTrace();
		    	return new Result(false,"删除失败");
			}
		}
	  
	  
	  
}
