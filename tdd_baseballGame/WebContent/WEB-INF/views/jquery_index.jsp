<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BaseBallGame_jQuery</title>

<!--  --><link rel="stylesheet" href="../components/css/horizontal.css">
<link rel="stylesheet" href="../components/css/bootstrap.css">

<!-- <style type="text/css">
</style> -->


</head>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- <script type="text/javascript" src="../components/js/horizontalNav.js">
	
</script> -->

<script type="text/javascript">
	$(document).ready(function() {
		$('.full-width').horizontalNav();
	});

	function doCompare() {
		$.ajax({
			type : "POST",
			url : "/tdd_baseballGame/main/getData.do",
			data : {
				'userNum' : $('#userNum').val()
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				$("p#result").append(
						data.gameCount + "번째 시도:  [" + $('#userNum').val()
								+ "] " + data.result + "<br/>");
				if (data.result === "hit") {
					$("#gameNo").text("NO: " + data.gameNo);
					doReset();
				}
			}
		});
	};

	function doReset() {
		$("#result").html("");
	};
</script>
<body>
	<h1>BaseballGame</h1>
	<p id="gameNo">NO: 0</p>
	<br /> 숫자입력
	<input type="text" name="userNum" id="userNum">
	<input type="button" value="play" onclick="doCompare()" id="btn1">
	<input type="reset" value="reset" onclick="doReset()" id="btn2">
	<p id="result"></p>
</body>
</html>