
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>	
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
			
				
					<!-- 게시물 번호 -->
					<div class="form-group">
						<label>Bno</label><input class="form-control" name ='bno'
							value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
					
					<!-- 게시글 제목 -->
					<div class="form-group">
						<label>Title</label><input class="form-control" name ='title'
						value='<c:out value="${board.title}"/>' readonly="readonly" >
					</div>
					
					<!-- 게시글 내용 -->
					<div class="form-gourp">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name ='content'
							 readonly="readonly">
							<c:out value="${board.content}"></c:out>
						</textarea>
					</div>	
								
					<!-- 작성자 -->
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer"
						 value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>
				
					<%-- <button data-oper='modify' class="btn btn-default">
						
						<a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a>
						
					</button>
					
					
					<button data-oper='list' class="btn btn-default">
					
					<a href="/board/list">List</a>
					
					</button> --%>
				
					
					<button data-oper='modify' class="btn btn-default">Modify</button>
					<button data-oper='list' class="btn btn-default">List</button>
					
					<form id='operForm' action="/board/modify" method="get">
					
						<input type="hidden" id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
						<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
						<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
						
						<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'/>
						<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'/>
						
						
						<!-- 버튼을 누르면 form태그를 이용함.
						버튼을 누르면서 pageNum과 amount가 같이 이동
						
						pageNum + amount : 리스트->조회페이지->수정/리스트
						 -->
						
				</form>
			</div>

		</div>

	</div>

</div>


<!-- reply.js -->
<script type = "text/javascript" src = "/resources/js/reply.js"></script>


<!-- reply.js에 있는 replyService변수의 값을 콘솔에 출력. -->
<script>

	/* $(document).ready(function(){
	
		console.log(replyService);
		
	}); */
	console.log("=================================");
	console.log("JS TEST");
	
	var bnoValue = '<c:out value="${board.bno}"/>';
	
	
	
	replyService.getList({bno:bnoValue, page:1}, function(list){
		
		for (var i = 0, len = list.length||0; i < len ; i++) {
			console.log(list[i]);
		}
	}); 
	
	
	//for replyService add test
	/* replyService.add(
		{reply:"JS TEST", replyer:"tester", bno:bnoValue}		
		,
		function(result){
			alert("RESULT : "+result);
		}
	); */
	
	/* 
	replyService.remove(23, function(count){
		
		console.log(count);
		
		if(count === "success"){
			alert("removed");
		}
	}, function(err){
		alert('ERROR.............');
	});
			 */
			
	
	
	
	
</script>




<script type="text/javascript">
<!--

//-->
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		
		$("button[data-oper='modify']").on("click", function(e){
			
			operForm.attr("action","/board/modify").submit();
			
		});
		
		
		$("button[data-oper='list']").on("click", function(e){
			
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list");
			operForm.submit();
			
		});
		
	});

</script>


<%@include file="../includes/footer.jsp" %>