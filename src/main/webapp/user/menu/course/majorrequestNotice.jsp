<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="../../../res/css/user/main.css?ver=1">
<title>SKHU 졸업관리</title>
</head>

<body>
	<jsp:include page="../header.jsp" flush="true"></jsp:include>
	<main>
	<div class="container">
		<div id="header" class="panel panel-default">
			<div class="panel-body">
				<table>
					<h4 class="title text-center">전공인정신청 방법</h4>
					<hr />
					<tr>
						<td class="col-md-5 text-center">공학계 타학과 개설 과목 이수</br> ↓</br> 전공​인정신청서와
							이수구분변경신청서를 제출</br> ↓</br> 승인된 경우, 전공 선택으로 인정
						</td>
					</tr>
					<tr>
						<td class="col-md-5 text-center">
							<hr /> ***</br> 단, 전공필수 과목은 반드시 소프트웨어공학과에서 이수하여야함</br> 같은 과목을 소프트웨어공학과와
							타과에서 이중 이수한 경우 타과 이수 과목은 전공으로 인정하지 않음
							<p />
						</td>
					</tr>
					<tr>
						<td class="col-md-5 text-center">
							<hr /> 1. 고학년들이 1, 2학년 과목을 재수강 또는 초수강 하려고 할 때, 전탐 과목을 대체 과목으로
							지정할 수 있습니다. 졸업 사정시에 전공으로 인정하여 사정합니다. 학과에서 대체 과목 목록이 필요하면 작성합니다.</br>
							2. 전탐 과목을 대체 과목으로 지정할 수 없고 이제는 개설되지 않는 1, 2학년 과목(예: 과정지도 1, 2 ,
							3등)은 개설된 다른 전공 과목을 수강(몇 학점이든 상관 없음)하면 인정합니다. 단, 재수강인 경우에는 대체과목으로
							처리되어 B+이하의 성적만 받을 수 있습니다. 초수강인 경우에는 성적 부여에 제한이 없습니다
							<p />
						</td>
					</tr>
				</table>

				<table>
					<hr />
					<h4 class="title text-center">양식 다운로드</h4>
					<hr />
					<tr>
						<td class="col-md-5 col-md-offset-5 text-center">1. <a
							href="/" download="전공인정신청서">전공인정신청서</a></td>
						<td class="col-md-5 col-md-offset-5 text-center">2. <a
							href="/" download="이수구분변경신청서">이수구분변경신청서</a></td>
					</tr>
				</table>

				<hr />

				<h3 class="text-center mb-25">전공 인정 신청</h3>
				<form>
					<div class="form-group col-md-4 col-md-offset-4">
						과목 코드: <input type="text" name="subjectCode" class="form-control"
							placeholder="과목 코드"></br> 과목명: <input type="text"
							name="subjectName" class="form-control" placeholder="과목명"></br>
						개설 학과: <select name="department" class="form-control">
							<option value="1">소프트웨어공학과</option>
							<option value="2">컴퓨터공학과</option>
							<option value="3">글로컬IT학과</option>
							<option value="4">정보통신공학과</option>
						</select>
					</div>
					<div class="form-group col-md-6 col-md-offset-3 mt-25 mb-25">
						<textarea name="reportContent" class="form-control"
							maxlength="1024" style="height: 100px" placeholder="기타사항"></textarea>
					</div>
					<div>
						<input type="file"
							class="form-group col-md-5 col-md-offset-5 mb-25" name="file" />
					</div>
					<div>
						<button type="submit"
							class="btn btn-info col-md-2 col-md-offset-5 mb-25">신청</button>
					</div>
				</form>

			</div>
		</div>
	</div>
	</main>
	<footer> </footer>
</body>
</html>

