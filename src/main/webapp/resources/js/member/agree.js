const formcheckInput = document.getElementsByClassName('form-check-input');
const allAgree = document.getElementById('allAgree');
const submit = document.getElementById('submit');

allAgree.addEventListener('click',()=>{
    console.log(allAgree)
    console.log(allAgree.checked)

    for(let agreeInput of formcheckInput){
        agreeInput.checked = allAgree.checked;
    }
})

for(let agreeInput of formcheckInput){
    agreeInput.addEventListener('click',()=>{
        let checkCnt = 0;
        for(let agreeInput of formcheckInput){
            if(agreeInput.checked == true){
                checkCnt++;
            }
        }

        if(checkCnt == formcheckInput.length){
            allAgree.checked = true;
        }else{
            allAgree.checked = false;
        }
    })
}

submit.addEventListener('click',()=>{
    if(allAgree.checked == true){
        location.href = "./insert";
    }
})
