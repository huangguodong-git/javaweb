<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>订单列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
</head>
<body> 
	<!-- banner -->
	<div class="banner about-w3bnr">
		<%@ include file="header.jsp" %>
	</div>
	<!-- //banner -->    
	<!-- breadcrumb -->  
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="${ctx}/app/index.do"><i class="fa fa-home"></i> 主页</a></li> 
			<li class="active">我的订单</li>
		</ol>
	</div>
	<!-- //breadcrumb -->
	<!-- products -->
	<div class="products">	 
		<div class="container">
			<div class="col-md-12 ">
				<!-- 查询 所有订单遍历  未付款的排在上面     开始-->
				<div class="rsidebar-top col-md-12">
					<!-- 遍历所有的订单 -->
					<c:if test="${not empty orders }">
						<c:forEach items="${orders}" var="order">
							<div class="sidebar-row">
								<h4>
									<span class="col-md-10">
										${order.dinnerTable.tableName}
										订单编号：${order.orderCode}
										下单时间：<fmt:formatDate value="${order.orderDate}"  pattern="yyyy-MM-dd HH:mm:ss"/>
									</span>
									<span class="col-md-2">
										<font color="#0096e6">
											<c:if test="${order.orderStatus ==1 }">
												已付
											</c:if>
											<c:if test="${order.orderStatus ==0 }">
												未付
											</c:if>
											￥<fmt:formatNumber value="${order.totalPrice }" pattern="0.00"></fmt:formatNumber>
										</font>
									</span>
								</h4>
								<ul class="faq">
									<c:forEach items="${order.orderDetails }" var="orderDetail">
										<li>
											<a href="#">
												<span class="col-md-8">${orderDetail.food.foodName }</span>
												<span class="col-md-2">${orderDetail.buyNum}份</span>
												<span class="col-md-2">
													￥<fmt:formatNumber value="${orderDetail.food.price*orderDetail.discount}" pattern="0.00"></fmt:formatNumber>
												</span>
											</a>
										</li>
									</c:forEach>
								</ul>
							<hr>
							</div>
						</c:forEach>
					</c:if>

					<!-- <div class="sidebar-row"><center><font color="red">暂时没有订单！</font></center></div> -->
				</div>	 
				</div>
				<div class="clearfix">&nbsp;</div>
				<!-- 查询 所有订单遍历  未付款的排在上面		结束-->
			</div>
		</div>
</body>
</html>