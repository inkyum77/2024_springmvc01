<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{width: 800px; border-collapse: collapse;}
	table, th, td { border: 1px solid red; text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h2>Ajax 연습하는 장소</h2>
	<button id="btn1">text 테스트</button>
	<button id="btn2">xml 테스트</button>
	<button id="btn3">날씨 xml 테스트</button>
	<button id="btn4">공공데이터 포털 xml 테스트</button>
	
	
	<hr>
	<div id="result"></div>
	
	<script type="text/javascript">
		$("#btn1").click(function() {
			$("#result").empty();
			$.ajax({
				url : "/test01",        // 서버주소   
				method : "post",        // 전달방식 
				dataType:"text",        // 가져오는 결과 데이터 타입    
			   // data : "",            // 서버에 갈때 가져갈 데이터(파라미터)
			   // async : true 또는 false // 비동기=(기본,생략,true), 동기 =false
			   success : function(data) {
				   $("#result").append(data);
			   },
			   error:function() {
				 alert("읽기실패")
			   }
			});
		});
		
		$("#btn2").click(function() {
			$("#result").empty();
			$.ajax({
				url : "/test02",        // 서버주소   
				method : "post",        // 전달방식 
				dataType:"xml",        // 가져오는 결과 데이터 타입    
			   // data : "",            // 서버에 갈때 가져갈 데이터(파라미터)
			   // async : true 또는 false // 비동기=(기본,생략,true), 동기 =false
			   success : function(data) {
				   let table = "<table >";
				   table += "<thead><tr><th>회사</th><th>차명</th><th>개수</th></tr></thead>";
				   table += "<tbody>";
				   $(data).find("product").each(function() {
					    let company = $(this).text();
					    let name =  $(this).attr("name");
					    let count = $(this).attr("count");
					    
					    table += "<tr>";
					    table += "<td>" + company + "</td>";
					    table += "<td>" + name + "</td>";
					    table += "<td>" + count + "</td>";
					    table += "</tr>";
					});
				   table += "</tbody>";
				   table +="</table>";
				   
				   $("#result").append(table);
			   },
			   error:function() {
				 alert("읽기실패")
			   }
			});
		});
		
		$("#btn3").click(function() {
			$("#result").empty();
			$.ajax({
				url : "/test03",       // 서버주소   
				method : "post",       // 전달방식 
				dataType:"xml",        // 가져오는 결과 데이터 타입    
			   success : function(data) {
				 let table = "<table>";
				 table += "<thead><tr><th>지역</th><th>온도</th><th>상태</th><th>아이콘</th></tr></thead>" ;
				 table += "<tbody>";
				  $(data).find("local").each(function() {
				     let local = $(this).text();
				     let ta = $(this).attr("ta");
				     let desc = $(this).attr("desc");
				     let icon = $(this).attr("icon");
				     
				     table += "<tr>";
				     table += "<td>" + local + "</td>";
				     table += "<td>" + ta + "</td>";
				     table += "<td>" + desc + "</td>";
				     table += "<td><img src='https://www.kma.go.kr/images/icon/NW/NB" + icon+ ".png'></td>";
				     table += "</tr>";
				  });
				 table += "</tbody>";
				 table += "</table>";
				 $("#result").append(table);
			   },
			   error:function() {
				 alert("읽기실패")
			   }
			});
		});
		
		$("#btn4").click(function(){
		    $("#result").empty();  // 기존 내용을 초기화
		    $.ajax({
		        url : "/test04",  // 서버에 요청을 보낼 URL
		        method : "post",
		        dataType : "xml",  // 서버에서 XML 응답을 받음
		        success : function(data){
		            // 1. 테이블과 thead 생성
		            var table = $("<table></table>").attr("id", "xmlTable").attr("border", "1");
		            var thead = $("<thead></thead>");
		            var headerRow = "<tr><th>회사</th><th>차명</th><th>개수</th></tr>";
		            thead.append(headerRow);
		            table.append(thead);

		            // 2. tbody 생성
		            var tbody = $("<tbody></tbody>");
		            $(data).find('product').each(function(){
		                var local = $(this).attr('name');   // 제품 이름 속성 추출
		                var count = $(this).attr('count'); // 개수 속성 추출
		                var company = $(this).find('company').text(); // <company> 태그 내용 추출

		                // 3. tbody에 새로운 행 추가
		                var row = "<tr><td>" + company + "</td><td>" + name + "</td><td>" + count + "</td></tr>";
		                tbody.append(row);
		            });

		            // 4. 테이블에 tbody 추가
		            table.append(tbody);

		            // 5. 결과 div에 테이블 추가
		            $("#result").append(table);
		        },
		        error : function(){
		            alert("읽기 실패");
		        }
		    });
		});
		
	</script>
</body>
</html>