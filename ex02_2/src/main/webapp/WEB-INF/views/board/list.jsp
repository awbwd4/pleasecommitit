<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- jstl의 출력과 포맷을 적용할 수 있는 태그라이브러리 -->


<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->



<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">

				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register</button>

			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="board">

						<tr>
							<td><c:out value="${board.bno}" /></td>

							<%-- <td><a href='/board/get?bno=<c:out value="${board.bno}"/>'
								target='_blank'> <c:out value="${board.title}" /></a></td> --%>
							<!-- 조회 페이지에서 다시 목록페이지로 넘어올때, 무조건 1페이지로 돌아가는 문제를 해결하기 위해서는
							조회페이지로 갈때, 현재 목록 페이지의 pageNum과  amount를 넘겨주어야 함. 
							
							위의 코드는, 페이지번호가 조회페이지까지 넘겨지지 않는 코드임. 
							따라서 아래의 코드처럼 <a>태그에 이동하려는 게시물의 번호만을 갖게 수정함. 
							실제 클릭은 js를 통해서 이루어짐. 
							 -->
						
						
							<td>
							<a class='move' href='<c:out value="${board.bno}"/>'> 
							<c:out value="${board.title}" /></a>
							</td>

							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updateDate}" /></td>
						</tr>

					</c:forEach>
				</table>


				<!-- 페이징 처리 -->

				<div class='pull-right'>
					<ul class="pagination">


						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a>
							</li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button    ${pageMaker.cri.pageNum == num ? "active": ""}">
							<a href="${num }"> ${num}</a>
							</li>
						</c:forEach>
                               

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${pageMaker.endPage +1}">Next</a>
							</li>
						</c:if>

					</ul>
				</div>



				<form id="actionForm" action="/board/list" method='get'>
					<input type='hidden' name='pageNum' value = '${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value = '${pageMaker.cri.pageNum }'>
				</form>







				<!-- Modal  추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->




			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->









<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							}

							if (parseInt(result) > 0) {
								$(".modal-body").html(
										"게시글 " + parseInt(result)
												+ " 번이 등록되었습니다.");
							}

							$("#myModal").modal("show");
						}

						
						
						
						
						$("#regBtn").on("click", function() {

							self.location = "/board/register";

						});

						
						
						var actionForm = $("#actionForm");

						
						
						$(".paginate_button a").on(
								"click",
								function(e) {

									e.preventDefault();

									console.log('click');

									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href"));
									actionForm.submit();
								});

						
						
						$(".move").on("click", function(e){
							
							e.preventDefault();
							actionForm.append("<input type='hidden' name='bno' value='"+
									$(this).attr("href")+"'>");
							actionForm.attr("action","/board/get");
							actionForm.submit();
							
							
						});
						
						
						
						
						
						
						/* 
						$(".move")
								.on(
										"click",
										function(e) {

											e.preventDefault();
											actionForm
													.append("<input type='hidden' name='bno' value='"
															+ $(this).attr(
																	"href")
															+ "'>");
											actionForm.attr("action",
													"/board/get");
											actionForm.submit();

										}); */

					/* 	var searchForm = $("#searchForm");

						$("#searchForm button").on(
								"click",
								function(e) {

									if (!searchForm.find("option:selected")
											.val()) {
										alert("검색종류를 선택하세요");
										return false;
									}

									if (!searchForm.find(
											"input[name='keyword']").val()) {
										alert("키워드를 입력하세요");
										return false;
									}

									searchForm.find("input[name='pageNum']")
											.val("1");
									e.preventDefault();

									searchForm.submit();

								}); */
					}); 
	
			
	
	
</script>

<%@include file="../includes/footer.jsp"%>
