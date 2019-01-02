<html>
<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<style>
		.error{
		color:red;
		}
	</style>
</head>
<body>
<div class="container-fluid">
	<h1 align="center" class="jumbotron col-lg-12 col-md-12 col-sm-12 col-xs-12" >CUSTOMER CRM</h1>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a style="width:100%" class="btn btn-success" href="${pageContext.request.contextPath}/customer/list">Web-App Service</a></div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			<a style="width:100%" class="btn btn-success">Rest Service</a>
			<hr>
			<center>
				<b><a style="text-align:center," href="${pageContext.request.contextPath}/api/customers">Get All Customer</a></b>
			</center>
			<hr>
		</div>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
</div>
</body>
</html>