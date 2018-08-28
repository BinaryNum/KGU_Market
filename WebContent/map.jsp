<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/maps/documentation/javascript/demos/demos.css">
<title>Map</title>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 80%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 80%;
        margin: 20;
        padding: 0;
      }
</style>
</head>
<body>
 <div id="map"></div>
 	
 	<div id="floating-panel">
 		<input type="textbox" id="address" />
 		<input type="submit" id="submit" value="Geocode"/>
 	</div>
 
 	<script>
 		var marker  // global marker variable - 마커를 오로지 한개만 사용하기 위해 
		var markerCoordinate // marker coordinate
	
 		var selected_Latitude;
 		var selected_Longitude;
 		
 		
 		// Init MAP --------------------------------------------------------------------------------
 		function initMap() {
 
 			if(getParameterByName("lat") == null){ // first connect
 				markerCoordinate = {lat: 37.300482, lng: 127.035813}; // initial marker coordinate : suwon campus
 			}else{
 				// new url parameter
 				markerCoordinate = {lat: parseFloat(getParameterByName("lat")), lng:parseFloat(getParameterByName("lng"))}
 			}
 			var map = new google.maps.Map(document.getElementById('map'), {
      			center: markerCoordinate, // map initial position
      			zoom: 15
     		});
 			// make iniital marker
      		marker = new google.maps.Marker({
      			position: markerCoordinate,
      			map: map
     		});
 			
 			var geocoder = new google.maps.Geocoder();
 			
 			document.getElementById("submit").addEventListener('click', function(){ // 검색 버튼 눌렀을 때 
    				if (marker && marker.setMap) {
    					marker.setMap(null);
    				} // remove previous marker
    			
 				geocodeAddress(geocoder, map)
 			})
 			
 			// map click event - 맵을 눌렀을 때 
      		map.addListener('click', function(e) {
      			placeMarkerAndPanTo(e.latLng, map);
     		});
      	}
 		// ------------------------------------------------------------------------------------------ Init MAP
 		
 		// MAP CLICK --------------------------------------------------------------------------------
 		function placeMarkerAndPanTo(latLng, map) {
    			if (marker && marker.setMap) {
    				marker.setMap(null);
    			} // remove previous marker
    			
    			// get clicked Marker coordinates
    			selected_Latitude = latLng.lat()
    			selected_Longitude = latLng.lng()    	
    			
    			// make new marker
    			marker = new google.maps.Marker({
    	    			position: latLng,
    	    			map: map
    	    		});

    			// 클릭된 곳의 좌표로 URL을 바꾼다.
			window.location.assign("http://localhost:8181/Mail_Authentication/map.jsp?lat="+selected_Latitude + "&lng=" + selected_Longitude)
    	  		map.panTo(latLng);
    	  	}
 		// --------------------------------------------------------------------------------------- MAP CLICK
 		
 		// SEARCH --------------------------------------------------------------------------------
 		function geocodeAddress(geocoder, resultsMap) {
 	        var address = document.getElementById('address').value;
 	        geocoder.geocode({'address': address}, function(results, status) {
 	          if (status === 'OK') {
 	            resultsMap.setCenter(results[0].geometry.location);
 	            marker = new google.maps.Marker({ // 검색된 마커를 그린다.
 	              map: resultsMap,
 	              position: results[0].geometry.location
 	            });
 	           window.location.assign("http://localhost:8181/Mail_Authentication/map.jsp?lat="+results[0].geometry.location.lat() + "&lng=" + results[0].geometry.location.lng())
 	           //검색된 마커의 좌표로 URL을 바꾼다.
 	          } else {
 	            alert('Geocode was not successful for the following reason: ' + status);
 	          }
 	        });
 	      }
		// ---------------------------------------------------------------------------------------- SEARCH
 		
 		// Get url Parameter function --------------------------------------------------------------------------------
 		function getParameterByName(name, url) {
 		    if (!url) url = window.location.href;
 		    name = name.replace(/[\[\]]/g, "\\$&");
 		    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
 		        results = regex.exec(url);
 		    if (!results) return null;
 		    if (!results[2]) return '';
 		    return decodeURIComponent(results[2].replace(/\+/g, " "));
 		}
		// ------------------------------------------------------------------------------------------------------------ Get url Parameter function
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9-t6SvVlLwMdvRsTk6z1R2V7QshrQPps&callback=initMap"
    async defer></script>
    
    
    <!--맵에서 선택 후 넘어가는 Form action URL은 변경해주세요  -->
    <form action="/Mail_Authentication/Map" method="post">
    		<input type="hidden" name="lat" value = <%=request.getParameter("lat") %>/>
    		<input type="hidden" name="lng" value = <%=request.getParameter("lng") %> />
    		<input type="submit" />
    </form>
  </body>
</body>
</html>