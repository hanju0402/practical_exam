<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>정보처리기사 실기 사이트</title>
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<!--<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> -->
<link href="css/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
<script type="text/javascript" src="js/common/ajax.js"></script>

</head>
<body>
	<div class="s-layout">
		<!-- Sidebar -->
		<div class="s-layout__sidebar">
			<tiles:insertAttribute name="sidebar" />
		</div>

		<!-- Content -->
		<main class="s-layout__content">
			<tiles:insertAttribute name="body" />
		</main>
	</div>
</body>
</html>