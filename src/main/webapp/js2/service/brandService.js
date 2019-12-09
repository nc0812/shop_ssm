// 定义服务层:
app.service("brandService",function($http){

	
	this.findByPage = function(page,rows){
		return $http.get("brandfindByPage?page="+page+"&rows="+rows);
	}
	
	this.save = function(entity){
		return $http.post("brandsave",entity);
	}
	

	
	this.dele = function(ids){
		return $http.get("branddelete?ids="+ids);
	}
	

});