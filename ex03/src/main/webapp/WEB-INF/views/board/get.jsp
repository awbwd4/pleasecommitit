
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


				<!-- 게시물 번호 -->
				<div class="form-group">
					<label>Bno</label><input class="form-control" name='bno'
						value='<c:out value="${board.bno}"/>' readonly="readonly">
				</div>

				<!-- 게시글 제목 -->
				<div class="form-group">
					<label>Title</label><input class="form-control" name='title'
						value='<c:out value="${board.title}"/>' readonly="readonly">
				</div>

				<!-- 게시글 내용 -->
				<div class="form-gourp">
					<label>Text Area</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly">
							<c:out value="${board.content}"></c:out>
						</textarea>
				</div>

				<!-- 작성자 -->
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
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

					<input type="hidden" id='bno' name='bno'
						value='<c:out value="${board.bno}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>

					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>' /> <input type='hidden'
						name='type' value='<c:out value="${cri.type}"/>' />


					<!-- 버튼을 누르면 form태그를 이용함.
						버튼을 누르면서 pageNum과 amount가 같이 이동
						
						pageNum + amount : 리스트->조회페이지->수정/리스트
						 -->

				</form>
			</div>

		</div>

	</div>

</div>


<!-- 댓글 목록들 -->

<div class='row'>
	<div class="col-lg-12">
		//
		<div class="panel panel-default">

			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
					Reply</button>
			</div>

			<!-- panel heading -->
			<div class="panel-body">

				<!-- 개별 댓글 창 -->
				<ul class="chat">
					<!-- start reply -->
					<!-- <li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user000</strong> <small
									class="pull-right text-muted">2019-04-23 13:13</small>
							</div>
							<p>good job!</p>
						</div>
					</li> -->
				</ul>
				<!-- ./ end ul -->

			</div>

		<div class="panel-footer">
		<!-- 댓글 페이지 번호를 출력하는 부분-->
			
		
		</div>
			<!-- /. panel .chat-panel -->
		</div>

	</div>

	<!-- end of row -->
</div>




<!-- 댓글 추가를 위한 모달 창 -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		
		
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
		
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name='reply' value='New Reply!!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name='replyer' value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name='replyDate' value=''>
				</div>
			</div>
		
			<div class="modal-footer">
				<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
				<button id="modalRemoveBtn" type="button" class="btn btn-warning">Remove</button>
				<button id="modalRegisterBtn" type="button" class="btn btn-warning">Register</button>
				<button id="modalCloseBtn" type="button" class="btn btn-warning">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->














<!-- reply.js -->
<script type="text/javascript" src="/resources/js/reply.js"></script>


<!-- reply.js에 있는 replyService변수의 값을 콘솔에 출력. -->
<script>
	/* $(document).ready(function(){
	
		console.log(replyService);
		
	}); */
	console.log("=================================");
	console.log("JS TEST");

	var bnoValue = '<c:out value="${board.bno}"/>';

	/*
	replyService.getList({bno:bnoValue, page:1}, function(list){
		
		for (var i = 0, len = list.length||0; i < len ; i++) {
			console.log(list[i]);
		}
	}); 
	 */

	//for replyService add test
	/*
	 replyService.add(
		{reply:"JS TEST", replyer:"tester", bno:bnoValue}		
		,
		function(result){
			alert("RESULT : "+result);
		}
	); 
	 */

	//24번 댓글 삭제 테스트.
	/*
	 replyService.remove(41, 
		/////////////	
		function(count) {
		
		console.log(count);
		
		if(count === "success"){
			alert("REMOVED.............");
		}
	}, 
	////////
	function(err){
		alert('ERROR.............');
	}); 
			
	 */

	//62번 댓글 수정
	//클릭한 게시글에 있는 댓글의 번호를 매칭하지 않아서?
	/*
	replyService.update({rno : 62,
		bno : bnoValue,
		reply : "Modified reply............"},
		function(result){
			alert("수정 완료..........");
		}
	);
	
	//댓글 조회 : 댓글의 번호만 전달함. 
	replyService.get(10, function(data){
		console.log(data);
	});
	 */
</script>




