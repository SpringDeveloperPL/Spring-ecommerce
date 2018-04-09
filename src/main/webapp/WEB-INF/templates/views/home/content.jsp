<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Carousel
================================================== -->
<div class="container-fluid">
    <div class="row">

        <div id="myCarousel" class="carousel slide carousel-fad" data-ride="carousel">

            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                <li data-target="#myCarousel" data-slide-to="3" class=""></li>

            </ol>
            <div class="carousel-inner" role="listbox">
                <c:forEach var="image" items="${imagesList}">


                    <c:choose>
                        <c:when test="${image.orderSequence=='1'}">
                            <div class="item active">
                                <br/>
                        </c:when>
                        <c:otherwise>
                            <div class="item">
                                <br/>
                        </c:otherwise>
                    </c:choose>

                    <img class="second-slide" src="/resources/images/${image.name}" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption"></div>
                    </div>
            </div>
            </c:forEach>

        </div>
        <a class="left carousel-control" href="#myCarousel" role="button"
           data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
                                    aria-hidden="true"></span> <span class="sr-only">Previous</span>
        </a> <a class="right carousel-control" href="#myCarousel" role="button"
                data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
                                         aria-hidden="true"></span> <span class="sr-only">Next</span>
    </a>
    </div>
    <!-- /.carousel -->

</div>
</div>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->


<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <c:forEach items="${promotionBoxList}" var="promotionBox">

            <div class="col-lg-4">

                <img class="img-circle" src="/resources/images/${promotionBox.imageName}"
                     alt="Generic placeholder image" width="140" height="140">
                <h2>${promotionBox.heading}</h2>
                <p>${promotionBox.description}</p>
                <p><a class="btn btn-default" href="${promotionBox.url}" role="button">View details »</a></p>
            </div><!-- /.col-lg-4 -->
        </c:forEach>

    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->


    <hr class="featurette-divider">

    <div class="row featurette">

        <c:forEach items="${largeBoxList}" var="largeBox">

            <div class="col-md-7">
                <h2 class="featurette-heading">${largeBox.heading}</h2>
                <p class="lead">${largeBox.description}</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto"
                     alt="500x500" src="/resources/images/${largeBox.imageName}" data-holder-rendered="true">
            </div>
        </c:forEach>

    </div>

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->


</div>
