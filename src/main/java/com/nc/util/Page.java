package com.nc.util;

public class Page {
	private int start;//开始每页总数
	private int count;//每页显示个数
	private int total;//总个数
	private String param;//参数
	
	private static final int defaultCount = 5;//默认每页显示5条
	
	public Page(){
		count = defaultCount;
	}
	public Page(int start, int count){
		this();
		this.start = start;
		this.count = count;
	}
	//判断是否有前一页
	public boolean isHasPreviouse(){
		if(start==0){
			return false;
		}
		return true;
	}
	//计算最后一页的数值是多少
	public int getLast(){
		int last;
		//假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if(0==total%count){
			last = total - count;
			//假设总数是51，不能够被5整除，那么最后一页的开始就是50
		}
		else{
			last = total - total%count;
		}
		last = last<0?0:last;
		return last;
	}
	//判断是否有后一页
	public boolean isHasNext(){
		if(start==getLast()){
			return false;
		}
		return true;
	}
	//根据每页的显示的数量count以及总共有多少条数据totoal，计算出总共有多少页
	public int getTotalPage(){
		int totalPage;
		//假设总数是50，是能够被5整除的，那么就有10页
		if(0==total%count){
			totalPage = total / count;
			//假设总数是51，不能被5整除，那么就有11页
		}else{
			totalPage = total /count + 1;
		}
		if(0==totalPage){
			totalPage = 1;
		}
		return totalPage;
	}
//get set
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public static int getDefaultcount() {
		return defaultCount;
	}
	@Override
	public String toString() {
		return "Page [start=" + start + ", count=" + count + ", total=" + total + ", param=" + param
				+ ", isHasPreviouse()=" + isHasPreviouse() + ", getLast()=" + getLast() + ", isHasNext()=" + isHasNext()
				+ ", getTotalPage()=" + getTotalPage() + ", getStart()=" + getStart() + ", getCount()=" + getCount()
				+ "]";
	}
	
	
}
