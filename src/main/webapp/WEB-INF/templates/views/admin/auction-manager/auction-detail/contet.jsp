<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>


<diWv class="col-md-9 col-md">
    <div class="block-title">
        <h1>My Bidding</h1>

<table class="table ">
    <thead>
    <tr>
        <th>UserName</th>
        <th>BiddDate</th>
        <th>biddPrice</th>

    </tr>
    </thead>
    <tbody>
    <style>
									#hoverAuction  a:hover{
									color:#f0ad4e;
									font-weight:normal;
									}</style>
    <c:forEach var="entry" items="${historyBidds}" varStatus="status">

        <tr>


            <td>${entry.value.userName}</td>
            <td>${entry.key.biddDate} </td>
            <td>${entry.key.biddPrice}</td>

        </tr>

    </c:forEach>

    </tbody>

</table>

    </div>
</diWv>