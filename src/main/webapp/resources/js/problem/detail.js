const goodCntAdd = document.getElementById('goodCntAdd');
const badCntAdd = document.getElementById('badCntAdd');
const problemListId = goodCntAdd.getAttribute('data-problemListId');
const goodCnt = document.getElementById('goodCnt');
const badCnt = document.getElementById('badCnt');
const datas = document.getElementById('datas');
const updateBtn = document.getElementById('updateBtn')
const closeBtn = document.getElementById('closeBtn');
const updatedContent = document.getElementById('updatedContent');

$('#goodCntAdd').on('click',()=>{

    fetch('/problem/goodCntAdd',{
        method:'POST',
        headers: {"Content-type" : "application/x-www-form-urlencoded"},
        body: "problemListId="+problemListId
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        $('#goodCnt').html(result);
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open("POST","/problem/goodCntAdd");
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("problemListId="+problemListId);
    // xhttp.onreadystatechange = () =>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         goodCnt.innerHTML = xhttp.responseText.trim();
    //     }
    // }
})
$('#badCntAdd').on('click',()=>{
    fetch('/problem/badCntAdd',{
        method:'POST',
        headers: {"Content-type" : "application/x-www-form-urlencoded"},
        body:'problemListId=' + problemListId
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        $('#badCnt').html(result);
    })

    // badCntAdd.addEventListener('click',()=>{
    //     let xhttp = new XMLHttpRequest();
    //     xhttp.open("POST","/problem/badCntAdd");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("problemListId="+problemListId);
    //     xhttp.onreadystatechange = ()=>{
    //         if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //             badCnt.innerHTML = xhttp.responseText.trim();
    //         }
    //     }
    // })
})

const content = document.getElementById('content');
const commentBtn = document.getElementById('commentBtn');
const commentList = document.getElementById('commentList');

let getCommentList = (curPageNum)=>{
    fetch('/comment/list?problemListId=' + problemListId + '&curPageNum=' + curPageNum,{
        method:'GET'
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        $('#commentList').html(result);
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open('GET','/comment/list?problemListId=' + problemListId + '&curPageNum=' + curPageNum);
    // xhttp.send()
    // xhttp.onreadystatechange = ()=>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //          commentList.innerHTML = xhttp.responseText;
    //     }
    // }
}
let setCommentDelete = (commentId)=>{

    fetch('/comment/delete',{
        method:'POST',
        headers:{"Content-type" : "application/x-www-form-urlencoded"},
        body:"commentId="+commentId
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        alert('삭제 완료!');
    }).catch(()=>{
        alert('삭제 오류');
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open('POST','/comment/delete');
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("commentId="+commentId);

    // xhttp.onreadystatechange = () =>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         console.log("delete is ",xhttp.responseText);
    //     }
    // }

}
let setCommentUpdate = (commentId,content)=>{

    fetch('/comment/update',{
        method:'POST',
        headers: {"Content-type" : "application/x-www-form-urlencoded"},
        body:"commentId="+ commentId + "&content=" + content
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        alert('업데이트 완료!');
    }).catch(()=>{
        alert('업데이트 실패')
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open('POST','/comment/update');
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("commentId="+ commentId + "&content=" + content);

    // xhttp.onreadystatechange = () =>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         console.log("update is " + xhttp.responseText);
    //     }
    // }
}
getCommentList(1);

$('#commentBtn').on('click',()=>{
    if(content.value != ''){
        commentBtn.type = "submit";
        getCommentList(1);
    }
})
$('#commentList').on('click','.page-link',(e)=>{
    let curPageNum = $(e.target).attr('data-curPageNum');
    getCommentList(curPageNum);
})
$('#commentList').on('click','.del',(e)=>{
    let commentId = $(e.target).attr('data-commentId');
    setCommentDelete(commentId);
    getCommentList(commentId);
})
$('#commentList').on('click','.update',(e)=>{
    let commentId = $(e.target).attr('data-commentId');
    $('#datas').attr('data-commentId',commentId);
    $('#updatedContent').html($('#oriContent' + commentId).html());
})
// commentList.addEventListener('click',(e)=>{
//     let curPageNum = e.target.getAttribute('data-curPageNum');
//     if(curPageNum != null){
//         getCommentList(curPageNum);
//     }
//     if(e.target.classList.contains('del')){
//         let commentId = e.target.getAttribute('data-commentId');
//         setCommentDelete(commentId);
//         getCommentList(1);
//     }
//     if(e.target.classList.contains('update')){
//         let commentId = e.target.getAttribute('data-commentId');
//         datas.setAttribute('data-commentId',commentId);

//         let oriContent = document.getElementById('oriContent' + commentId);
//         updatedContent.innerText = oriContent.innerText;
//         console.log(updatedContent.innerText)
//         console.log(oriContent.innerText)
//     }
// })

$('#updateBtn').on('click',()=>{
    let content = $('#updatedContent').val();
    let commentId = $('#datas').attr('data-commentId');
    console.log(commentId);
    setCommentUpdate(commentId,content);
    getCommentList(1);
    $('#closeBtn').click();
})

// updateBtn.addEventListener('click',()=>{
//     let content = updatedContent.value;
//     let commentId = datas.getAttribute('data-commentId');
    
//     setCommentUpdate(commentId,content);
//     getCommentList(1);
//     closeBtn.click();
// })

