<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="ja">

<head>
	<title>楽天商品検索</title>
	<!-- meta-tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
</head>

<body>
	<!-- //short-->
	<form action="${pageContext.request.contextPath}/rakuten/IchibaItem/Search" method="post">
		<div>
			<p>検索キーワード </p>
			<input type="text" name="keyword" required="" />
		</div>
		<div class="">
			<p>ジャンルID</p>
			<input type="text" name="genreId" required="" />
		</div>
		<input type="submit" value="検索">
	</form>

</body>

</html>