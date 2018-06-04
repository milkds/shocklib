<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Filter</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<c:url var="filterByYear" value="/filterbyyear"/>
<c:url var="filterByMake" value="/filterbymake"/>
<c:url var="filterByModel" value="/filterbymodel"/>
<c:url var="filterByDrive" value="/filterbydrive"/>
<h1>Choose your destiny</h1>
<table class="tg">

    <%-- choose year:--%>
    <tr>
        <td width="120">
            <form:form action="${filterByYear}" modelAttribute="filterKeeper">
                <form:select path="year" onchange="this.form.submit()">
                    <c:if test="${empty filterKeeper.year}">
                        <form:option value="" label="--- Select ---"/>
                    </c:if>
                    <c:if test="${!empty filterKeeper.year}">
                        <form:option value="${filterKeeper.year}" label="${filterKeeper.year}"/>
                    </c:if>
                    <form:options items="${filterKeeper.years}"/>
                </form:select>
            </form:form>
        </td>
   <%-- choose car make:--%>
        <c:if test="${!empty filterKeeper.year}">
            <td width="120">
                <form:form action="${filterByMake}" modelAttribute="filterKeeper">
                    <form:select path="carMake" onchange="this.form.submit()">
                        <c:if test="${empty filterKeeper.carMake}">
                            <form:option value="" label="--- Select ---"/>
                        </c:if>
                        <c:if test="${!empty filterKeeper.carMake}">
                            <form:option value="${filterKeeper.carMake}" label="${filterKeeper.carMake}"/>
                        </c:if>
                        <form:options items="${filterKeeper.carMakes}"/>
                    </form:select>
                    <form:input type="hidden" path="year" value ="${filterKeeper.year}"/>
                </form:form>
            </td>
            <%-- choose car model:--%>
            <c:if test="${!empty filterKeeper.carMake}">
                <td width="120">
                    <form:form action="${filterByModel}" modelAttribute="filterKeeper">
                        <form:select path="carModel" onchange="this.form.submit()">
                            <c:if test="${empty filterKeeper.carModel}">
                                <form:option value="" label="--- Select ---"/>
                            </c:if>
                            <c:if test="${!empty filterKeeper.carModel}">
                                <form:option value="${filterKeeper.carModel}" label="${filterKeeper.carModel}"/>
                            </c:if>
                            <form:options items="${filterKeeper.carModels}"/>
                        </form:select>
                        <form:input type="hidden" path="carMake" value ="${filterKeeper.carMake}"/>
                        <form:input type="hidden" path="year" value ="${filterKeeper.year}"/>
                    </form:form>
                </td>
                <%-- choose car drive:--%>
                <c:if test="${!empty filterKeeper.carModel}">
                    <td width="120">
                        <form:form action="${filterByDrive}" modelAttribute="filterKeeper">
                            <form:select path="carDrive" onchange="this.form.submit()">
                                <c:if test="${empty filterKeeper.carDrive}">
                                    <form:option value="" label="--- Select ---"/>
                                </c:if>
                                <c:if test="${!empty filterKeeper.carDrive}">
                                    <form:option value="${filterKeeper.carDrive}" label="${filterKeeper.carDrive}"/>
                                </c:if>
                                <form:options items="${filterKeeper.carDrives}"/>
                            </form:select>
                            <form:input type="hidden" path="carModel" value ="${filterKeeper.carModel}"/>
                            <form:input type="hidden" path="carMake" value ="${filterKeeper.carMake}"/>
                            <form:input type="hidden" path="year" value ="${filterKeeper.year}"/>
                        </form:form>
                    </td>
                </c:if>
            </c:if>
        </c:if>






    </tr>
       <%-- choose car model:--%>
       <%--<tr>
           <form:form action="${filterAction}" commandName="filterKeeper">
               <td width="120">
                   <form:select path="carModel" onchange="this.form.submit()">
                       <c:if test="${empty filterKeeper.carMake}">
                           <form:option value="" label="--- Select ---"/>
                       </c:if>
                       <c:if test="${!empty filterKeeper.carMake}">
                           <form:option value="${filterKeeper.carMake}" label="${filterKeeper.carMake}"/>
                       </c:if>
                       <form:options items="${filterKeeper.carMakes}"/>
                   </form:select>
               </td>
           </form:form>
       </tr>--%>
</table>
<%--<c:url var="whutAction" value="/whut"/>
<form:form action="${whutAction}" commandName="TestBean">
    <table>
        <tr>
            <td>
                <form:label path="carMake">
                    <spring:message text="Enter Test Info Here:"/>
                </form:label>
            </td>
            <td>
                <form:input path="carMake"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="<spring:message text="Whuuuuut?"/>"/>
</form:form>--%>


</body>
</html>