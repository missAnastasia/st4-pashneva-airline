<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title" value="Requests" />
<%@ include file="/WEB-INF/jspf/head_main.jspf" %>

<body>
    <div id="wrapper">
        <jsp:include page="../_header.jsp"/>
        <div id="page" class="container">
            <div class="title">
                <h2><fmt:message key="requests_dispatcher_jsp.h2"/></h2>
            </div>
            <div id="content-div">
                <div id="options-div">
                    <div id="search-div">
                        <form action="${pageContext.request.contextPath}/redirect?command=getDispatcherAddRequestPageCommand" autocomplete="on" method="post">
                            <input type="submit" class="full-width-button" value="<fmt:message key="requests_dispatcher_jsp.add_request"/>"/>
                        </form>
                    </div>
                </div>
                <div id="content-table-div">
                    <div id="items-div">
                        <c:forEach items="${requests}" var="request_item">
                            <form action="${pageContext.request.contextPath}/redirect?command=getDispatcherRequestInfoPageCommand" method="post" id="request-form">
                                <div class="item-div">
                                    <table class="item-table">
                                        <tr>
                                            <td colspan="2">
                                                <h3><button class="entity_info-link" type="submit" name="request_id" value="${request_item.getId()}" form="request-form">${request_item.getNumber()}</button></h3>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="item-left-td"><h3><fmt:message key="requests_dispatcher_jsp.request_status"/></h3></td>
                                            <td class="item-right-td">
                                                ${request_item.getRequestStatus().getName()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="item-left-td"><h3><fmt:message key="requests_dispatcher_jsp.message"/></h3></td>
                                            <td class="item-right-td">
                                                ${request_item.getMessage()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="item-left-td"><h3><fmt:message key="requests_dispatcher_jsp.date"/></h3></td>
                                            <td class="item-right-td">
                                                ${request_item.getDate()}
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </form>
                        </c:forEach>
                        <div>
                            <h3>${message}</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../_footer.jsp"/>
    </div>
</body>
</html>
