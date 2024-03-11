<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>bootstrap</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3"> 
		<div class="col-12">
			<h1>주문 - 1단계(주문 정보 입력)</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
			
		</div>
		<div class="col-9">
			<form method="post" action="step2">
				<input type="hidden" name="productNo" value="120" >
				<div class="form-group mb-3">
					<label class="form-label">상품이름</label>
					<input type="text" class="form-control" name="name" value="아이폰 15" disabled="disabled"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">상품가격</label>
					<input type="text" class="form-control" name="price" value="150,000" disabled="disabled"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">구매수량</label>
					<input type="text" class="form-control" name="amount" value="1"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">총 구매 금액</label>
					<input type="text" class="form-control" name="totalPrice" value="1,500,000" disabled="disabled"/>
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">다음</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>