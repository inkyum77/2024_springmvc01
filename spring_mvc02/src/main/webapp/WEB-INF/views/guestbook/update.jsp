<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>

<style type="text/css">
/*summernote toolbar 수정*/

.note-btn-group{width: auto}
.note-toolbar{width: auto}
a {
	text-decoration: none;
}

table {
	width: 800px;
	border-collapse: collapse;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	padding: 3px
}

div {
	width: 800px;
	margin: auto;
	text-align: center;
}
</style>

</head>
<body>
	<div>
		<h2>수정</h2>
		<hr>
		<p><a href="/gb_list">[목록으로 이동]</a></p>
		<form action="${pageContext.request.contextPath}/GBController" method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td><input type="text" name="gb_writer" size="20" value="${gbvo.gb_writer}"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제 목</td>
					<td><input type="text" name="gb_subject" size="20" value="${gbvo.gb_subject}"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td><input type="text" name="gb_email" size="20" value="${gbvo.gb_email}"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<td><input type="file" name="parameter_file" size="20" value="${gbvo.parameter_file}"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="password" name="gb_pwd" size="20"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<textarea rows="10" cols="60" name="gb_content" id="summernote" value="${gbvo.gb_content}"></textarea>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="submit" value="저장"> 
							<input type="button" onclick="cancel_go(this.form)" value="취소">
							<input type="hidden" name="cmd" value="update">
							<input type="hidden" name="p_idx"  value="${gvo.p_idx}">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function update_go(f) {
			f.action="${pageContext.request.contextPath}/GBController?cmd=update";
			f.submit()="";
		}
		function cancel_go(f) {
			f.action="${pageContext.request.contextPath}/GBController?cmd=onlist&p_idx=${gvo.p_idx}";
			f.submit()="";
		}
	</script>
	<script type="text/javascript">
		$(function() {
			$("#summernote").summernote({
				lang : 'ko-KR',
				height : 300,
				focus : true,
				placeholder : "최대 3000자까지 쓸 수 있습니다.",
				callback : {
					onImageUpload : function(files, editor){
						for (let i = 0; i < files.length; i++) {
							sendImage(files[i], editor);
						}
					}
				}
			});
		});
		
		function sendImage(file, editor) {
			//formData "객체를 전송할 때", jQuery가 실행
			let frm = new FormData();
			frm.append("s_file", file);
			$.ajax({
				url : "/saveImg",
				data : frm,
				type : "post",
				cache : false,
				dataType : "json",
				success : function(data) {
					const path = data.path;
					const fname = data.fname;
					$('#summernote').summernote("editor.insertImage", path+"/"+fname);
				}
			});
		}
	</script>
</body>
</html>