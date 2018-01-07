<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
.timer-wrapper {
	margin: 0;
	text-align: center;
	min-height: 50px
}

.timer-wrapper .timer-header, .timer-wrapper .day-timer-header {
	margin: 0 0 10px;
	display: none
}

.timer-wrapper .day-timer-header .icon-f-clock {
	margin-right: 10px
}

.timer-wrapper .timer {
	font-weight: 700;
	margin: 10px 0;
	display: none
}

.timer-wrapper .timer .highlighted {
	color: #ff5a00
}

.timer-wrapper .timer .icon-f-clock {
	margin-right: 10px
}

.timer-wrapper .timer span {
	padding: 0 3px
}

.timer-wrapper .ended, .timer-wrapper .day-timer {
	margin: 10px 0;
	display: none
}

.timer-wrapper .ended strong, .timer-wrapper .day-timer strong {
	display: inline-block;
	padding-bottom: 5px
}

.item-price>.timer-wrapper {
	text-align: right
}
</style>
<div class="container">
	<div class="jumbotron">
		<div class="container">
			<h1>Product</h1>
			<h2>${product.name}</h2>
		</div>
	</div>

	<div class="row">






		<div class="col-md-4">
			<img
				src="<c:url value="/resources/productImages/${product.imageName}"></c:url>"
				alt="image" style="width: 100%" width="200" height="" />
		</div>
		<div class="row">


			<div class="row">
				<form  method="POST"  action="">

				<div class="col-md-7">
				    <p> <strong>6 osób</strong> licytuje <strong></strong> </p>
				
					<h3>${product.name}</h3>

					<p>
						<strong>Description: </strong>${product.description}</p>
					<p>
						<strong>SKU: </strong><span class="label label-warning">${product.sku}</span>
					</p>
					<p>
						<strong>Manufacturer</strong>: ${product.manufacturer}
					</p>
					<p></p>
					<p>
						<strong>Unit in Stack </strong>:${product.quantity}
					</p>
					<p>
				</div>


				<div class="col-xm-6">

					<div class="col-md-2">
						<div class="above">
							<a
								href="http://pomoc.allegro.pl/24521/24515/27693/jak-dziala-licytacja-w-allegro">Twoja
								oferta</a>
						</div>

						<input type="number" class="form-control amount" name="name" placeholder="Enter URL Key" />

					</div>
				</div>






				<div class="col-md-2">


					<div id="timer-wrapper" data-countdown-timestamp="${countdownTimestamp}"
						data-server-time="${serverTime}" data-highlighted-time="5"
						data-show-timer-time="1440"
						data-months-translate="stycznia,lutego,marca,kwietnia,maja,czerwca,lipca,sierpnia,września,października,listopada,grudnia"
						data-day-singular-translate="dzień"
						data-day-plural-translate="dni"
						data-days-translate="niedziela,poniedziałek,wtorek,środa,czwartek,piątek,sobota">
						<div class="day-timer-header">
							<i class="icon-f-clock"></i><strong></strong>
						</div>
						<div class="timer-header" style="display: block;">Time to
							end acution</div>
						<div id="days"></div>
						<div class="timer" style="display: block;">
							<i class="icon-f-clock"></i> <span id="hours">00</span>:<span
								id="minutes">00</span>:<span id="secends">00</span>
						</div>

						<p>
							<!-- Large modal -->
							<button type="submit" id="finished" class="btn btn-warning btn-large" data-toggle="model" data-target=".bs-example-modal-lg"><span
									class="glyphicon-shopping-cart glyphicon"></span>Bidd Now</button>

						</p>


				</div>



					<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
						<div class="modal-dialog modal-lg" role="document">
							<div class="modal-content" style="padding:20px;">
								You Can not bidd , Auctios has come to end

								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>

							</div>
						</div>
					</div>

					<script>
            var endMilesecends =document.getElementById("timer-wrapper").getAttribute("data-countdown-timestamp");
 var div = document.getElementById("finished")


            function countdown() {
                endMilesecends=endMilesecends-1000;



                if(endMilesecends>0) {

				div.setAttribute("data-toggle", "");

                    var secends = Math.floor(endMilesecends/1000);
                    var minutes = Math.floor(secends/60);
                    var hours = Math.floor(minutes/60);
                    var days = Math.floor(hours/24);
                    hours %=24;
                    minutes %= 60;
                    secends %= 60;
                    days = (days<10) ? "0" + days : days;
                    hours = (hours<10) ? "0" + hours : hours;
                    minutes = (minutes<10) ? "0" + minutes : minutes;
                    secends = (secends<10) ? "0" + secends : secends;

                    document.getElementById('days').innerHTML  = days;
                    document.getElementById("hours").innerHTML  = hours;
                    document.getElementById("minutes").innerHTML  = minutes;
                    document.getElementById("secends").innerHTML  = secends;
                }else {
div.setAttribute("data-toggle", "modal");
                }
                setTimeout(countdown,1000);


            }
            countdown();

        </script>
				</div>

			</div>


		</div>

	</div>
</div>