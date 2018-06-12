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
        <td width="120">Extended Length</td>
        <td width="120">Collapsed Length</td>
        <td width="120">Upper Mount</td>
        <td width="120">Lower Mount</td>
    </tr>
    <tr>
        <td>
            <form:form action="${processInput}" modelAttribute="keeper">
                <form:select path="shockMake" onchange="this.form.submit()">
                    <c:if test="${!empty keeper.shockMake}">
                        <form:option value="${keeper.shockMake}" label="${keeper.shockMake}"/>
                    </c:if>
                    <form:options items="${keeper.shockMakes}"/>
                </form:select>
                <form:input type="hidden" path="coLength" value ="${keeper.coLength}"/>
                <form:input type="hidden" path="extLength" value ="${keeper.extLength}"/>
                <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
                <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
            </form:form>
        </td>
        <td>
            <form:form action="${processInput}" modelAttribute="keeper">
                <form:select path="coLength" onchange="this.form.submit()">
                    <c:if test="${!empty keeper.coLength}">
                        <form:option value="${keeper.coLength}" label="${keeper.coLength}"/>
                    </c:if>
                    <form:options items="${keeper.coLengths}"/>
                </form:select>
                <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                <form:input type="hidden" path="extLength" value ="${keeper.extLength}"/>
                <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
                <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
            </form:form>
        </td>
        <td>
            <form:form action="${processInput}" modelAttribute="keeper">
                <form:select path="extLength" onchange="this.form.submit()">
                    <c:if test="${!empty keeper.extLength}">
                        <form:option value="${keeper.extLength}" label="${keeper.extLength}"/>
                    </c:if>
                    <form:options items="${keeper.extLengths}"/>
                </form:select>
                <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                <form:input type="hidden" path="coLength" value ="${keeper.coLength}"/>
                <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
                <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
            </form:form>
        </td>
        <td>
            <form:form action="${processInput}" modelAttribute="keeper">
                <form:select path="upMount" onchange="this.form.submit()">
                    <c:if test="${!empty keeper.upMount}">
                        <form:option value="${keeper.upMount}" label="${keeper.upMount}"/>
                    </c:if>
                    <form:options items="${keeper.upMounts}"/>
                </form:select>
                <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                <form:input type="hidden" path="coLength" value ="${keeper.coLength}"/>
                <form:input type="hidden" path="extLength" value ="${keeper.extLength}"/>
                <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
            </form:form>
        </td>
        <td>
            <form:form action="${processInput}" modelAttribute="keeper">
                <form:select path="lowMount" onchange="this.form.submit()">
                    <c:if test="${!empty keeper.lowMount}">
                        <form:option value="${keeper.lowMount}" label="${keeper.lowMount}"/>
                    </c:if>
                    <form:options items="${keeper.lowMounts}"/>
                </form:select>
                <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                <form:input type="hidden" path="coLength" value ="${keeper.coLength}"/>
                <form:input type="hidden" path="extLength" value ="${keeper.extLength}"/>
                <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
            </form:form>
        </td>
    </tr>
    <c:if test="${keeper.readyForFilter}">
        <tr>
          <td>
              <form:form action="${showResults}" modelAttribute="keeper">
                  <input type="submit" value="<spring:message text="Find Shocks"/>"/>
                  <form:input type="hidden" path="shockMake" value ="${keeper.shockMake}"/>
                  <form:input type="hidden" path="coLength" value ="${keeper.coLength}"/>
                  <form:input type="hidden" path="extLength" value ="${keeper.extLength}"/>
                  <form:input type="hidden" path="upMount" value ="${keeper.upMount}"/>
                  <form:input type="hidden" path="lowMount" value ="${keeper.lowMount}"/>
              </form:form>
          </td>
        </tr>
    </c:if>
</table>

</body>
</html>