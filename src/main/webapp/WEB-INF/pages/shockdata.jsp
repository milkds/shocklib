<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Shock Absorber</title>
</head>
<body>
<c:url var="showResults" value="/showresults"/>
<table>
    <tr>
        <td>
            <table>
                <tr>
                    <td>${shock.partNo}</td>
                </tr>
                <tr>
                    <td>${shock.shockMake}, ${shock.shockSeries} series</td>
                </tr>
                <tr>
                    <td>Compressed length:</td>
                    <td>${shock.colLength}</td>
                </tr>
                <tr>
                    <td>Extended length:</td>
                    <td>${shock.extLength}</td>
                </tr>
                <tr>
                    <td>Upper mount:</td>
                    <td>${shock.upMount}</td>
                </tr>
                <tr>
                    <td>Lower mount:</td>
                    <td>${shock.lowMount}</td>
                </tr>
                <tr><td><br/></td></tr>
                <tr>
                    <td>Notes:</td>
                </tr>
                <c:if test="${!empty shock.bodyThickness}">
                    <tr>
                        <td>Body Thickness:</td>
                        <td>${shock.bodyThickness}</td>
                    </tr>
                </c:if>
                <c:if test="${!empty shock.shockNotes}">
                    <tr>
                        <td>Shock Notes:</td>
                        <td>${shock.shockNotes}</td>
                    </tr>
                </c:if>
                <c:if test="${!empty shock.shockNotes2}">
                    <tr>
                        <td>Shock Notes 2:</td>
                        <td>${shock.shockNotes2}</td>
                    </tr>
                </c:if>
            </table>
        </td>
        <td>
            <table>
                <tr>
                    <td> <img src=${shock.imgLink} width="300" height="300"></td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${shock.imgLinks}" var ="imgL">
                            <img src=${imgL} width="100" height="100"></td>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table>
    <c:forEach items="${shock.fitments}" var ="fitment">
        <form:form action="${showResults}" modelAttribute="Keeper">
        <c:set var = "car" value = "${fitment.car}"/>
        <tr>
            <td> ${car.yearStart} -  ${car.yearFinish} ${car.make} ${car.carModel} ${car.drive}</td>
        </tr>
        <tr>
        <tr>
            <td>${fitment.shockPosition} lift: ${fitment.liftStart} - ${fitment.liftFinish}"</td>
        </tr>
        <c:if test="${!empty fitment.fitmentNotes}">
            <tr>
                <td>Fitment Notes: ${fitment.fitmentNotes}</td>
            </tr>
        </c:if>
        <c:if test="${!empty fitment.extraNotes}">
            <tr>
                <td>Extra Notes: ${fitment.extraNotes}</td>
            </tr>
        </c:if>
            <form:input type="hidden" path="year" value ="${car.yearStart}"/>
            <form:input type="hidden" path="carMake" value ="${car.make}"/>
            <form:input type="hidden" path="carModel" value ="${car.carModel}"/>
            <form:input type="hidden" path="carDrive" value ="${car.drive}"/>
            <tr>
                <td>
                    <input type="submit" value="<spring:message text="More for this car"/>"/>
                </td>
            </tr>
            <tr><td><br/></td></tr>
        </form:form>
    </c:forEach>
</table>


</body>
</html>
