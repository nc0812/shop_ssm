//服务层
app.service('contentCategoryService',function($http){
	    	
	//分页 
	this.findPage=function(page,rows){
		return $http.get('categoryfindPage?page='+page+'&rows='+rows);
	}

	//增加 
	this.add=function(entity){
		return  $http.post('categoryaddd',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../contentCategory/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('categorydeleteAll?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../contentCategory/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
