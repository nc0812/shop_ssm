 //控制层 
app.controller('adminController' ,function($scope,$controller,adminService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		adminService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findByPage=function(page,rows){			
		adminService.findByPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}		
		);
	}
	

	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
//		if($scope.entity.id!=null){//如果有ID
//			serviceObject=goodsService.update( $scope.entity ); //修改  
//		}else{
			serviceObject=adminService.add( $scope.entity  );//增加 
	//	}				
		serviceObject.success(
			function(response){
				if(response.flag){
					//重新查询 
					alert(response.message);
		        	$scope.findByPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		adminService.dele( $scope.selectIds ).success(
			function(response){
				if(response.flag){
					$scope.findByPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//刷新列表
					$scope.selectIds = [];
				}				
			}		
		);				
	}

	
	$scope.reload=function(){
		$scope.findByPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载
	}
	
});	
