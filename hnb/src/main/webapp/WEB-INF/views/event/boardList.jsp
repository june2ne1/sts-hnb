<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL="stylesheet" type="text/css" href="${css}/board.css"/>	
	

 <script type="text/javascript">
 	$(function() {
 		board.load(context+'/event/boardList/1');
	});
 	
 	var board = {
 		load : function(url) {
 		  $.getJSON(url,function(data) {
			var table = '<TABLE id="tab_borderList"><TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD>'
			+' <TD WIDTH=20%><B>아이디</B></TD><TD WIDTH=20%><B>회원명</B></TD><TD WIDTH=30%><B>이메일</B></TD>'
			+'<TD WIDTH=18%><B>가입일</B></TD></TR>'
			/* <c:forEach var="member" items="${memberList}" varStatus="status">'
			+'<TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD><TD WIDTH=20% ALIGN=CENTER>${member.id}</TD>'
			+'<TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">${member.name}</A></TD>'
			+'<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD><TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR></c:forEach></TABLE>' */
			$('.mainView').empty();
			$('.mainView').html(table);
 		  });
 		
 		
 		
 		
 		
		}
 	 };

 </script>