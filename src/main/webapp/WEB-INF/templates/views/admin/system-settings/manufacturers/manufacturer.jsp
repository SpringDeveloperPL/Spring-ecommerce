<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
<div class="row">
    <div class="col-md-4">

<form:form modelAttribute="manufacturer" class="form-horizontal"
           method="POST" action="/dashboard/manage-manufacturers">

<div class="form-group">
    <label for="manufacturerName" class="col-sm-5 control-label">Manufacturer Name</label>

    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="name" path="name"
                    placeholder="Enter manufacturer name" />
        <input type="submit" class="btn btn-default" value="Save" />

    </div>


</div>


</form:form>

<label>Manufacturers list: </label>
            <c:forEach var="listValue" items="${manufacturerList}">

            <a href="#" class="list-group-item">${listValue.name} </a>
                <a href="/dashboard/manage-manufacturers/remove/${listValue.manufacturerId}">Remove</a>
            </c:forEach>






</div>

</div>

</div>