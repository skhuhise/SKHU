<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../res/css/user/login.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="../../res/css/common/login.css?ver=1">
<title>성공회대 학사 시스템</title>
</head>
<body>
	<div class="wrap text-center">
		<div class="outer">
			<div class="inner">
				<div class="centered">
					<form:form class="form-horizontal" action="changepwd" method="post" modelAttribute="student">
					<form:hidden path="id" />
						<div>
							<img src="../../res/image/login_logo.png"
								class="img-responsive center-block" alt="Responsive image" />
						</div>
						<div class="form-group title">패스워드 찾기</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 아이디</label>
							<div class="col-sm-10">
								<form:input path="studentNumber" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 이름</label>
							<div class="col-sm-10">
								<form:input path="name" class="form-control" />
							</div>
						</div>
						<div>
							<button type="submit" class="btn btn-info btn-block">다음</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>