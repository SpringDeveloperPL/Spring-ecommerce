<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style >

.img-cart {
    display: block;
    max-width: 100px;
    height: auto;
    margin-left: auto;
    margin-right: auto;
}
table tr td{
    border:1px solid #FFFFFF;
}

table tr th {
    background:#eee;
}


</style>

<div class="container bootstrap snippet">
    <div class="col-md-12 col-sm-8">

        <div class="row">
            <div class="col-md-12">

                    <div class="panel-body">
                        <form action="" method="POST">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Description</th>
                                    <th>Qty</th>
                                    <th>Price</th>
                                    <th>Remove</th>
                                </tr>
                                </thead>

                                <tbody>


                                <c:forEach var="cartItem" items="${cartItems}">

                                <tr>
                                    <td><img src="/resources/productImages/${cartItem.payment.product.imageName}" class="img-cart"></td>
                                    <td><strong>${cartItem.payment.product.name}</strong></td>
                                    <td>
                                        <form class="form-inline">
                                            <input class="form-control" type="text" value="1" readonly>
                                        </form>
                                    </td>
                                    <td>$${cartItem.payment.product.bidAmout}</td>
                                    <td class="col-sm-1 col-md-1">
                                        <button type="submit" class="btn btn-danger" name="removeItem" value="${cartItem.cartDetailID}">
                                            <span class="glyphicon glyphicon-remove"></span> Remove
                                        </button></td>                                 </tr>
                                </c:forEach>

                                <tr>
                                    <td colspan="4">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td colspan="4" class="text-right">Total Product</td>
                                    <td>$${cartInfo.totalPrice}</td>
                                </tr>
                                <tr>
                                    <td colspan="4" class="text-right">Total Shipping</td>
                                    <td>$0.00</td>
                                </tr>
                                <tr>
                                    <td colspan="4" class="text-right"><strong>Total</strong></td>
                                    <td>$${cartInfo.totalPrice}</td>
                                </tr>


                                </tbody>


                            </table>
                        </form>
                        </div>
                    </div>
                </div>





                <a href="#" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Continue Shopping</a>
                <a href="#" class="btn btn-warning btn-large pull-right">Next<span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>
</div>