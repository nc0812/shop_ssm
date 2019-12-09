//服务层
app.service('adminService',function($http){
	    	

	//分页 
	this.findByPage=function(page,rows){
		return $http.get('adminfindPage?page='+page+'&rows='+rows);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('adminadd',entity);
	}

	//删除
	this.dele=function(ids){
		return $http.get('admindeleteAll?ids='+ids);
	}
   
	
});
