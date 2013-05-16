<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BaseBallGame_jQuery</title>

<link rel="stylesheet" href="../components/css/bootstrap.css">

</head>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#userNum")
				.keypress(
						function(event) {
							if (event.which
									&& (event.which > 47 && event.which <= 57 || event.which == 8)) {
								/* for ( var i = 0; i < $("#userNum").val().length; i++) {
									if ($("#userNum").val()[i] === $("#userNum")
											.val()[i - 1]
											|| $("#userNum").val()[i] === $(
													"#userNum").val()[i - 2]) {
										console.log("dd");
										event.preventDefault();
									}
								} */
								if ($("#userNum").val().length >= 3) {
									event.preventDefault();
								}
							} else {
								event.preventDefault();
							}
						});
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
					$("p#result").append("Hit");
				}
			},
			complete : function() {
				$("#userNum").val("");
			}
		});
	};

	function doReset() {
		$("#result").html("");
		$("#userNum").val("");
		$.ajax({
			type : "POST",
			url : "/tdd_baseballGame/main/restartGame.do",
			dataType : "json",
			success : function(data) {
				console.log(data);
				$("#gameNo").text("NO: " + data.gameNo);
			}
		});
	};
</script>

<body>
	<h1>BaseballGame</h1>
	<p id="gameNo">NO: 1</p>
	<br /> 숫자입력
	<input type="text" name="userNum" id="userNum"'>
	<input type="button" value="play" onclick="doCompare()" id="btn1">
	<input type="reset" value="reset" onclick="doReset()" id="btn2">
	<p id="result"></p>
</body>
</html>