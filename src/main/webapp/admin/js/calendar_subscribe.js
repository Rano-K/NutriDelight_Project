/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {

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


		dayMaxEvents: true, // allow "more" link when too many events
		events: dataSetSubscribe,
		eventClick: function(arg) {
			if (arg.event.backgroundColor === '#000000') {
				Swal.fire({
					text: "이미 배송 완료 처리된 이벤트입니다.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "확인",
					customClass: {
						confirmButton: "btn btn-primary",
					}
				});
			} else {
				Swal.fire({
					text: "배송 확인 처리 하시겠습니까?",
					icon: "warning",
					showCancelButton: true,
					buttonsStyling: false,
					confirmButtonText: "네,배송 완료 처리하겠습니다!",
					cancelButtonText: "아니요, 아직 도착 안하였습니다.",
					customClass: {
						confirmButton: "btn btn-primary",
						cancelButton: "btn btn-active-light"
					}
				}).then(function(result) {
					if (result.value) {
						arg.event.setProp('backgroundColor', '#000000');
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
			}
		}
	});

	calendar.render();
});

