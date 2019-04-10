/**
 * 
 */

console.log("reply module............");

var replyService = (function(){
			
		/*function(){
			return {name:"AAAA"};
		}*/
		
			function add(reply, callback){
			console.log("reply........................");
			
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
			
		return {add:add};
})();