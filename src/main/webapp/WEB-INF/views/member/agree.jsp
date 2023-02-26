<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_header.jsp"/>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                basic 서비스 이용약관 동의
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                <h5>제 1조 (목 적)</h5>
                이 서비스 이용약관(이하 “약관”이라 합니다)은 이주형㈜(이하 “회사”라 합니다)가 제공하는 서비스와 관련하여 회사와 이용 고객(또는 회원) 간에 서비스의 이용 조건 및 절차, 회사와 회원 간의 권리, 의무 및 책임 사항 기타 필요한 사항을 규정함을 목적으로 합니다.
                <br>
                <h5>제 2 조 (용어의 정의)</h5>
                이 약관에서 사용하는 용어의 정의는 다음 각호와 같으며, 정의되지 않은 용어에 대한 해석은 관계법령 및 서비스별 안내에서 정하는 바에 따릅니다.
                <br>
                1)서비스 : 이용 고객 또는 회원이 PC, TV, 휴대형 단말기 등 각종 유무선 기기 또는 프로그램을 통하여 이용할 수 있도록 회사가 제공하는 모든 인터넷 서비스를 말하며, 회사가 공개한 ApI를 이용하여 제3자가 개발 또는 구축한 프로그램이나 서비스를 통하여 이용 고객 또는 회원에게 제공되는 경우를 포함합니다.
                <br>
                2)회원 : 이 약관에 동의하고 회사와 이용 계약을 체결하여, 회사가 제공하는 서비스를 사용하는 자를 말합니다.<br>
                3)이용고객 : 회사의 서비스를 이용하기 위하여 회사와 이용계약을 체결하려고 하는 자를 말합니다.<br>
                4)회원정보 : 회사가 이용고객에게 회원가입 신청양식(이하 “신청양식"이라 합니다)에 기재를 요청하는 이용고객의 개인정보를 말합니다.<br>
                5)ID(고유번호) : 회원의 식별과 회원의 서비스 이용을 위하여 사용되는 식별 정보를 말합니다.<br>
                6)비밀번호 : 회원의 회원정보 보호를 위해 회원 자신이 설정한 문자와 숫자의 조합을 말합니다.<br>
                7)사이버머니 : 회원이 회사가 제공하는 결제수단을 이용하여 충전하고 서비스내에서 현금처럼 사용하는 가상의 화폐를 말합니다.<br>
                8)포인트(또는 마일리지) : 회사가 서비스의 원활한 이용을 위하여 회원에게 부여하는 재산적 가치 및 환가성이 없는 무형의 도구를 말합니다.<br>
                9)게시물 : 회원이 회사가 제공하는 서비스에 게시 또는 등록하는 부호(URL 포함), 문자, 음성, 음향, 영상(동영상 포함),이미지(사진 포함), 파일 등을 말합니다.<br>
                </div>
            </div>
        </div>
	  
        <div class="form-check">
            <input class="form-check-input" type="checkbox">
            <label class="form-check-label" for="flexCheckDefault">
            동의 합니다
            </label>
        </div>
	
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                basic 개인정보 수집 및 이용 동의 (필수)
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse show" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                개인정보 수집 및 이용에 대해서는 거부할 수 있으며,
                거부 시에는 회원가입이 불가합니다.<br>
                서비스 제공을 위해서 반드시 필요한 최소한의 개인정보이므로 동의를 하셔야 서비스 이용이 가능합니다.<br>
                이 외 서비스 이용과정에서 별도 동의를 통해 추가정보 수집이 있을 수 있습니다.<br>
                </div>
            </div>
        </div>
          
        <div class="form-check">
            <input class="form-check-input" type="checkbox">
            <label class="form-check-label" for="flexCheckDefault">
            동의 합니다
            </label>
        </div>

	  <div class="accordion-item">
	    <h2 class="accordion-header" id="headingThree">
	      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	        basic 광고성 정보 수신 (선택) 광고성 정보 수신동의 약관
	      </button>
	    </h2>
	    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
                * basic 에서 제공하는 이벤트 등 다양한 정보를 휴대전화
                (문자), 이메일로 받아보실 수 있습니다.<br>
                * 중요 공지 및 알림 등은 설정에 관계없이 발송됩니다.<br>
                * 수신동의 여부 및 자세한 설정은 내정보 > 광고성 정보
                수신 설정하기에서 언제든지 변경할 수 있으며, 수신동의를
                철회할 경우, 광고성 정보를 발송하지 않습니다.<br>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="form-check">
	  <input class="form-check-input" type="checkbox">
	  <label class="form-check-label">
	    동의합니다
	  </label>
	</div>
	
    <div class="form-check">
        <input class="" type="checkbox" id = "allAgree">
        <label class="form-check-label">
          전체 동의
        </label>
    </div>

    <a href="/" class="btn btn-primary">이전으로</a>
    <button type="button" id="submit" class="btn btn-primary">다음으로</button>
    <script src="../resources/js/member/agree.js"></script>
	<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>