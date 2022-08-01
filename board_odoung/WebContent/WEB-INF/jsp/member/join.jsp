<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<jsp:include page="../common/head.jsp" />
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form method="post">
                                            <div class="form-floating input-group mb-3">
                                                <input class="form-control" id="id" type="text" name="id" placeholder="enter "/>
                                                <label for="id">ID</label>
                                                <button class="btn btn-success" type="button" id="btnId">ID중복 체크</button>
                                                <input type="hidden" value="1" id="chkId">
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
                                                <input class="form-control" id="name" name="name" type="text" placeholder="enter name" />
                                                <label for="name">name</label>
                                            </div>
                                            <div class="form-floating mb-3 input-group">
                                                <input class="form-control" id="email" name="email" type="text" placeholder="enter name" />
                                                <label for="email">email</label>
                                                <button class="btn btn-success" type="button" id="btnEmail">Email중복 체크</button>
                                                <input type="hidden" value="1" id="chkEmail"> 
                                            </div>
                                            <hr>
                                            <button type="button" id="btnSearchAddr" class="mb-3 btn btn-sm btn-secondary">주소검색</button>
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-8">
                                                    <div class="mb-3 mb-md-0">
                                                        <input class="form-control" id="roadAddr" name="roadAddr" readonly/>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="mb-3 mb-md-0">
                                                        <input class="form-control" id="addrDetail" name="addrDetail" readonly />
                                                    </div>
                                                </div>
												<input type="hidden" name="si" id="si">
												<input type="hidden" name="sgg" id="sgg">
												<input type="hidden" name="emd" id="emd">
												<input type="hidden" name="zipNo" id="zipNo">
												<input type="hidden" name="roadFullAddr" id="roadFullAddr">
												<input type="hidden" name="jibunAddr" id="jibunAddr">

                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" >Create Account</button></div>
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
        	
        	$("#btnId").click(function() {
        		console.log("clicked!");
        		var id =  {id : $("#id").val()}
        		$.ajax(cp + "/member/findMember", {
        			data : id,
        			method : "get",
        			success : function(data) {
        				console.log(data);
        				$("#chkId").val(data);
        			}
        		})
        	});
        	
        	$("#id").change(function() {
        		$("#chkId").val(1);
        	});
        	
        	$("#btnEmail").click(function() {
        		console.log("clicked!");
        		var email =  {email : $("#email").val()}
        		$.ajax(cp + "/member/findMember", {
        			data : email,
        			method : "get",
        			success : function(data) {
        				console.log(data);
        				$("#chkEmail").val(data);
        			}
        		})
        	});
        	
        	$("#Email").change(function() {
        		$("#chkEmail").val(1);
        	});
        	
        	$("form").submit(function() {
        		if($("#chkId").val()!=1) {
        			alert("id 중복 체크 하십셔");
        			return false;
        		}
        		if($("#chkEmail").val()!=1) {
        			alert("email 중복 체크 하십셔");
        			return false;
        		}
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