<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<style type="text/css">
	ul li{list-style : none; float : left; margin-left : 10px;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
$(function(){
	$("#productModifyBtn").click(function(){
		$("#p_detail").attr({
			"method":"post",
			"action":"/admin/product/updateProduct"
		});	
		$("#p_detail").submit();
	});
	
	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
	$("#productDeleteBtn").click(function(){
		$("#p_detail").attr({
			"method":"get",
			"action":"/admin/product/productDelete"
		});	
		$("#p_detail").submit();
	});
	
});
$(function(){
	var file = "<c:out value='${detail.p_mainphoto}' />";
	if(file != ""){
		$("#fileImage").attr({
			src:"/uploadStorage/product/${detail.p_mainphoto}",
			width:"450px",
			height:"300px"
		});
	}
});

</script>
</head>
<body>
<div>
	<div align="center"><h2>캠핑장 상세 페이지</h2></div>
	<form id="p_detail" name="p_detail" method = "post">
		<input type="hidden" name="p_number" id="p_number" value="${detail.p_number}"/>
		<input type="hidden" name="p_mainphoto" id="p_mainphoto" value="${detail.p_mainphoto}"/>
	</form>
	<div>
		<table align="center" border="1">
			<tr align="center">
				<td width="400px" height="500px" rowspan="2"><img id="fileImage"><br>
				<ul>
					<li>${detail.p_mainphoto}</li>
					<li>${detail.p_photo1}</li>
					<li>${detail.p_photo2}</li>
					<li>${detail.p_photo3}</li>
				</ul></td>
				<td width="600px" height="300px"><h3>${detail.p_name}</h3><br><br><br><br><br>${detail.p_information}<br></td>
			</tr>
			<tr align="center">
				<td><h3>${detail.p_price}원</h3><br><br><br><br>부대시설 및 렌탈 가격 안내<br>...</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<input type="button" value="수정" id="productModifyBtn">
		<input type="button" value="목록" id="productListBtn">
		<input type="button" value="삭제" id="productDeleteBtn">	
	</div>
</div>
</body>
</html>