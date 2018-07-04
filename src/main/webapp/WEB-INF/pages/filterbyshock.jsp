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
<c:url var="processInput" value="/processinput"/>
<c:url var="showResults" value="/showresultsbyshock"/>
<h1>Choose your destiny</h1>
<table class="tg">
    <tr>
        <td width="120">Shock Make</td>
        <td width="120">Collapsed Length</td>
        <td width="120">Extended Length</td>
        <td width="120">Upper Mount</td>
        <td width="120">Lower Mount</td>
    </tr>
    <tr>
        <form:form id="selectForm" action="${processInput}" modelAttribute="keeper">
             <td>
                 <form:select path="shockMake" onchange="selectForm.submit()">
                     <c:if test="${!empty keeper.shockMake}">
                         <form:option value="${keeper.shockMake}" label="${keeper.shockMake}"/>
                     </c:if>
                     <form:options items="${keeper.shockMakes}"/>
                 </form:select>
             </td>
            <td>
                From:
                <form:input path="coLengthFrom" type="number" step = "0.1" value="${keeper.coLengthFrom}" onchange="submit()"/>
                <br>
                To:
                <form:input path="coLengthTo" type="number" step = "0.1" value="${keeper.coLengthTo}" onchange="submit()"/>
            </td>
            <td>
                From:
                <form:input path="extLengthFrom" type="number" step = "0.1" value="${keeper.extLengthFrom}" onchange="submit()"/>
                <br>
                To:
                <form:input path="extLengthTo" type="number" step = "0.1" value="${keeper.extLengthTo}" onchange="submit()"/>
            </td>
            <td>
                <form:select path="upMount" onchange="selectForm.submit()">
                    <c:if test="${!empty keeper.upMount}">
                        <form:option value="${keeper.upMount}" label="${keeper.upMount}"/>
                    </c:if>
                    <form:options items="${keeper.upMounts}"/>
                </form:select>
            </td>
            <td>
                <form:select path="lowMount" onchange="selectForm.submit()">
                    <c:if test="${!empty keeper.lowMount}">
                        <form:option value="${keeper.lowMount}" label="${keeper.lowMount}"/>
                    </c:if>
                    <form:options items="${keeper.lowMounts}"/>
                </form:select>
            </td>
        </form:form>
    </tr>
    <c:if test="${keeper.readyForFilter}">
        <tr>
            <td>
                <form:form action="${showResults}" modelAttribute="keeper">
                    <input type="submit" value="<spring:message text="Find Shocks"/>"/>
                    <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                    <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
                    <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
                    <form:input type="hidden" path="coLengthFrom" value ="${keeper.coLengthFrom}"/>
                    <form:input type="hidden" path="coLengthTo" value ="${keeper.coLengthTo}"/>
                    <form:input type="hidden" path="extLengthFrom" value ="${keeper.extLengthFrom}"/>
                    <form:input type="hidden" path="extLengthTo" value ="${keeper.extLengthTo}"/>
                </form:form>
            </td>
        </tr>
    </c:if>
</table>

</body>
</html>