<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section class="content-header" xmlns:sf="http://www.w3.org/1999/html">
    <h1>
        Slideshow <small>slideshow </small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active">Slideshow</li>
    </ol>

</section>



<div class="containe-fluid">
    <div class="col-md-12 ">
        <div class="form-group ">

            <sf:form class="form-horizontal" modelAttribute="slideshowForm" method="POST" enctype="multipart/form-data" >

            <label class="control-label" for="file_1" >Select 1 Slide</label>

            <c:forEach var="image" items="${imagesList}">
<div class="row">
                <div class="col-sm-3">

                    <div class="col-sm-2">

                        <img src="/resources/images/${image.name}" width="200" height="100"/>
                    </div>
                </div>

                <div class="col-sm-2">
                    order sequence  <b> ${image.orderSequence} </b><br>
                    <a href="/dashboard/promotion/slideshow/remove/${image.slideshowImageID}">Remove</a>

                </div>


</div>
            </c:forEach>

                <br>
                <div class="col-sm-2">
            <sf:input type="file" path="file" id="file" class="form-control"/>
                </div>
                <div class="col-sm-2">
               <sf:input type="number" path="imageProperties.orderSequence" id="file" class="form-control" value="${image.orderSequence}"/>
                    <input type="submit" value="Save changes"
                           class="btn btn-success btn-custom"> </div>


        </sf:form>
    </div>
</div>