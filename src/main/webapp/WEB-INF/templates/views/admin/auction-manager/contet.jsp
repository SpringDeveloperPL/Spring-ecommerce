<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<diWv class="col-md-9 col-md">
    <div class="block-title">
        <h1>Auctions Manage</h1>


        <table class="table table-hover">
            <thead>
            <tr>
                <th>Image</th>
                <th>Product Name</th>
                <th>Bidders</th>
                <th>Link</th>
            </tr>
            </thead>
            <tbody>
            <style>
									#hoverAuction  a:hover{
									color:#f0ad4e;
									font-weight:normal;
									}</style>
            <c:forEach var="auction" items="${auctions}">
                <tr>


                    <td>
                        <img src="/resources/productImages/${auction.imageName}" alt="image" width="100" height="100"> </td>
                    <td>${auction.name}</td>
                    <td>${auction.price} people</td>
                    <th id="hoverAuction"><a href="<spring:url value="auction-manager/auction/${auction.productId}"/>">Detail Link</a></th>


                </tr>
            </c:forEach>

            </tbody>

        </table>


    </div>
</diWv>