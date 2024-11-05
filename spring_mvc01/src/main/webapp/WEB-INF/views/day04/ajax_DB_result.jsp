<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span{ width: 150px; color: red;}
	input{border: 1px solid red;}
	table{width: 80%; margin: 0; border-collapse: collapse;}
	table, th, td { border: 1px solid lightgray; text-align: center;}
	h2{text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h2>Ajax를 활용한 DB처리</h2>

	
	
	<hr>
	<div id="result"></div>
	
	<script type="text/javascript">
		//ajax 를 이용해서 db정보 가져오기(첫 접속, 삭제, 삽입)
		function getList(){
			$.ajax({
				url : "/ajax_db_list",
				method : "post",
				dataType : "xml",
				success : function(data){
					let tbody = "";
					$(data).find("member").each(function(){
						tbody += "<tr>";
						tbody += "<td>" + $(this).find("m_idx").text() + "</td>";
						tbody += "<td>" + $(this).find("m_id").text() + "</td>";
						tbody += "<td>" + $(this).find("m_pw").text() + "</td>";
						tbody += "<td>" + $(this).find("m_name").text() + "</td>";
						tbody += "<td>" + $(this).find("m_age").text() + "</td>";
						tbody += "<td>" + $(this).find("m_reg").text() + "</td>";
						tbody += "<td>삭제</td>";
						tbody += "</tr>";
					});
					$("#tbody").append(tbody);
					
				},
				error : function(){
					alert("읽기 실패");
				}
			})
		} 
		
		function getList2(){
			$.ajax({
				url : "/ajax_db_list2",
				method : "post",
				dataType : "json",
				success : function(data){
					let tbody = "";
					$.each(data, function(index, obj){
						tbody += "<tr>";
						tbody += "<td>" + obj.m_idx + "</td>";
						tbody += "<td>" + obj.m_id + "</td>";
						tbody += "<td>" + obj.m_pw + "</td>";
						tbody += "<td>" + obj.m_name + "</td>";
						tbody += "<td>" + obj.m_age + "</td>";
						tbody += "<td>" + obj.m_reg + "</td>";
						tbody += "<td>삭제</td>";
						tbody += "</tr>";
					});
					$("#tbody").append(tbody)
				},
				error : function(){
					alert("실패");
				}
			});
		}
		
		function getList3() {
			$.ajax({
				url : "/ajax_db_list3",
				method : "post",
				dataType : "text",
				success : function(data) {
				 // console.log(data);
				 let rows = data.split("\n");
				 let tbody = "";
				 
				 $.each(rows, function(index, row) {
					// 헤더가 있으면 제외
					if(index === 0 || row.trim() === ""){
						return true;
					}
					
					let cols = row.split(",");
					
					tbody +="<tr>";
					$.each(cols, function(i ,col) {
						tbody +="<td>" + col + "</td>" ;
					});
					 tbody += "<td>삭제</td>";
				 	 tbody +="</tr>";
				});
				 $("#tbody").append(tbody);
				},
				error : function() {
					alert("읽기실패")
				}
			});
		}
		
		$("#m_id").keyup(function(){
			$.ajax({
				url: "/ajax_id_chk",
				data : "m_id=" + $("#m_id").val(),
				method : "post",
				dataType : "text",
				success : function(data){
					if(data == '1'){
						//사용 불가
						$("span").text("사용 불가");
					} else if(data == '0'){
						//사용 가능
						$("span").text("사용 가능");
					}
				},
				error : function(){
					alert("읽기 실패");
				}
			})
		})
		
		
		
		$("#btn_join").click(function (){
			$.ajax({
				url : "/ajax_member_join",
//				data : {
//					m_id : $("#m_id").val(),
//					m_id : $("#m_pw").val(),
//					m_id : $("#m_name").val(),
//					m_id : $("#m_age").val()
//				},
				data : param,
				method : "post",
				dataType : "text",
				success : function(data){
					if(data == 0){
						alert("가입 실패");
					} else{
						$("#tbody").empty();
						getList();
						
						$("#m_id").val("");
						$("#m_pw").val("");
						$("#m_name").val("");
						$("#m_age").val("");
						
						// 주의) form은 배열로 넘어온다.
						$("myForm")[0].reset();
						$("span").text("중복여부");
						$("#btn_join").prop("disabled", true);
					}
				},
				error : function(){
					alert("실패");
				}
			})
		 })
		 
		 // 동적 바인딩 변수(click 안됨, on)
		 // #list가 부모  #member_del 가 자식
		 $("list").on("click", "#member_del", function(){
			 let m_id = $(this).attr("name");
			 alert(m_id);
		 })
		getList();
		 
	</script>

</body>
</html>