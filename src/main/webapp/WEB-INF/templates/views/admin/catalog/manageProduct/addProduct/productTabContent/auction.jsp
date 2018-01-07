
<div class="form-group">

        <label for="price" class="col-sm-2 control-label">Time to end the auction:</label>

        <div id="datetimepicker1" class="input-append date">
            <div class="col-sm-10">

            <form:input data-format="dd/MM/yyyy hh:mm:ss" type="text" placeholder="time to end the auction" class="form-control" path="auctionEndDate"/>

                <span class="add-on">
      <i data-time-icon="fa fa-clock-o" data-date-icon="fa fa-calendar">
      </i>

        </div>
    </span>
    </div>
    <script type="text/javascript">
  $(function() {
    $('#datetimepicker1').datetimepicker({
      language: 'pt-BR'
    });
  });
</script>
</div>


<div class="form-group">
        <label for="price" class="col-sm-2 control-label">Price</label>

        <div class="col-sm-10">
            <form:input id="price" name="product.bidAmout" placeholder="Enter Price" type="number" class="form-control" value="" path="product.bidAmout"/>
        </div>
    </div>

    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Quentity</label>

        <div class="col-sm-10">
            <input id="price" name="product.quantity" placeholder="Enter Quantity" type="number" class="form-control" value="">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox" >
                <label> <form:checkbox path="product.onAuction"  /> On Auction </label>
            </div>
        </div>
    </div>



