//服务层
app.service('goodsService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../goods/findAll.do');		
	}
	//分页 
	this.findByPage=function(page,rows){
		return $http.get('goodfindPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../goods/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('goodadd',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../goods/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('gooddeleteAll?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchname){
		return $http.post('goodsearch?page='+page+"&rows="+rows+"&searchname="+searchname);
	}    
	
	this.updateStatus = function(ids,status){
		return $http.get('../goods/updateStatus.do?ids='+ids+"&status="+status);
	}
});
