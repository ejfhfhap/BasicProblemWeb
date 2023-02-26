const inputId = document.getElementById('inputId');
const idMsg = document.getElementById('idMsg');

const inputPassword1 = document.getElementById('inputPassword1');
const inputPassword2 = document.getElementById('inputPassword2');
const PasswordMsg1 = document.getElementById('PasswordMsg1');
const PasswordMsg2 = document.getElementById('PasswordMsg2');

const submitBtn = document.getElementById('submitBtn');
const submitForm = document.getElementById('submitForm');

let checks = [0,0,0];

inputId.addEventListener('blur',()=>{
    let id = inputId.value;
    if(id != ''){
        idMsg.innerHTML = "좋은 아이디 입니다";
        checks[0] = 1;
    }else{
        idMsg.innerHTML = "아이디를 입력 해 주세요";
        checks[0] = 0;
    }
})

inputPassword1.addEventListener('blur',()=>{
    let len = inputPassword1.value.length;
    if(8<= len && len<=20){
        PasswordMsg1.innerHTML = '올바른 비밀번호 입니다'
        checks[1] = 1;
    }else{
        PasswordMsg1.innerHTML = '8 ~ 20글자 사이의 비밀번호를 입력 해 주세요';
        checks[1] = 0;
    }
})
inputPassword1.addEventListener('change',()=>{
    inputPassword2.focus();
    inputPassword2.blur();
})

inputPassword2.addEventListener('blur',()=>{
    if(inputPassword1.value == inputPassword2.value){
        PasswordMsg2.innerHTML = '비밀번호가 일치합니다';
        checks[2] = 1;
    }else{
        PasswordMsg2.innerHTML = '위 비밀번호와 다릅니다';
        checks[2] = 0;
    }
})

submitBtn.addEventListener('click',()=>{
    console.log(checks.includes(0))
    if(checks.includes(0) == false){
        submitForm.submit();
    }
})