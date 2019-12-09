<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品分类管理</title>
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
    <script type="text/javascript" src="js2/base.js"></script>
    <script type="text/javascript" src="js2/controller/baseController.js"></script>
    <script type="text/javascript" src="js2/controller/itemCatController.js"></script>
    <script type="text/javascript" src="js2/service/itemCatService.js"></script>
    
</head>

<body class="hold-transition skin-red sidebar-mini" ng-app="pinyougou" ng-controller="itemCatController" ng-init="findByPage(1,10)">
  <!-- .box-body -->
                
                    <div class="box-header with-border">
                        <h3 class="box-title">商品分类管理     
                       	</h3>
                    </div>

                    <div class="box-body">
                  			 <ol class="breadcrumb">	                        	
                        		<li>
		                        	<a href="#" ng-click="grade=1;selectList({id:0})">顶级分类列表</a> 
		                        </li>
		                        <li>
		                       		<a href="#" ng-click="grade=2;selectList(entity_1)">{{entity_1.name}}</a>
		                        </li>
		                        <li>
		                        	<a href="#" ng-click="grade=3;selectList(entity_2)">{{entity_2.name}}</a>
		                        </li>
	                        </ol>

                        <!-- 数据表格 -->
                        <div class="table-box">
							
                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" ><i class="fa fa-file-o"></i> 新建</button>
                                        <button type="button" class="btn btn-default" title="删除" ><i class="fa fa-trash-o"></i> 删除</button>
                                        <button type="button" class="btn btn-default" title="刷新" ><i class="fa fa-check"></i> 刷新</button>
                                       
                                    </div>
                                </div>
                            </div>                          
                       		
                        
			                <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              <th class="" style="padding-right:0px">
			                                  <input type="checkbox" class="icheckbox_square-blue">
			                              </th> 
										  <th class="sorting_asc">分类ID</th>
									      <th class="sorting">分类名称</th>									   
									   <!--    <th class="sorting">类型模板ID</th> -->
									     						
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <tr ng-repeat="entity in list">
			                              <td><input  type="checkbox" ></td>			                              
				                          <td>{{entity.id}}</td>
									      <td>{{entity.name}}</td>									    
									 								      
		                                  <td class="text-center">		      
			                                   
		                                 	  <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal" >修改</button>                                           
		                                  </td>
			                          </tr>
			                      </tbody>
			                  </table>
			                  <!--数据列表/-->                      
						 <!-- 分页 -->
						<tm-pagination conf="paginationConf"></tm-pagination>
                        
                        </div>
                        <!-- 数据表格 /-->
                        
                        
                        
                        
                     </div>
                    <!-- /.box-body -->
              
                                
<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">商品分类编辑</h3>
		</div>
		<div class="modal-body">							
			
			<table class="table table-bordered table-striped"  width="800px">
				<tr>
		      		<td>上级商品分类</td>
		      		<td>
		      		   珠宝 >>  银饰
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>商品分类名称</td>
		      		<td><input  class="form-control" placeholder="商品分类名称">  </td>
		      	</tr>			  
		      	<tr>
		      		<td>类型模板</td>
		      		<td>	      		
		      			<input select2 config="options['type_template']" placeholder="商品类型模板" class="form-control" type="text"/>
		      		</td>		      		      		
		      	</tr>		      	
			 </table>				
			
		</div>
		<div class="modal-footer">						
			<button class="btn btn-success" data-dismiss="modal" aria-hidden="true">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>
</body>
</html>