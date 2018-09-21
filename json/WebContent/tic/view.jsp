<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/json/js/AjaxUtil.js"></script>
<body>
	<table border='1'>
		<tr>
			<th>번호</th>
			<td data-col="tmnum"></td>
		</tr>
		<tr>
			<th>영화명</th>
			<td data-col="tmname"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td data-col="tmprice"></td>
		</tr>
		<tr>
			<th>개봉일</th>
			<td data-col="tmstartdat"></td>
		</tr>
		<tr>
			<th>종영일</th>
			<td data-col="tmenddat"></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td data-col="tmcredat"></td>
		</tr>
		<tr>
			<th>관객수</th>
			<td data-col="tmcnt"></td>
		</tr>
		<tr>
			<td><button id='tmup' type="button">수정</button></td>
			<td><button id='tmdel' type="button">삭제</button></td>
		</tr>
	</table>
	<script>
	String.prototype.replaceAll = function(str1,str2){
		var re = new RegExp(str1,'gi');
		return this.replace(re,str2);
	}
	
		var tmnum =
	<%=request.getParameter("tmnum")%>
		console.log(tmnum);
		var tdAll = document.querySelectorAll('td[data-col]');

		window.onload = function() {
			var conf = {
				url : '/json/api/ticket/view',
				params : {
					tmnum : tmnum
				},
				cb : callback
			}
			console.log({tmnum:tmnum});
			var au = new AjaxUtil(conf);
			au.send();
			function callback(res) {
				res = JSON.parse(res);
				tdAll.forEach(function(td) {
					if(td.getAttribute('data-col')=='tmnum'){
						td.insertAdjacentHTML('afterbegin',res[td.getAttribute('data-col')]);
						return;
					}
					td.insertAdjacentHTML('afterbegin', '<input value='
							+ res[td.getAttribute('data-col')] + '>');
				});
				
				for(rs in res){
					console.log(res.rs);
				}

			}
		}

		var tmup = document.querySelector('#tmup');
		tmup.onclick = function() {
			var params = {};
			tdAll.forEach(function(td) {
				
				var key = td.getAttribute('data-col');
				var value = td.firstChild.value;//input박스의 값
				
				if(td.getAttribute('data-col')=='tmnum'){
					value = td.firstChild.wholeText;
					params[key] = value;
					return;
				}
				
				params[key] = value;
			});
			var conf = {
				url : '/json/api/ticket/update',
				method : 'PUT',
				params : params,
				cb : callback
			}
			var au = new AjaxUtil(conf);
			au.send();
			function callback(res) {
				res = JSON.parse(res);
				if (res.cnt == 1) {
					alert('수정완료')
					location.href = '/json/tic/list.html';
					return;
				}

				alert('실패');

			}
		}

		var tmdel = document.querySelector('#tmdel');
		tmdel.onclick = function() {
			var conf = {
				url : '/json/api/ticket/delete',
				method : 'DELETE',
				params : {
					tmnum : tmnum
				},
				cb : callback
			}
			var au = new AjaxUtil(conf);
			au.send();
			function callback(res) {
				res = JSON.parse(res);
				if (res.cnt == 1) {
					alert('삭제완료')
					location.href = '/json/tic/list.html';
					return;
				}

				alert('실패');
			}
		}
	</script>
</body>