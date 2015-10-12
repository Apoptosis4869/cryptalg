<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interstellar.2014.720p</title>
<script src="static/js/jquery-2.1.4.min.js"></script>
<!-- <style type="text/css">
	.div1{
		-moz-background-size:contain;
    	-webkit-background-size:contain;
   	 	-o-background-size:contain;
    	background-size:contain;
    	
    	background:url(static/images/Interstellar_BACKGROUND.jpg) no-repeat;
	}
</style> -->
<!-- If you'd like to support IE8 -->
<script type="text/javascript">
	$(function(){
		var height1 = $(".div1").height();
		var height2 = $(".div2").width();
		var height3 = height1 - height2;
		$(".div2").css("top",height3);
		var height4 = height1 - height3;
		$("#my-video").css("height",height4);
	});
</script>
</head>
<body>
	<div class="div1" style="position:absolute; width:100%; height:100%; z-index:-1">
	<img src="static/images/Interstellar_BACKGROUND.jpg" height="100%" width="100%"/>  
	<div class="div2" style="text-align: center;z-index:2;position:absolute;left:0;" >
		<video id="my-video" src="static/video/Interstellar.2014.720p.Chi_Eng.ZMZ-BD-MP4-V2.mp4" class="video-js" controls="controls" preload="auto"
			  poster="static/video/poster/Interstellar_POSTER.jpg">
			<p>
				To view this video please enable JavaScript, and consider upgrading
				to a web browser that
				</p>
		</video>
	</div>
	</div>
</body>
</html>