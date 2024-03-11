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
			<h1>주문 - 3단계 (주문/결제 정보 확인)</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
		
		</div>
		<div class="col-9">
			<h3>주문 상품 정보</h3>
			<table class="table">
				<thead>
					<tr>
						<th>상품이름</th>
						<td>아이폰 15</td>
						<th>상품가격</th>
						<td>1,500,000 원</td>
					</tr>
					<tr>
						<th>구매수량</th>
						<td>2 개</td>
						<th>총 구매가격</th>
						<td>3,000,000 원</td>
					</tr>
				</thead>
			</table>
			
			<h3>결제 정보</h3>
			<table class="table">
				<thead>
					<tr>
						<th>결제구분</th>
						<td>신용카드</td>
						<th>카드번호</th>
						<td>신용카드</td>
					</tr>
					<tr>
						<th>총 결제금액</th>
						<td>3,000,000 원</td>
					</tr>
				</thead>
			</table>
			
		</div>
	</div>
</div>
</body>
</html>