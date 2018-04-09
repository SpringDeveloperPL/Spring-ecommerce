<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section class="content-header" xmlns:sf="http://www.w3.org/1999/html" xmlns:sf="http://www.w3.org/1999/html">
    <h1>
        Large Box
        <small>Large Box</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active"> Large Box</li>
    </ol>

</section>

<div class="containe-fluid">

    <div class="row">
        <div class="col-md-12">

            <sf:form class="form-horizontal" modelAttribute="largeBoxForm" method="POST" enctype="multipart/form-data">
                <div class="row">

                    <div class="col-md-5">

                        <sf:input type="text" path="box1.heading" id="heading" class="form-control"
                                  value="${largeBoxForm.box1.heading}" placeholder="Enter heading"/>
                        <sf:textarea path="box1.description" id="heading" class="form-control"
                                     value="${box1.description}" placeholder="Enter Description"/>

                        <sf:input type="hidden" path="box1.largeBoxID" id="largeBoxID" class="form-control"
                                  value="1"/>


                    </div>
                    <div class="col-md-5">

                        <sf:input type="file" path="box1.imageFile" id="file" class="form-control"/>

                        <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto"

                             src="/resources/images/${imageName1}"
                             data-holder-rendered="true">
                    </div>
                </div>
                <br>
                <div class="row">

                    <div class="col-md-5">

                        <sf:input type="text" path="box2.heading" id="heading" class="form-control"
                                  value="${box2.heading}" placeholder="Enter heading"/>
                        <sf:textarea path="box2.description" id="heading" class="form-control"
                                     value="${box2.description}" placeholder="Enter Description"/>

                        <sf:input type="hidden" path="box2.largeBoxID" id="largeBoxID" class="form-control"
                                  value="2"/>


                    </div>
                    <div class="col-md-5">

                        <sf:input type="file" path="box2.imageFile" id="file" class="form-control"/>

                        <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto"

                             src="/resources/images/${imageName2}"
                             data-holder-rendered="true">
                    </div>
                </div>
                <br>

                <div class="row">

                    <div class="col-md-5">

                        <sf:input type="text" path="box3.heading" id="heading" class="form-control"
                                  value="${box3.heading}" placeholder="Enter heading"/>
                        <sf:textarea path="box3.description" id="heading" class="form-control"
                                     value="${box3.description}" placeholder="Enter Description"/>

                        <sf:input type="hidden" path="box3.largeBoxID" id="largeBoxID" class="form-control"
                                  value="3"/>


                    </div>


                    <div class="col-md-5">

                        <sf:input type="file" path="box3.imageFile" id="file" class="form-control"/>

                        <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto"

                             src="/resources/images/${imageName3}"
                             data-holder-rendered="true">
                    </div>
                </div>


                <input type="submit" value="Save changes"
                       class="btn btn-success btn-custom">

            </sf:form>
        </div>
    </div>

</div>