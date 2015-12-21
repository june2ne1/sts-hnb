<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<LINK REL='stylesheet' type='text/css' href='${css}/board.css'/>	


<script type='text/javascript'>
	$(function() {
		board.init('142','1');
	});
	var board = {
			init : function(themeNo,pageNo) {
			$.getJSON(context+'/article/list/'+themeNo+'/'+pageNo, function(data) {
				
				
				var table = "<div id='boardList'><h1 align=center style='color:white;margin-bottom:30px'>자유게시판</h1>"
				+"<TABLE id='tab_borderList'>"
				+"<TR ALIGN=CENTER><TD WIDTH=8%><B>번호</B></TD>"
				+"<TD WIDTH=60%><B>제 목</B></TD>"
				+"<TD WIDTH=30%><B>내용</B></TD>"
				+"</TR>";
				$.each(data.list, function() {
					
				});
				table +="</TABLE></div>";
				+'<a href="'+context+'/article/write">글쓰기</a>';
				$('.mainView').html(table);
			});
		},

	};
</script>