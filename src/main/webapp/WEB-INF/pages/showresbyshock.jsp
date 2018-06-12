<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Search Results:</title>
</head>
<body>
    <c:forEach items="${Shocks}" var ="shock">
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
                    </table>
                </td>
                <td> <img src=${shock.imgLink} width="400" height="400"></td>
            </tr>
        </table>
    </c:forEach>
</body>
</html>
