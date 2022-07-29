<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> AJAX(spa.jsp)</title>
</head>
<body>

	<h3>회원 등록</h3>
	<form action="addMemberAjax.do" method="post" name="addFrm">
		아이디: <input type="text" name="id"><br>
		이름: <input type="text" name="name"><br>
		이메일: <input type="email" name="mail"><br>
		비밀번호: <input type="password" name="passwd"><br>
		
		<input type="submit" value="회원등록">
	</form>

	<br><br>

	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>	
			</tr>
		</thead>
		
		<tbody id="list"></tbody>
		
	</table>
	<!-- AJAX(비동기 방식 처리) -->
	
	<!-- 먼저 실행한 것의 결과가 먼저 나오고 그다음거 그다음거 나오는데 동기방식임 -->
	<script>
	
	let i =0;
	let xhtp = new XMLHttpRequest();
	
	xhtp.open('get', 'memberJson.do');
	xhtp.send();
	
	xhtp.onreadystatechange = callBackThree; 
	

	let fields = ['id', 'passwd', 'name', 'mail']
	function callBackThree(){
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			//let tbody = document.querySelector("list");
			let tbody = document.getElementById("list");
			
			for(let item of data){
				let tr = makeTr(item);				
				tbody.append(tr);
			}			
		}
	}
	
	function makeTr(item){
		let tr = document.createElement("tr");
		
		for(let f of fields){
			let td = document.createElement("td");
			td.innerText = item[f]; // 
			
			tr.append(td);
		}
		
		//삭제버튼
		let tdBtn = document.createElement("td");
		let btn = document.createElement("button");
		
		//클릭 이벤트
		btn.addEventListener("click", deleteCallBack);
		
		btn.innerText="삭제";
		tdBtn.append(btn);		
		tr.append(tdBtn);
		
		return tr;
	}
	
	function deleteCallBack(e){
		let delId = this.parentElement.parentElement.firstElementChild.innerText;
		
		console.log(delId);
		
		let delAjax = new XMLHttpRequest();
		delAjax.open("post", "removeMemberAjax.do");
		delAjax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		delAjax.send("id="+delId);
		
		delAjax.onload = function(){			
			let result = JSON.parse(delAjax.responseText);			
			if(result.retCode == 'Success'){
				e.target.parentElement.parentElement.remove();	
				
			}else{
				alert("처리중 에러 발생");
			}			
		}		
	}
	
	function callBackTwo(){
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let ul = document.createElement("ul");
			for(let i of data){
				let li = document.createElement("li");
				li.innerHTML = i.name + ", " + i.age;
				
				ul.append(li);
			}
			
			document.querySelector('body').append(ul);			
		}
		
	}	

	
	function callBackOne() {
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			
			let name = document.createElement("p");
			name.innerText = data[0].name;
			
			let age = document.createElement("p");
			age.innerText = data.age;
			
			console.log(data);
			console.log(this.responseText);
			
			//document.write(xhtp.responseText);
			document.querySelector('body').append(name, age);
			}
		}
	
	//form 전송이벤트가 실행이 되면 발생하는 이벤트
	//document.forms.addFrm.addEventListner('submit', function)
	document.forms.addFrm.onsubmit = function(e){
		// 기본기능, 차단
		e.preventDefault();
		
		let url = document.forms.addFrm.getAttribute('action');
		let id = document.forms.addFrm.id.value;
		let passwd = document.forms.addFrm.passwd.value;
		let name = document.forms.addFrm.name.value;
		let mail = document.forms.addFrm.mail.value;
		
		let param = "id="+id+"&passwd="+passwd+"&name="+name+"&mail="+mail;
		//`id=${id}&passwd=${passwd}&name=${name}&mail=${mail}`;
		
		console.log(param);
		
		let addAjax = new XMLHttpRequest();
		addAjax.open('post', url);
		
		addAjax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		addAjax.send(param); //id=user1&passwd=1234&name=Hong&mail=email@naver.com
		
		addAjax.onload = function(){
			console.log(addAjax.responseText);			
			let data = JSON.parse(addAjax.responseText); // JSON -> Object
			
			document.getElementById('list').append(makeTr(data));
		}
	}
	
	</script>



</body>
</html>