<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> AJAX(spa.jsp)</title>
</head>
<body>

	<h3>회원 등록</h3>
	<form action="" method="post">
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
				let tr = document.createElement("tr");
				
				for(let f of fields){
					let td = document.createElement("td");
					td.innerText = item[f]; // 
					
					tr.append(td);
				}
				
				tbody.append(tr);
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
	</script>



</body>
</html>