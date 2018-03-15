<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section class="content-header" xmlns:sf="http://www.w3.org/1999/html">
    <h1>
        Promotion Box
        <small>promotion Box</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active"> Promotion Box</li>
    </ol>

</section>

<div class="containe-fluid">

    <div class="row">
        <div class="col-md-12">

        <sf:form class="form-horizontal" modelAttribute="promotionBoxForm" method="POST" enctype="multipart/form-data">
            <div class="col-lg-4">
                <img class="img-circle" src="/resources/images/${box1.imageName}"  width="140" height="140">
                <sf:input type="file" path="box1.imageFile" id="file" class="form-control"/>

                <h2><sf:input type="text" path="box1.heading" id="heading" class="form-control" value="${box1.heading}" placeholder="Enter heading"/>
                </h2>
                <sf:textarea path="box3.description" id="description" class="form-control" value="${box1.description}"  placeholder="Enter Short description" />
                <h2><sf:input type="text" path="box1.url" id="url" class="form-control" value="${box1.url}" placeholder="Enter Url"/></h2>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="img-circle" src="/resources/images/${box2.imageName}"  width="140" height="140">
                <sf:input type="file" path="box2.imageFile" id="file" class="form-control"/>

                <h2><sf:input type="text" path="box2.heading" id="heading" class="form-control" value="${box2.heading}" placeholder="Enter heading"/>
                </h2>
                <sf:textarea path="box3.description" id="description" class="form-control" value="${box2.description}"  placeholder="Enter Short description" />
                <h2><sf:input type="text" path="box2.url" id="url" class="form-control" value="${box2.url}" placeholder="Enter Url"/></h2>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="img-circle" src="/resources/images/${box2.imageName}"  width="140" height="140">
                <sf:input type="file" path="box3.imageFile" id="file" class="form-control"/>

                <h2><sf:input type="text" path="box3.heading" id="heading" class="form-control" value="${box3.heading}" placeholder="Enter heading"/>
                </h2>
                <sf:textarea path="box3.description" id="description" class="form-control" value="${box3.description}"  placeholder="Enter Short description" />
                <h2><sf:input type="text" path="box3.url" id="url" class="form-control" value="${box3.url}" placeholder="Enter Url"/></h2>
            </div><!-- /.col-lg-4 -->

            <input type="submit" value="Save changes"
                   class="btn btn-success btn-custom">
        </sf:form>
    </div>
</div>
</div>