<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카카오 지도 연습 - 2 (내 위치, 마커표시, 윈도우)</title>
	<script type="text/javascript">
		const lat = "";
		const lng = "";
		
		navigator.geolocation.getCurrentPosition(function(position){
			lat = position.coords.latitude;
			lng = position.coords.longitude;
		});
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };

		var map = new kakao.maps.Map(mapContainer, mapOption);
	
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 
	
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
	
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	
		var iwContent = '<div style="padding:5px;"><a href="https://ictedu.co.kr" style="color:blue" target="_blank">한구ICT인재개발원</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다
	
		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    position : iwPosition, 
		    content : iwContent 
		});
		  
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
	</script>
</head>
<body>
	<!-- 
	카카오 디벨로퍼 로그인 후 내 애플리케이션에서 애플리케이션 선택 후 javascript키 복사 :
	제품 - 지도/로컬 선택 - 문서보기 - 지도 - Maps API - WEB API 시작하기 - sample에 모든 정보가 다 있다. 
 --%>
	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width: 100%; height: 350px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e07bb4b8d5b0f2531b6c6721df5ac8eb"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표(경도, 위도)
			level : 5
		// 지도의 확대 레벨 (1-14)
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
	</script>
</body>
</html>