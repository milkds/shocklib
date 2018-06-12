<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Search Results:</title>
</head>
<style type="text/css">
    .linkButton {
        background: none;
        border: none;
        color: #0066ff;
        text-decoration: underline;
        cursor: pointer;
    }
</style>
<body>
<c:url var="shockData" value="/shockdata"/>
<c:forEach items="${Cars}" var ="car">
    ${car.yearStart} -  ${car.yearFinish} ${car.make} ${car.carModel} ${car.drive}
    <c:forEach items="${car.fitments}" var ="fitment">
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td></td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <form:form action="${shockData}" modelAttribute="partno">
                                <form:input path="partNo" type="submit" class="linkButton" value ="${fitment.partNo}"/>
                            </form:form>
                        </tr>
                        <tr>
                            <td>${fitment.absorber.shockMake}, ${fitment.absorber.shockSeries} series</td>
                        </tr>
                        <tr>
                            <td>${fitment.shockPosition} lift: ${fitment.liftStart} - ${fitment.liftFinish}"</td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td>Compressed length:</td>
                            <td>${fitment.absorber.colLength}</td>
                        </tr>
                        <tr>
                            <td>Extended length:</td>
                            <td>${fitment.absorber.extLength}</td>
                        </tr>
                        <tr>
                            <td>Upper mount:</td>
                            <td>${fitment.absorber.upMount}</td>
                        </tr>
                        <tr>
                            <td>Lower mount:</td>
                            <td>${fitment.absorber.lowMount}</td>
                        </tr>
                    </table>
                </td>
                <td> <img src=${fitment.absorber.imgLink} width="400" height="400"></td>
            </tr>
        </table>
    </c:forEach>
</c:forEach>
</body>
</html>
