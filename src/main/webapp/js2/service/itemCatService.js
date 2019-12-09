//服务层
app.service('itemCatService',function($http){
	    	
	//分页 
	this.findPage=function(page,rows){
		return $http.get('itemcatfindPage?page='+page+'&rows='+rows);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('itemcataddd',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../itemCat/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('itemcatdeleteAll?ids='+ids);
	}
	
	
});
