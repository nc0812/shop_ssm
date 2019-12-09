<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="css2/style.css">
	<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="plugins/angularjs/angular.min.js">  </script>
    <!-- 分页组件开始 -->
	<script src="plugins/angularjs/pagination.js"></script>
	<link rel="stylesheet" href="plugins/angularjs/pagination.css">
	<!-- 分页组件结束 -->
    
    
    <script type="text/javascript" src="js2/base_pagination.js">  </script>
    <script type="text/javascript" src="js2/service/contentService.js">  </script>
    <script type="text/javascript" src="js2/service/contentCategoryService.js">  </script>
    <script type="text/javascript" src="js2/service/uploadService.js">  </script>
    <script type="text/javascript" src="js2/controller/baseController.js">  </script>
    <script type="text/javascript" src="js2/controller/contentController.js">  </script>
    
</head>
<body class="hold-transition skin-red sidebar-mini" ng-app="pinyougou" ng-controller="contentController" ng-init="findContentCategoryList()" >
  <!-- .box-body -->
                    <div class="box-header with-border">
                        <h3 class="box-title">管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" ng-click="entity={}"><i class="fa fa-file-o"></i> 新建</button>
                                        <button type="button" class="btn btn-default" title="删除" ng-click="dele()"><i class="fa fa-trash-o"></i> 删除</button>           
                                        <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">							       
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
										                               <th class="sorting"></th>			
                             <th class="sorting">内容类目ID</th>			
                             <th class="sorting">内容标题</th>			
                             <th class="sorting">链接</th>			
                             <th class="sorting">图片绝对路径</th>			
                             <th class="sorting">状态</th>			
                             <th class="sorting">排序</th>			
								     				
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <tr ng-repeat="entity in list">
			                              <td><input  type="checkbox" ng-click="updateSelection($event,entity.id)"></td>			                              
				                                                       <td>{{entity.id}}</td>			
                             <td>{{entity.categoryId}}</td>			
                             <td>{{entity.title}}</td>			
                             <td>{{entity.url}}</td>			
                             <td><img src="{{entity.pic}}" width="100" height="50"></td>			
                             <td>{{status[entity.status]}}</td>			
                             <td>{{entity.sortOrder}}</td>			
		                                 
		                                  <td class="text-center">                                           
		                                 	  <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal" ng-click="findOne(entity.id)" >修改</button>                                           
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
			<h3 id="myModalLabel">编辑</h3>
		</div>
		<div class="modal-body">	
			 <table class="table table-bordered table-striped"  width="800px">			
		      	  		      	<tr>
                             
<td>内容类目ID</td>

                             <td>
                             <select class="form-control" ng-model="entity.categoryId" ng-options="item.id as item.name for item in contentCategoryList"></select>
                             </td>

                        </tr>		
		      	<tr>
                             
<td>内容标题</td>

                             <td><input  class="form-control" ng-model="entity.title" placeholder="内容标题" ></td>

                        </tr>		
		      	<tr>
                             
<td>链接</td>

                             <td><input  class="form-control" ng-model="entity.url" placeholder="链接" ></td>

                        </tr>		
		      	<tr>
                             
<td>图片绝对路径</td>

                             <td>
                             	<input type="file" id="file"/>
                             	<input type="button" value="上传" ng-click="uploadFile()"/>
                             	<img src="{{entity.pic}}" width="200" height="100">
                             </td>

                        </tr>		
		      	<tr>
                             
<td>状态</td>

                             <td>
                             <input type="checkbox" ng-model="entity.status" ng-true-value="1" ng-false-value="0"/>
                             </td>

                        </tr>		
		      	<tr>
                             
<td>排序</td>

                             <td><input  class="form-control" ng-model="entity.sortOrder" placeholder="排序" ></td>

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