<script type="text/javascript">
<!--
	//-->
	$(document).ready(
					
		function() {
				console.log("자바스크립트 준비");
						
			var operForm = $("#operForm");
			var bnoValue = '<c:out value="${board.bno}"/>';
			var replyUL = $(".chat");

			showList(1);

			function showList(page) {
				//showList : 페이지 번호를 파라미터로 받도록 설계.
				//파라미터가 없는 경우에는 자동으로 1페이지가 되도록 설정. 
							
				console.log("show list" + page);
							
				replyService.getList(
								{ bno : bnoValue, page : page || 1 },
											
								function(replyCnt, list) {//getList에 들어가는 callBack 함수
													
									console.log("getList 함수");
									console.log("replyCnt : " + replyCnt);
									console.log("list : "+list);
									console.log(list);
												
												
									if (list == null) {
										console.log("객체 전달 안됨");
									}else{
										console.log("뭐가 있긴 있음");
									}
												
												
												
									if (page == -1) {
									pageNum = Math.ceil(replyCnt/10.0);
										//page == -1이면
										//마지막 페이지를 찾아서 다시 호출하게 됨.
										showList(pageNum);
										return;
									}

												
									var str = "";

									if (list == null || list.length == 0) {

										//replyUL.html("");

										return;
									}

									for (var i = 0, len = list.length || 0; i < len; i++) {

										str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
										
										str +="  <div><div class='header'><strong class='primary-font'>["
									    	   +list[i].rno+"] "+list[i].replyer+"</strong>"; 
									    	   
									    str +="    <small class='pull-right text-muted'>"
									               +replyService.displayTime(list[i].replyDate)+"</small></div>";
											
									    str +="    <p>"+list[i].reply+"</p></div></li>";
									}

									replyUL.html(str);
												
												
									showReplyPage(replyCnt);

								});//end function
											
			}//end showList

						
						
						

			/* 댓글 페이지 번호 출력 로직 */
						
			var pageNum = -1;
			var replyPageFooter = $(".panel-footer");
						
			function showReplyPage(replyCnt){
							
				console.log("showReplyPage시작")
							
							
				var endNum = Math.ceil(pageNum/10.0)*10;
				var startNum = endNum -9;
							
							
				var prev = startNum != 1;
				//현재 페이지 넘버가 1인지를 판단.
				//1이 아니라야 앞으로 넘기는게 가능함
				var next = false;
						
				if (endNum * 10 >= replyCnt) {
					endNum = Math.ceil(replyCnt/10.0);
				}
							
				if (endNum * 10 < replyCnt) {
					next = true;
				}
							

				var str = "<ul class='pagination pull-right'>";
							
				////앞으로 가는 버튼//
				if(prev){
					str += "<li class='page-item'><a class = 'page-link' href = '"+(startNum -1)+"'>Previous</a></li>"
				}
							
							
				for (var i = startNum; i <= endNum ; i++) {
								
					var active = pageNum == i ? "active": "";
					//현재 pageNum이 i 와 같다면 "active"를 넣음.
								
					str += "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
								
				}

							
				////뒤로 가는 버튼//
				if(next){
					str += "<li class='page-item'><a class = 'page-link' href = '"+(endNum + 1)+"'>Next</a></li>"
								
				}
							
							
							
				str += "</ul></div>"
				//페이징 끝
							
				console.log("str : "+str);
							
				replyPageFooter.html(str);
				//replyPageFooter에 str
						
			}
						
						
						
						
			replyPageFooter.on("click","li a", function(e){
			       e.preventDefault();
			       console.log("page click");
						       
			       var targetPageNum = $(this).attr("href");
						       
			       console.log("targetPageNum: " + targetPageNum);
						       
			       pageNum = targetPageNum;
						       
			       showList(pageNum);
			     });     
						
						
						
						
						
						
						
			///////////////////////////////////////////
						
					

						
			////////////모달창 관련 함수들////////////////////
			var modal = $(".modal");
			var modalInputReply = modal.find("input[name='reply']");
			var modalInputReplyer = modal.find("input[name='replyer']");
			var modalInputReplyDate = modal.find("input[name='replyDate']");
						
			var modalModBtn = $("#modalModBtn");
			var modalRemoveBtn = $("#modalRemoveBtn");
			var modalRegisterBtn = $("#modalRegisterBtn");
			var modalCloseBtn = $("#modalCloseBtn");
						
						
						
			$("#addReplyBtn").on("click", function(e){
							
				modal.find("input").val;
				modalInputReplyDate.closest("div").hide();
				//.closest() 상위요소를 찾아주는 함수. 선택자를 기준으로 가장 가까운 상위 요소.
				//modalInputReplyDate를 기준으로 여기서는 가장 가까운 div를 찾아줌.
				//이경우 replyDate가 속해있는 div 자체를 숨김
							
							
				modal.find("button[id != 'modalCloseBtn']").hide();
				//닫기버튼을 제외한 모든 버튼 숨기기
							
				modalRegisterBtn.show();//등록버튼은 보여주기
							
				$(".modal").modal("show");							
							
			});
						
						
			modalRegisterBtn.on("click", function(){
							
				var reply = {
						reply : modalInputReply.val(),
						replyer : modalInputReply.val(),
						bno : bnoValue
				};
							
							
				replyService.add(reply, function(result){
								
					alert(result);
								
					modal.find("input").val("");
					//댓글 등록이 성공하면 경고창으로 결과를 알려주고, 입력 항목을 비움.
					modal.modal("hide");//모달창을 닫는다.
								
					//showList(1);
					//새 댓글이 달렸으므로 댓글 목록 갱신
								
								
					//사용자가 새로운 댓글을 추가하면
				//showList(-1);을 호출 하여 댓글의 숫자 파악 후 마지막 페이지를 호출
					showList(-1);
								
				});
			});
						
						
						
						
			/* 댓글 클릭시 수정/삭제가 가능한 모달 창이 뜨도록 */
			$(".chat").on("click", "li", function(e){
							
				var rno = $(this).data("rno");
							
							
				replyService.get(rno, function(reply){
							
					modalInputReply.val(reply.reply);
							
					modalInputReplyer.val(reply.replyer);
					modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
						.attr("readonly", "readonly");
								
					modal.data("rno", reply.rno);
								
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalModBtn.show();
					modalRemoveBtn.show();
								
					$(".modal").modal("show");
								
				});
							
			});
						
						
			/* 댓글 수정/삭제 이벤트 처리 */
			modalModBtn.on("click", function(e){
							
		 		var reply = {rno:modal.data("rno"), reply:modalInputReply.val()};
							
							
				replyService.update(reply, function(result){
								
					alert(result);
					modal.modal("hide");//수정 후 모달창 닫기
					showList(1);
											
				});
						
			});
						
						
						
						
			/*댓글 모달창 닫기*/
			modalCloseBtn.on("click", function(e){
							
				modal.modal("hide");
						
			});
						
						
						
						
		});
	
	
	
	
</script>





<script type="text/javascript">

$("button[data-oper='modify']").on(
		"click",
		function(e) {

			operForm.attr("action", "/board/modify")
					.submit();

		});

$("button[data-oper='list']").on("click", function(e) {

	operForm.find("#bno").remove();
	operForm.attr("action", "/board/list");
	operForm.submit();

});

</script>



<%@include file="../includes/footer.jsp"%>