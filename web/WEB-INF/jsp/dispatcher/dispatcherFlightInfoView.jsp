<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title" value="Flight Info" />
<%@ include file="/WEB-INF/jspf/head_main.jspf" %>

<body>
<jsp:include page="../_header.jsp"/>
<cstmtf:menu_user_role/>
</div>
<div id="page" class="container">
    <div class="title">
        <h2><fmt:message key="flights_dispatcher_jsp.h2"/></h2>
    </div>
    <div class="main-content-div" id="info-div">
        <div id="properties-div">
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.number"/>
                </label>
                <label class="label-v">${flight.getNumber()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.from"/>
                </label>
                <label class="label-v">${flight.getDeparturePoint()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.to"/>
                </label>
                <label class="label-v">${flight.getArrivalPoint()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.date"/>
                </label>
                <label class="label-v">${flight.getDate()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.time"/>
                </label>
                <label class="label-v">${flight.getTime()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.aircraft"/>
                </label>
                <label class="label-v">${flight.getAircraft().getTypeName()}</label>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.brigade"/>
                </label>
                <label class="label-v">
                    <c:choose>
                        <c:when test="${flight.getBrigade() != null}">
                            ${flight.getBrigade().getNumber()}
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="flight_info_dispatcher_jsp.null_brigade"/>
                        </c:otherwise>
                    </c:choose>
                </label>
                <form action="${pageContext.request.contextPath}/redirect?command=getDispatcherChangeFlightBrigadePageCommand" method="post">
                <input type="hidden" name="flight_id" value="${flight.getId()}">
                <input type="submit" class="auto-width-button" value="<fmt:message key="flight_info_dispatcher_jsp.submit"/>">
                </form>
            </div>
            <div class="one-property-div">
                <label class="label-n">
                    <fmt:message key="flight_info_dispatcher_jsp.label.flight_status"/>
                </label>
                <label class="label-v">${flight.getFlightStatus().getName()}</label>
                <form action="${pageContext.request.contextPath}/redirect?command=getDispatcherChangeFlightStatusPageCommand" method="post">
                <input type="hidden" name="flight_id" value="${flight.getId()}">
                <input type="submit" class="auto-width-button" value="<fmt:message key="flight_info_dispatcher_jsp.submit"/>">
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../_footer.jsp"/>
</body>
</html>

