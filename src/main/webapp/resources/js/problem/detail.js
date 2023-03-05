const goodCntAdd = document.getElementById('goodCntAdd');
const badCntAdd = document.getElementById('badCntAdd');
const problemListId = goodCntAdd.getAttribute('data-problemListId');
const goodCnt = document.getElementById('goodCnt');
const badCnt = document.getElementById('badCnt');

goodCntAdd.addEventListener('click',()=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST","/problem/goodCntAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("problemListId="+problemListId);
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            goodCnt.innerHTML = xhttp.responseText.trim();
        }
    }
})
badCntAdd.addEventListener('click',()=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST","/problem/badCntAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("problemListId="+problemListId);
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            badCnt.innerHTML = xhttp.responseText.trim();
        }
    }
})

const content = document.getElementById('content');
const commentBtn = document.getElementById('commentBtn');
const commentList = document.getElementById('commentList');

let getCommentList = (curPageNum)=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET','/comment/list?problemListId=' + problemListId + '&curPageNum=' + curPageNum);
    xhttp.send()
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
             commentList.innerHTML = xhttp.responseText;
        }
    }
}

getCommentList(1);

commentBtn.addEventListener('click',()=>{
    console.log(content.value);
    if(content.value != ''){
        commentBtn.type = "submit";
        getCommentList(1);
    }
})

commentList.addEventListener('click',(e)=>{
    let curPageNum = e.target.getAttribute('data-curPageNum');
    if(curPageNum != null){
        getCommentList(curPageNum);
    }
})




