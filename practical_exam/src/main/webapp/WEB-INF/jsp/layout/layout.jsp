<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>정보처리기사 실기 사이트</title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link href="css/header.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="js/common/ajax.js"></script>
	<script type="text/javascript" src="js/common/header.js"></script>
    
  </head>
   <body>
    <section class="content">
      <tiles:insertAttribute name="header"/>
      <tiles:insertAttribute name="body"/> 
      <tiles:insertAttribute name="footer"/>
    </section>
  </body>
</html>