$(document).ready(
		function() {
			console.log("ready!");
			var callNo = 1;
			function worker() {
				var now = new Date($.now());
				// Saturday, June 9th, 2007, 5:46:21 PM
				$('#thead-data').html("Fetching RT data: " + callNo +'  '+now)
				callNo = callNo + 1;
				console.log("Now Calling : " + callNo);
				$.ajax({
					url : 'http://localhost:8080/RTFlowCheck/getAnalysedData',
					dataType : "json",
					success : function(data) {
						console.log(data);
						// Populate Data
						var obj = data;
						$('#data-table').find("tr:gt(0)").remove();
						for (var i = 0, len = obj.length; i < len; i++) {
							console.log("Dam_Name: " + obj[i].dam_name + ' '
									+ "Dam_Water: " + obj[i].dam_water_mass
									+ ' ' + "Dam_Max: "
									+ obj[i].dam_max_capacity + ' '
									+ "Dam_alert: " + obj[i].dam_alert_status);
							$('#data-table').find('tbody').append(
									'<tr><td>' + obj[i].dam_name + '</td><td>'
											+ obj[i].dam_water_mass
											+ '</td><td>'
											+ obj[i].dam_max_capacity
											+ '</td><td>'
											+ obj[i].dam_alert_status
											+ '</td></tr>');
						}
						$('.result').html(data);
					},
					complete : function() {
						// Schedule the next request when the current one's
						// complete
						setTimeout(worker, 2000);
					}
				});
			}
			worker();

		});

/*
 * (function worker() { $.ajax({ url: '/getAnalysedData', success:
 * function(data) { alert(data); $('.result').html(data); }, complete:
 * function() { // Schedule the next request when the current one's complete
 * setTimeout(worker, 5000); } }); })();
 */