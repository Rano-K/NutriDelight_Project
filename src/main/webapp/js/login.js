/**
 * 
 */

 function checkMember() {
	const regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	const regExpName = /^[가-힣]*$/
	const regExpPasswd = /^[0-9|a-z|A-Z]*$/
	const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
	const regExpAddress = /^[가-힣\s]*$/
	const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	const regExpAdmin = /^(?!.*(?:admin|root|insert|update|revoke|submit|select|delete|create|drop))^.*$/
	const regExpBirth = /^(19[7-9]\d|20[0-9]{2})\.(0[1-9]|1[0-2])\.(0[1-9]|[12]\d|3[01])$/;
	
	const id = document.getElementById("userid").value
	const inputid = document.getElementById("inputID").value
	const idCheck = document.getElementById("idCheck").value
	const name = document.getElementById("name").value
	const passwd1 = document.getElementById("password1").value
	const passwd2 = document.getElementById("password2").value
	const phone = document.getElementById("telno").value
	const address = document.getElementById("address").value
	const email = document.getElementById("email").value
	const birthdate = document.getElementById("age").value
	const gender = document.querySelector('input[name="gender"]:checked').value;
	const allergy = document.getElementById("allergyCheck").value
	
	if(!regExpId.test(id)){
		alert("아이디는 문자로 시작해 주세요.")
		//form.uid.select()
		return
	}
	
	if(!regExpAdmin.test(inputid)){
		alert("사용이 불가능한 아이디 입니다. 다시 작성해주세요.")
		//form.uid.select()
		return
	}
	
	if(idCheck.value == 0){
		alert("아이디 중복체크를 해주세요.")
		return	
	}
	
	if(!regExpName.test(name)){
		alert("이름은 한글로만 입력해 주세요.")
		//form.uname.select()
		return
	}
	
	if(passwd1 == "" || passwd2 == ""){
		alert("비밀번호를 입력해 주세요.")
		//form.upasswd1.select()
		return
	}
	
	if(!regExpPasswd.test(passwd1) || !regExpPasswd.test(passwd2)){
		alert("비밀번호는 영문 또는 숫자로만 입력해 주세요.")
		//form.upasswd1.select()
		return
	}
	
	if(passwd1 !== passwd2){
		alert("비밀번호가 일치 하지 않습니다.")
		//form.upasswd2.select()
		return
	}
	
	if(!regExpAddress.test(address)){
		alert("주소는 한글로만 입력해 주세요.")
		//form.uaddress.select()
		return	
	}
		
	if(!regExpPhone.test(phone)){
		alert("연락처 입력을 확인해주세요.")
		return
	}
	
	if(!regExpEmail.test(email)){
		alert("이메일 입력을 확인해주세요.")
		return
	}
	
	if(!regExpBirth.test(birthdate)){
		alert("생년월일을 확인해주세요.")
		return
	}
	
	if(allergy.value == 0){
		alert("알러지 항목을 확인해주세요. 알러지가 없다면 확인만 눌러주세요.")
		return
	}
	
	alert("환영합니다.")
	
	window.location.href = "login.do"
}
	
function checkPassword(){
	var password1 = document.getElementById("password1").value
	var password2 = document.getElementById("password2").value
	
	if(password1 === password2){
		document.getElementById("passwordStatus").value = "비밀번호 일치";
		document.getElementById("passwordStatus").style.color = "BLUE";
	} else{
		document.getElementById("passwordStatus").style.color = "RED";
		document.getElementById("passwordStatus").value = "비밀번호 불일치";
	}
}

function checkWho(){
	var result = document.loginfn.result.value
	
	if(result === ""){
		alert("아이디 혹은 비밀번호가 틀렸습니다.")
		return
	}else if(result === "admin"){
		alert("안녕하세요, 관리자님")
		return
	}else if(result === "user"){
		alert("환영합니다." + document.loginfn.loginuid.value + "님")
		return
	}
}

function doKakaoLogin() {
	const url = 'https://kauth.kakao.com/oauth/authorize?client_id=' +
		process.env.VUE_APP_KAKAO_JS_KEY +
		'&redirect_uri=' +
		process.env.VUE_APP_KAKAO_REDIRECT_URL +
		'&response_type=code&' +
		'scope=account_email birthday gender profile_nickname profile_image'
}

function setIdpw(){
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input');
	objs.setAttribute('type', 'text');
	
	var uid = document.getElementById("exampleInputEmail");
	var upw = document.getElementById("exampleInputPassword");
	
	objs.setAttribute('name', 'exampleInputEmail');
	objs.setAttribute('value', $('#uid').val());
	form.appendChild(objs);
	objs.setAttribute('type', 'text');
	objs.setAttribute('name', 'exampleInputPassword');
	objs.setAttribute('value', $('#upw').val());
	form.appendChild(objs);
	form.setAttribute('method', 'post');
	form.setAttribute('action', 'loginCheck.do')
	document.body.appendChild(form)
	form.submit();
	
	window.location.href = "loginCheck.do?userid="+ uid.value + "&userpw=" + upw.value;
}

function checkUser(getResult, getId){
	
	const user = 'user'
	const admin = 'admin'

	if(getResult === user){
		alert('환영합니다. ' + getId)
		window.location.href = "main.do"
	} else if(getResult === admin){
		alert('안녕하세요, 관리자님')
		window.location.href = "admin_main.do"
	} else{
		alert('아이디 혹은 비밀번호가 틀렸습니다. 다시 시도해 주세요.')
		return;
	}
}

function checkid(){
	
	
}

function setStatusVar(varStat){
	
	if(varStat === "allergyCheck"){
		document.getElementById("allergyCheck").value = 1;
	}else{
		document.getElementById("allergyCheck").value = '0';
	}
	if(varStat === "idCheck"){
		document.getElementById("idCheck").value = 1;
	}else{
		document.getElementById("idCheck").value = '0';
	}
}

function checkDuplicate() {
	var id = $("#inputID").val();
	const btn1 = document.getElementById("modalCheck");
	btn1.style.display = 'none';
	document.getElementById("inputID").value = "";
	
	if(id == ""){
		alert("ID를 입력해주세요.")
		return;
	}else{
		$.ajax({
		    type: "POST",
		    url: "duplicateid.jsp", // URL
		    data: { id : id },
		    success: function(result) {
				console.log(result)
				if (result === 0) {
					alert("사용 가능한 아이디 입니다.");
					document.getElementById("userid").value = id;
					document.getElementById("uid").value = id;
					btn1.style.display = 'block';
				} else if(result === 1){
					alert("이미 존재하는 아이디 입니다.");
					btn1.style.display = 'none';
				} else{
					alert("사용 불가능한 아이디 입니다.");
					btn1.style.display = 'none';
				}
			},
			error: function(xhr, status, error) {
			    console.log("에러 발생: " + error); // 오류 메시지 출력
			}
		});
	}
}

function isCheckDone(){
	
	
}