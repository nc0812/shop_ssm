<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="css2/style.css">
	<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>

	 <!-- 引入angular的js -->
    <script type="text/javascript" src="plugins/angularjs/angular.min.js"></script>
    <!-- 引入分页相关的JS和CSS -->
    <script type="text/javascript" src="plugins/angularjs/pagination.js"></script>
    <link rel="stylesheet" href="plugins/angularjs/pagination.css">
    
    <script type="text/javascript" src="js2/base_pagination.js"></script>
    <script type="text/javascript" src="js2/controller/baseController.js"></script>
    <script type="text/javascript" src="js2/controller/goodsController.js"></script>
    <script type="text/javascript" src="js2/service/goodsService.js"></script>
    <script type="text/javascript" src="js2/service/itemCatService.js"></script>
</head>

<body class="hold-transition skin-red sidebar-mini" ng-app="pinyougou" ng-controller="goodsController" ng-init="searchEntity={auditStatus:'0'}">
  <!-- .box-body -->
                
                    <div class="box-header with-border">
                        <h3 class="box-title">商品详情</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" ng-click="dele()" class="btn btn-default" title="删除" ><i class="fa fa-trash-o"></i> 删除</button>
                               
                                        <button type="button" class="btn btn-default" title="添加商品" data-toggle="modal" data-target="#editModal" ng-click="entity={}"><i class="fa fa-file-o"></i> 添加商品</button>                          
                                        <button type="button" ng-click="reloadList()" class="btn btn-default" title="刷新" ><i class="fa fa-refresh"></i> 刷新</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    商品名称：<input  ng-model="searchname">
									<button class="btn btn-default" ng-click="search(1,10)">查询</button>                                    
                                </div>
                            </div>
                            <!--工具栏/-->

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              <th class="" style="padding-right:0px">
			                                  <input id="selall" type="checkbox" class="icheckbox_square-blue">
			                              </th> 
										  <th class="sorting_asc">ID</th>
									      <th class="sorting">名称</th>
									      <th class="sorting">标题</th>
									      <th class="sorting">原价格</th>
									      <th class="sorting">折扣价</th>
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <tr ng-repeat="entity in list">
			                              <td><input ng-click="updateSelection($event,entity.id)" type="checkbox"></td>			                              
				                          <td>{{entity.id}}</td>
									      <td>{{entity.name}}</td>
									      <td>{{entity.subTitle}}</td>
									      <td>{{entity.originalPrice}}</td>
									      <td>{{entity.promotePrice}}</td>
									       	                                  
		                                  <td class="text-center">                                          
		                                 	  <button type="button" class="btn bg-olive btn-xs" >详情</button>                  
		                                  </td>
			                          </tr>
			                      </tbody>
			                  </table>
			                  <!--数据列表/-->                        
							  
							 
                        </div>
                        <!-- 数据表格 /-->
                         <!-- 分页 -->
						<tm-pagination conf="paginationConf"></tm-pagination>
                        
                     </div>
                    <!-- /.box-body -->
        
        
        <!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">品牌编辑</h3>
		</div>
		<div class="modal-body">		
			<table class="table table-bordered table-striped"  width="800px">
		      	<tr>
		      		<td>名称</td>
		      		<td><input ng-model="entity.name" class="form-control" placeholder="名称" >  </td>
		      	</tr>		      	
		      	<tr>
		      		<td>标题</td>
		      		<td><input ng-model="entity.subTitle" class="form-control" placeholder="标题">  </td>
		      	</tr>		      	
		      	<tr>
		      		<td>原价格</td>
		      		<td><input ng-model="entity.originalPrice" class="form-control" placeholder="原价格">  </td>
		      	</tr>		      	
		      	<tr>
		      		<td>折价格</td>
		      		<td><input ng-model="entity.promotePrice" class="form-control" placeholder="折价格">  </td>
		      	</tr>		      	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button class="btn btn-success" data-dismiss="modal" aria-hidden="true" ng-click="save()">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>
  
</body>

</html>