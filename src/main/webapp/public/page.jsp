<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--翻页-->
<c:choose>
    <c:when test="${pageInfo.pages > 1}">
        <ul class="pagination">
            <%
                String url = request.getParameter("url");
            %>
            <c:choose>
                <c:when test="${pageInfo.isFirstPage}">
                    <li class="active"><a href="<%=url%>?pageNum=1">首页</a></li>
                </c:when>
                <c:otherwise>
                    <li ><a href="<%=url%>?pageNum=1">首页</a></li>
                    <li><a href="<%=url%>?pageNum=${pageInfo.pageNum-1}">上一页</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${pageInfo.isLastPage}">
                    <li class="active"><a href="<%=url%>?pageNum=${pageInfo.pages}">尾页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<%=url%>?pageNum=${pageInfo.pageNum+1}">下一页</a></li>
                    <li ><a href="<%=url%>?pageNum=${pageInfo.pages}">尾页</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </c:when>
</c:choose>
<p>共${pageInfo.pages}页 , 共${pageInfo.total}条记录 ,当前第${pageInfo.pageNum}页</p>
