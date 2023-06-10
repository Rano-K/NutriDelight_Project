/**
 * 
 */
function dataConnect(datasetSubscribe) {
	let dataSubscribe = datasetSubscribe;
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			// Tool Bar 목록 document : https://fullcalendar.io/docs/toolbar
			themeSystem: 'bootstrap',
			locale: 'ko',

			headerToolbar: {
				left: 'prevYear,prev,next,nextYear today',
				center: 'title',
				right: 'dayGridMonth,dayGridWeek,dayGridDay'
			},

			selectable: true,
			selectMirror: true,

			navLinks: true, // can click day/week names to navigate views
			editable: true,

			select: function(arg) {
				Swal.fire({
					html: "<div class='mb-7'>Create new event?</div><div class='fw-bold mb-5'>Event Name:</div><input type='text' class='form-control' name='event_name' />",
					icon: "info",
					showCancelButton: true,
					buttonsStyling: false,
					confirmButtonText: "Yes, create it!",
					cancelButtonText: "No, return",
					customClass: {
						confirmButton: "btn btn-primary",
						cancelButton: "btn btn-active-light"
					}
				}).then(function(result) {
					if (result.value) {
						var title = document.querySelector("input[name=;event_name']").value;
						if (title) {
							calendar.addEvent({
								title: title,
								start: arg.start,
								end: arg.end,
								allDay: arg.allDay
							})
						}
						calendar.unselect()
					} else if (result.dismiss === "cancel") {
						Swal.fire({
							text: "Event creation was declined!.",
							icon: "error",
							buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn btn-primary",
							}
						});
					}
				});
			},

			// Delete event
			eventClick: function(arg) {


				Swal.fire({
					text: "Are you sure you want to delete this event?",
					icon: "warning",
					showCancelButton: true,
					buttonsStyling: false,
					confirmButtonText: "Yes, delete it!",
					cancelButtonText: "No, return",
					customClass: {
						confirmButton: "btn btn-primary",
						cancelButton: "btn btn-active-light"
					}
				}).then(function(result) {
					if (result.value) {
						arg.event.remove()
					} else if (result.dismiss === "cancel") {
						Swal.fire({
							text: "Event was not deleted!.",
							icon: "error",
							buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn btn-primary",
							}
						});
					}
				});
			},
			dayMaxEvents: true, // allow "more" link when too many events
			events: dataSubscribe
		});

		calendar.render();
	});
}

