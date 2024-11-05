<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<link rel="stylesheet" href="resources/css/summernote-lite.css">
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	}
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>

</head>
<body>
	<div id="bbs">
	<form action="/bbs_write_ok" method="post" encType="multipart/form-data">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45"></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12"></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea id="content" name="content" cols="50" rows="8"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td><input type="file" name="file_name"></td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="보내기" onclick="bbs_write_ok(this.form)">
						<input type="reset" value="다시">
						<input type="button" value="목록" onclick="bbs_list()">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#content").summernote({
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
				contentType : false,
				processData : false,
				dataType : "json",
				success : function(data) {
					const path = data.path;
					const fname = data.fname;
					$('#summernote').summernote("editor.insertImage", path+"/"+fname);
				}
			});
		}
	</script>
	<script type="text/javascript">
		function bbs_write_ok(f){
			f_action = "/bbs_write_ok";
			f.submit();
		}
		function bbs_list(){
			location.href = "/bbs";
		}
	</script>
</body>
</html>

