//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('propertyfindPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('propertyaddd',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('propertydeleteAll?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('search?page='+page+"&rows="+rows, searchEntity);
	}  
	
	
});
