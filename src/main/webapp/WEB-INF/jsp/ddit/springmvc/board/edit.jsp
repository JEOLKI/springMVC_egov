<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <c:set var="registerFlag" value="${empty boardVO.boardSn ? 'create' : 'modify'}"/>
    <title>게시글 <c:if test="${registerFlag == 'create'}">등록</c:if>
                  <c:if test="${registerFlag == 'modify'}">수정</c:if>
    </title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    
    <!--For Commons Validator Client Side-->
    <script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script>
    <validator:javascript formName="boardVO" staticJavascript="false" xhtml="true" cdata="false"/>
    
    <script type="text/javaScript" language="javascript" defer="defer">
        <!--
        /* 글 목록 화면 function */
        function fn_egov_selectList() {
           	document.detailForm.action = "<c:url value='/board/retrievePagingList.do'/>";
           	document.detailForm.submit();
        }
        
        /* 글 삭제 function */
        function fn_egov_delete() {
        	if(confirm("삭제하시겠습니까?")){
	           	document.detailForm.action = "<c:url value='/board/delete.do'/>";
	           	document.detailForm.submit();
        	}
        }
        
        /* 글 등록 function */
        function fn_egov_save() {
                
         	frm = document.detailForm;
         	if(!validateBoardVO(frm)){
                 return;
             }else{
	           	frm.action = "<c:url value="${registerFlag == 'create' ? '/board/create.do' : '/board/update.do'}"/>";
	            frm.submit();
             }
        
        }
        
        -->
    </script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

<form:form commandName="boardVO" id="detailForm" name="detailForm">
	<form:hidden path="boardSn" />
    <div id="content_pop">
    	<!-- 타이틀 -->
    	<div id="title">
    		<ul>
    			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>
                    <c:if test="${registerFlag == 'create'}">등록</c:if>
                    <c:if test="${registerFlag == 'modify'}">수정</c:if>
                </li>
    		</ul>
    	</div>
    	<!-- // 타이틀 -->
    	<div id="table">
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" style="bordercolor:#D3E2EC; bordercolordark:#FFFFFF; BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
    		<colgroup>
    			<col width="150"/>
    			<col width="?"/>
    		</colgroup>
    		<tr>
    			<td class="tbtd_caption"><label for="title">제목</label></td>
    			<td class="tbtd_content">
    				<form:input path="title" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="title" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="openYn">공개여부</label></td>
    			<td class="tbtd_content">
    				<form:select path="openYn" cssClass="use">
    					<form:option value="Y" label="공개" />
    					<form:option value="N" label="비공개" />
    				</form:select>
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="contents">내용</label></td>
    			<td class="tbtd_content">
    				<form:textarea path="contents" rows="5" cols="58" />&nbsp;<form:errors path="contents" />
                </td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="writer">작성자</label></td>
    			<td class="tbtd_content">
                    <c:if test="${registerFlag == 'modify'}">
        				<form:input path="writer" maxlength="10" cssClass="essentiality" readonly="true" />
        				&nbsp;<form:errors path="writer" /></td>
                    </c:if>
                    <c:if test="${registerFlag != 'modify'}">
        				<form:input path="writer" maxlength="10" cssClass="txt"  />
        				&nbsp;<form:errors path="writer" /></td>
                    </c:if>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="userPassword">비밀번호</label></td>
    			<td class="tbtd_content">
       				<form:input path="userPassword" maxlength="10" cssClass="txt"  />
       				&nbsp;<form:errors path="userPassword" /></td>
    		</tr>
    	</table>
      </div>
    	<div id="sysbtn">
    		<ul>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:fn_egov_selectList();">목록으로</a>
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:fn_egov_save();">
                            <c:if test="${registerFlag == 'create'}">등록</c:if>
                            <c:if test="${registerFlag == 'modify'}">수정</c:if>
                        </a>
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<c:if test="${registerFlag == 'modify'}">
                    <li>
                        <span class="btn_blue_l">
                            <a href="javascript:fn_egov_delete();">삭제</a>
                            <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                        </span>
                    </li>
    			</c:if>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a>
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
            </ul>
    	</div>
    </div>
    <!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${boardVO.searchCondition}'/>"/>
    <input type="hidden" name="searchKeyword" value="<c:out value='${boardVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${boardVO.pageIndex}'/>"/>
</form:form>
</body>
</html>