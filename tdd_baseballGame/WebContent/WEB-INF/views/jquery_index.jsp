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
								if ($("#userNum").val().length >= 3) {
									event.preventDefault();
								}
							} else {
								event.preventDefault();
							}
						});
		$("#userNum").keyup(function(event) {
			var input = $("#userNum").val();
			for ( var i = 1; i < input.length; i++) {
				if (input[i - 1] === input[i] || input[i - 2] === input[i]) {
					$("#btn1").attr("disabled", "disabled");
					event.preventDefault();
				} else {
					$("#btn1").removeAttr("disabled");
				}
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
				var row = "<tr><td>" + data.gameCount + "</td>" + "<td>"
						+ $('#userNum').val() + "</td>" + "<td>" + data.result
						+ "</td></tr>";
				$("tr#result").after(row);

				if (data.result === "hit") {
					$("#gameNo").text("NO: " + data.gameNo);
					doReset();
					$("tr#result").append("<td>Hit</td>");
				}
			},
			complete : function() {
				$("#userNum").val("");
			}
		});
	};

	function doReset() {
		$("#userNum").val("");
		$.ajax({
			type : "POST",
			url : "/tdd_baseballGame/main/restartGame.do",
			dataType : "json",
			success : function(data) {
				$("#gameNo").text("NO: " + data.gameNo);
			}
		});
	};
</script>

<body>
	<h1>BaseballGame</h1>
	<p id="gameNo">NO: 1</p>
	<br /> 숫자입력
	<input type="text" name="userNum" id="userNum">
	<input type="button" value="play" onclick="doCompare()" id="btn1">
	<input type="reset" value="reset" onclick="doReset()" id="btn2">

	<table id="tclean" border="1" width="30%">
		<tr id="result">
			<th>no</th>
			<th>inputNum</th>
			<th>result</th>
		</tr>
	</table>

	<!-- <p id="result"></p> -->
</body>
</html>