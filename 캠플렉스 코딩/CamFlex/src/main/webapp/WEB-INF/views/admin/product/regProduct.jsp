<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
$(function(){
	$("#regProductBtn").click(function(){
		if(!chkSubmit($('#p_type'), "상품 구분을")) return;
		else if(!chkSubmit($('#p_name'), "상품명을")) return;
		else if(!chkSubmit($('#p_price'), "상품 금액을"))return;
		else if(!chkSubmit($('#p_information'), "상품 안내를"))return;
		else if(!chkSubmit($('#file'), "이미지를")) return;
		else if(!chkSubmit($('#file1'), "이미지를")) return;
		else if(!chkSubmit($('#file2'), "이미지를")) return;
		else if(!chkSubmit($('#file3'), "이미지를")) return;
		else{
		if($('#file').val() != ""){
			if(!chkFile($('#file')))return;
		}
		if(confirm('등록을 진핼할까요?')){	
		$("#regProductForm").attr({
			"method":"post",
			"action":"/admin/product/reg"
		});	
		$("#regProductForm").submit();
		
		}
		}
	});
	
	$("#productListBtn").click(function(){
		location.href="/admin/product/productList";
	});
});
function chkFile(item){
	var ext = item.val().split('.').pop().toLowerCase();
	if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		alert('gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.');
		return false;
	}else{
		return true;	
	}
}
function chkSubmit(item, msg){
	if(item.val().replace(/\s/g,"") == ""){
		alert(msg + "입력해 주세요.");
		item.val("");
		item.focus();
		return false();
	}else{
		return true;
	}
}
</script>
</head>
<body>
<div>
	<div align="center"><h3>상품 등록</h3></div>
	<div align="center">
		<form id="regProductForm" name="regProductForm" enctype="multipart/form-data">
			<table border="1">
				<colgroup>
					<col width="17%" />
					<col width="83%" />
				</colgroup>
				<tr>
					<td>구분</td>
					<td><select id="p_type" name="p_type" >
							<option value="오토">오토</option>
							<option value="글램핑">글램핑</option>
							<option value="차박">차박</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="p_name" id="p_name" required="required" placeholder="상품명"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="p_price" id="p_price" required="required" placeholder="가격"/></td>
				</tr>
				<tr>
					<td>상품 안내</td>
					<td><textarea id="p_information" name="p_information" maxlength="2000" rows="8" cols="50" placeholder="상품 안내"></textarea></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file" id="file" value="p_mainphoto"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file1" id="file1" value="p_photo1"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file2" id="file2" value="p_photo2"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="file3" id="file3" value="p_photo3"></td>
				</tr>
				
			</table>
		</form>
	</div>
	<div align="center">
		<input type="button" value="등록" id="regProductBtn">
		<input type="button" value="목록" id="productListBtn">
	</div>
</div>
</body>
</html>