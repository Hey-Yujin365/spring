<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1 class="fs-3">상품관리 - 상품 목록</h1>
			
			<table class="table">
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="15%">
					<col width="15%">
					<col width="10%">
					<col width="25%">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>상품명</th>
						<th>가격</th>
						<th>재고수량</th>
						<th>상태</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" /></td>
						<td>운동화</td>
						<td>65,000 원</td>
						<td>1,000 개</td>
						<td>판매중</td>
						<td>
							<a href="" class="btn btn-outline-primary btn-sm">입고</a>
							<a href="" class="btn btn-outline-danger btn-sm">판매중지</a>
							<a href="" class="btn btn-outline-success btn-sm">판매재개</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<div class="text-end">
				<a href="create" class="btn btn-primary">신규 상품</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>