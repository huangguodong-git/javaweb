<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> 
	/* 页面加载的时候添加一个定时器，0秒之后执行hideURLbar函数。hideURLbar函数将页面滚动至坐标（0,1）
	 因为chrome等浏览器会有滚动缓存功能，比如你在A页面滚动后跳转到B页面，点击返回键回到A页面，会发现滚动条位置仍然保持 */
	addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); 
		}, false); 
		
		function hideURLbar(){ 
			window.scrollTo(0,1); 
		}
		
	window.onload = function(){
		//获取用户选中的物品类型
		var tableStatus = "${tableStatus}";
		var agileinfo_search = document.getElementById("agileinfo_search");
		
		//获取下拉框中所有的option
		var options = agileinfo_search.options;
		
		$.each(options,function(i,item){
			//如果option的value值等于用户选择的tableStatus就被选中
			$(item).attr("selected",item.value == tableStatus);
		})
	}	
	
	function dataChange(obj){
		//获取用户输入的餐桌名
		var tableName = $("#tableName").val();
		//餐桌的使用状态
		var tableStatus = obj.value;
		
		window.location = "${pageContext.request.contextPath}/app/index.do?method=submitTable&tableName="+tableName+"&tableStatus="+tableStatus;
	}
</script>

</head>
<body> 
	<!-- banner -->
	<div class="banner" style="height: 900px;">
		<%@ include file="header.jsp" %>
		<!-- banner-text -->
		<div class="banner-text">	
			<div class="container" style="padding-left: 280px;margin-top: -100px;">
				<div class="agileits_search">
					<form action="${pageContext.request.contextPath}/app/index.do" method="post">
						<input type="hidden"  name="method"  value="submitTable">
						<div id="serchResult" cstyle="margin-top: 20px;">
							<c:if test="${not empty dinnerTables}">
								<c:forEach items="${dinnerTables}" var="dinnerTable" >
									 <a href="${pageContext.request.contextPath}/app/menu.action?id=${dinnerTable.id}" style="color: white;font-size: 20px;"">
									 	${dinnerTable.tableName}
									 </a>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
								</c:forEach>
							</c:if>
							<c:if test="${ empty dinnerTables}">
								当前没有未使用的餐桌
							</c:if>
							 <br><br>
						</div>
						<input name="tableName" id="tableName" type="text" placeholder="餐桌名" >
						<select id="agileinfo_search" name="tableStatus" onchange="dataChange(this)">
							<option value="">全部</option>
							<option value="1">正在使用</option>
							<option value="0">未使用</option>
						</select>
						<input type=submit   value="查看餐桌">
					</form>
				</div> 
			</div>
		</div>
	</div>
	
</body>
</html>