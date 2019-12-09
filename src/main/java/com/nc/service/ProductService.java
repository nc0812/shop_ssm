package com.nc.service;
  
import java.util.List;

import com.nc.pojo.Category;
import com.nc.pojo.Product;
import com.nc.util.PageResult;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
 
    void fill(List<Category> cs);
 
    void fill(Category c);
 
    void fillByRow(List<Category> cs);
    void setSaleAndReviewNumber(Product p);
 
    void setSaleAndReviewNumber(List<Product> ps);
    
    List<Product> search(String keyWord);
     
    /**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);
	/**
	 * 商品模糊查询
	 * @param ids
	 */
	public PageResult findPageByName(int pageNum,int pageSize,String name);



}