<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<jsp:include page="../common/head.jsp" />
    </head>
    <body class="bg-primary">
    <%@ include file="../common/nav.jsp" %>
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">My Account</h3>
                                    </div>
                                    <div class="card-body">
                                        <form method="post">
                                            <div class="form-floating input-group mb-3">
                                                <input class="form-control" id="id" type="text" name="id" placeholder="enter" value="${memberInfo.id}" readonly/>
                                                <label for="id">ID</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPassword" name="pw" type="password" placeholder="Create a password" />
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPasswordConfirm" name="pw2" type="password" placeholder="Confirm password" />
                                                        <label for="inputPasswordConfirm">Confirm Password</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="name" name="name" type="text" placeholder="enter name" value="${memberInfo.name}"/>
                                                <label for="name">name</label>
                                            </div>
                                            <div class="form-floating mb-3 input-group">
                                                <input class="form-control" id="email" name="email" type="text" placeholder="enter name" value="${memberInfo.email}" readonly />
                                                <label for="email">email</label>
                                                <c:if test="${memberInfo.auth == 0}">
                                                <button class="btn btn-danger" type="button" id="btnEmail">????????? ??????</button>
                                                </c:if>
                                                <c:if test="${memberInfo.auth == 1}">
                                                <button class="btn btn-success" type="button" disabled>????????? ?????????</button>
                                                </c:if>
                                                <input type="hidden" value="1" id="chkEmail">
                                            </div>
                                            <hr>
                                            <button type="button" id="btnSearchAddr" class="mb-3 btn btn-sm btn-secondary">????????????</button>
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-8">
                                                    <div class="mb-3 mb-md-0">
                                                        <input class="form-control" id="roadAddr" name="roadAddr" readonly value="${memberInfo.roadAddr}"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="mb-3 mb-md-0">
                                                        <input class="form-control" id="addrDetail" name="addrDetail" value="${memberInfo.addrDetail}"/>
                                                    </div>
                                                </div>
												<input type="hidden" name="si" id="si" value="${memberInfo.si}">
												<input type="hidden" name="sgg" id="sgg" value="${memberInfo.sgg}">
												<input type="hidden" name="emd" id="emd" value="${memberInfo.emd}">
												<input type="hidden" name="zipNo" id="zipNo" value="${memberInfo.zipNo}">
												<input type="hidden" name="roadFullAddr" id="roadFullAddr" value="${memberInfo.roadFullAddr}">
												<input type="hidden" name="jibunAddr" id="jibunAddr" value="${memberInfo.jibunAddr}">

                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-warning btn-block" >Modify Account</button></div>
                                                <div class="d-grid mt-4"><button class="btn btn-danger btn-block" formaction="secession">Remove Account</button></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
            	<jsp:include page="../common/footer.jsp"/>
            </div>
        </div>
        <script>
        $(function() {
        	var cp = '${pageContext.request.contextPath}';
        	$("#btnSearchAddr").click(function() {
        		var pop = window.open("${pageContext.request.contextPath}/juso","pop","width=570,height=420, scrollbars=yes, resizable=yes");
        	});
        	
        	$("#btnEmail").click(function() {
        		var $btnEmail = $(this);
        		var str = '<img src="https://i.stack.imgur.com/qq8AE.gif" width="20">';
        		console.log("clicked!");
        		var data =  {email : $("#email").val(), id : $("#id").val()}
        		$.ajax(cp + "/member/memberAuth", {
        			data : data,
        			method : "get",
        			beforeSend : function() {
        				$btnEmail.prop("disabled", true).html(str+" ?????????");
        			},
        			success : function(data) {
        				$btnEmail.prop("disabled", false).html("????????? ??????");
        				console.log(data);
        			}
        		}) 
        	});
        	
        	$("form").submit(function() {
        	})
        })
        function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
            $("#si").val(siNm);
            $("#sgg").val(sggNm);
            $("#emd").val(emdNm);
            $("#roadAddr").val(roadAddrPart1);
            $("#addrDetail").val(addrDetail);
            $("#zipNo").val(zipNo);
            $("#roadFullAddr").val(roadFullAddr);
            $("#jibunAddr").val(jibunAddr);
		}
        </script>
    </body>
</html>