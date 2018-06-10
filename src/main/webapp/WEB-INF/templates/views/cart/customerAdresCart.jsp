<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1>Adress Datails</h1>

        <c:forEach var="entry" items="${errorList}" varStatus="status">

            <!--Alerts-->

            <div class="alert alert-${entry.key}">
                <strong>${entry.value}</strong>
            </div>

        </c:forEach>

            <form class="form-horizontal registrationForm" method="POST" action="">


                <div class="form-group ">


                    <input type="text" name="firstName" value="${adress.firstName}"
                           class="form-control" placeholder="Name" required/>


                </div>

                <div class="form-group ">

                    <input type="text" name="lastName" value="${adress.lastName}"
                           class="form-control" placeholder="Surname" required/>
                </div>



                <div class="form-group ">

                    <input type="text" name="city" value="${adress.city}"
                           class="form-control" placeholder="City" required/>

                </div>

                <div class="form-group ">

                    <input type="text" name="postalCode" value="${adress.postCode}"
                           class="form-control" placeholder="Postal Code" required/>

                </div>

                <div class="form-group ">

                    <input type="text" name="primaryPhone" value="${adress.primaryPhone}"
                           class="form-control" placeholder="Phone" required/>

                </div>

                <!--<input type="submit" value="Go to Shipment & Shipment method"-->
                       <!--class="btn btn-success btn-custom">-->



                <a href="/customer-account" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Continue Shopping</a>
                <!--<a href="/shipment" class="btn btn-warning btn-large pull-right">Next<span class="glyphicon glyphicon-chevron-right"></span></a>-->
                <a href="/shipment">  <input type="submit" value="Next" name="goShipment"
                                             class="btn btn-warning btn-custom"></a>
            </form>
</div>
</div>



</div>
</div>








