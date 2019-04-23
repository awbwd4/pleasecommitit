/*
	댓글 관련 모듈 패턴.
	
 */

console.log("reply module............");

var replyService = (function(){
			
		/*function(){
			return {name:"AAAA"};
		}*/
		
			function add(reply, callback, error){
				console.log("reply 달기 시발ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
			
			$.ajax({
				
				type : 'post',
				url : '/replies/new',
				data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr){
					if (callback) {
						callback(result);
						/* ajax호출이 성공하고,
						 * callback 값으로 적절한 함수가 존재한다면
						 * 해당 함수를 호출해서 결과를 반영함
						*/
					}
				},
				error : function(xhr, status, er){
					if (error) {
						error(er);
					}
				} 
				
			//ajax끝	
			})			
		}
			
			
		//댓글의 목록 처리 : getJSON()의 사용
		 
		function getList(param, callback, error){
			
			var bno = param.bno;
			var page = param.page || 1;
			
			
			//url 호출시 확장자를 .json으로 요구함. 
			$.getJSON("/replies/pages/" + bno + "/" +page+".json",
				function(data){
					if(callback){
						callback(data);
					}
			}).fail(function(xhr, status, err) {
				if(error){
					error();
					}
			});
		}
			
			
		
		function remove(rno, callback, error){
			
			$.ajax({
				
				type : 'delete',
				url : '/replies/'+rno,
				success : function(deleteResult, status, xhr){
					
					if (callback) {
						callback(deleteResult);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
			});
		}
		
		return {
			add:add,
			getList : getList,
			remove : remove
		};
})();