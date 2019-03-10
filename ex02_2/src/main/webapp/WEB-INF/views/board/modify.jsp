
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>



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

				<form role="form" action="/board/modify" method="post">

					<!-- 게시물 번호 -->
					<div class="form-group">
						<label>Bno</label><input class="form-control" name='bno'
							value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>

					<!-- 게시글 제목 -->
					<div class="form-group">
						<label>Title</label><input class="form-control" name='title'
							value='<c:out value="${board.title}"/>'>
					</div>

					<!-- 게시글 내용 -->
					<div class="form-gourp">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name='content'>
							<c:out value="${board.content}"/>
						</textarea>
					</div>

					<!-- 작성자 -->
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name='regDate'
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>'
							readonly="readonly">
					</div>


					<button type="submit" data-oper='modify' class="btn btn-default">
						Modify
					</button>

					<button type = "submit" data-oper='remove' class="btn btn-danger">
						Remove
					</button>
					
					<button type="submit" data-oper='list' class="btn btn-info">
						List
					</button>
					
					
				</form>

			</div>

		</div>

	</div>

</div>

<script type="text/javascript">

/* 

$(document).ready(function(){
	
	var formObj = $("form");
	
	$('button').on("click", function(e){
		
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if (operation === 'remove') {
			
			formObj.attr("action", "/board/remove");
		
		} else if(operation === 'list') {
			
			//move to list
			self.location = "/board/list";
			return;
			
			
			
			
			/*
			formObj.attr("action", "/board/list").attr("method","get");
			
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			var keywordTag = $("input[name='keyword']").clone();
			var typeTag = $("input[name='type']").clone();
			
			formObj.empty();
			
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(keywordTag);
			formObj.append(typeTag); 
			
		}
		
		formObj.submit();		
		
	});
	
});

 */
 $(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/board/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      
	      /* 수정전
	      self.location = "/board/list";
	      return;
	      */
	      
	      formObj.attr("action", "/board/list").attr("method", "get");
	      formObj.empty();
	     /*  
	     /board/list로의 이동은 아무런 파라미터가 없음
	     -> <form> 태그의 모든 내용은 삭제한 상태에서 submit()을 진행함.
	     */
	    }
	    
	    formObj.submit();
	  });

});
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

</script>



<%@include file="../includes/footer.jsp"%>