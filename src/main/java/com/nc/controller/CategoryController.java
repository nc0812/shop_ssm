package com.nc.controller;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nc.pojo.Category;
import com.nc.service.CategoryService;
import com.nc.util.ImageUtil;
import com.nc.util.Page;
import com.nc.util.PageResult;
import com.nc.util.Result;
import com.nc.util.UploadedImageFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
 
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
  
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
    //为方法list增加参数Page用于获取浏览器传递过来的分页信息
    	PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Category> cs= categoryService.list();//获取当前页的分类集合
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);//为分页对象设置�?�数
        model.addAttribute("cs", cs);//把分类集合放在cs�?
        model.addAttribute("page", page);//把分页对象放在page�?
        return "admin/listCategory"; //跳转到listCategory.jsp页面
    }
    
    //add方法映射路径admin_category_add的访�?
    @RequestMapping("admin_category_add")
    public String add(Category c,HttpSession session ,UploadedImageFile uploadedImageFile) throws IllegalStateException, IOException{
    /* 参数Category c接受页面提交的分类名�?
     * 参数session用于在后续获取当前应用的路径		
     * UploadedImageFile用于接受上传的图�?
     * */
    	categoryService.add(c);//通过categoryService保存c对象
    	File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
    	//通过session获取ControllerContext，再通过getRealPath定位存放分类图片的路径�??
    	File file = new File(imageFolder, c.getId()+".jpg");//根据分类id创建文件�?
    	if(!file.getParentFile().exists()){
    		file.getParentFile().mkdirs();
    	}//如果/img/category目录不存在，则创建该目录，否则后续保存浏览器传过来图片，会提示无法保�?
    	uploadedImageFile.getImage().transferTo(file);//通过UploadedImageFile把浏览器传�?�过来的图片保存在上述指定的位置
    	BufferedImage img = ImageUtil.change2jpg(file);//通过ImageUtil。change2jpg(file);确保图片格式�?定是jpg，�?�不仅仅是后�?名为jpg
    	ImageIO.write(img, "jpg", file);
    	return "redirect:/admin_category_list";//客户端跳转到admin_category_list
    }
    //delete方法映射admin_category_delete
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session){
    /* 提供参数接受id注入
     * 提供session参数，用于后续定位文件位�?	*/
    	categoryService.delete(id);//通过categoryService删除数据
    	File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
    	File file = new File(imageFolder, id+".jpg");
    	file.delete();//通过session获取ControllerContext然后获取分类图片位置，接�?删除分类图片
    	return "redirect:/admin_category_list";//客户端跳转到admin_category_list
    }
    //edit方法映射admin_category_edit路径的访�?
    @RequestMapping("admin_category_edit")
    public String edit(int id, Model model){
    	//参数id用来接收注入
    	Category c = categoryService.get(id);//通过categoryService.get获取Category对象
    	model.addAttribute("c", c);//把对象放�?"c"�?
    	return "admin/editCategory";//返回editCategory.jsp
    }
    //update方法映射路径admin_category_update的访�?
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IllegalStateException, IOException{
    /* 参数Category c接受页面提交的分类名�?
     * 参数session用于在后续获取当前应用的路径
     UploadedImageFile用于接受上传的图�?	*/
    	categoryService.update(c);//通过categoryService更新c对象
    	MultipartFile image = uploadedImageFile.getImage();
    	if(null!=image && !image.isEmpty()){	
    	//首先判断是否有上传图片，如果有上传，那么通过session获取ControllerContext，再通过getRealPath定位存放分类图片的路�?
    		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
    		File file = new File(imageFolder,c.getId()+".jpg");//根据分类id创建文件�?
    		image.transferTo(file); //通过UploadedImageFile把浏览器传�?�过来的图片保存在上述指定的位置
    		BufferedImage img = ImageUtil.change2jpg(file);//通过ImageUtil.change2jpg(file);确保图片格式�?定是jpg，�?�不仅仅是后�?名是jpg
    		ImageIO.write(img, "jpg", file);
    	}
    	return "redirect:/admin_category_list";//客户端跳转到admin_category_list
    }
    
	
}