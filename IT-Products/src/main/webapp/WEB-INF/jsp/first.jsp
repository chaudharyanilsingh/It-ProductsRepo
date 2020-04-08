<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IT-Products</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<form id="userdata" action="/add" method="post">
		<div>
			<h1>Managed Security Services</h1>
			<p>&dollar; 2549.99</p>
			<div>
				<label for="qty-1">Quantity</label> <input type="text"
					name="mss" id="mss" />
			</div>
		</div>
		<div>
			<h1>Engineering & integration</h1>
			<p>&dollar; 1025.50</p>
			<div>
				<label>Quantity</label> <input type="text" name="ei"
					id="ei" />
			</div>

		</div>

		<div>
			<h1>Training</h1>
			<p>&dollar; 100</p>

			<div>
				<label>Quantity</label> <input type="text" name="training"
					id="training" />
			</div>

		</div>
		<br> promo-code : <input type="text" id="promocode" name="promocode"> <input
			type="button" id="promosubmit" value="APPLY"> <b><span
			id="message" style="color: green;"></span></b> <br>

		<div>
			<input type="submit" id="formsubmit">
		</div>
	</form>

	<br>
	<script language="javascript" type="text/javascript">
		var status;
		$(document).ready(function(){
		$("#promosubmit").click(function() {
			var mss = $('#mss').val();
			var ei = $('#ei').val();
			var trainq = $('#training').val();
			var totalprice = ((2549.99 * mss)
			+ (1025.50 * ei) + (100 * trainq));
			var promocode = $('#promocode').val();
			var itemData = {"name" : promocode,
					"totalPrice" : totalprice
					}
			alert(JSON.stringify(itemData));
			$.ajax({
				type : "POST",
				
				contentType : "application/json",
				
				url : "/check-promo",
				
				data : JSON.stringify(itemData),
							
				dataType : 'json',
				
				success : function(w) {
					status = w;
					if (w) {
						$('#message').html("HURRAY! You got OFF");

						
						
					} else {
					
						$('#message').html("SORRY! Invalid Promo-Code");

											
					}
					},
					error : function(e) {
						alert("Error! error in checking ");

					}
														
			});
			})
})
	</script>

</body>
</html>

