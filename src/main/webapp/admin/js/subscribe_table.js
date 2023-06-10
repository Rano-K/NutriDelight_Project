/**
 * 구독 테이블
 */
function dataConnect(dataSetSubscribe) {
	let dataSubscribe = dataSetSubscribe;
	console.log(dataSubscribe);

	let today = new Date();
	let year = today.getFullYear(); // 년도
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	let todaydate = year + '-' + month + '-' + day;

	const Toast = Swal.mixin({
		toast: true,
		position: 'center-center',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
		width: '600px',
		height: '600px',
		didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	})

	var dataSet = dataSubscribe;
	$(document).ready(function() {
		var table = $('#subscribe').DataTable({
			data: dataSet,

			columns: [
				{ title: '구독 코드' },
				{ title: '유저 아이디' },
				{ title: '구독 시작 일자' },
				{ title: '구독 종료 일자' },
				{ title: '구독 일정 보기' },
				{ title: '마지막 배송 일자' },
				{ title: '오늘 배송 품목' }
			]
		});


		// 행 클릭 이벤트 처리
		$('#subscribe tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var scode = rowData[0];
			var deliverydate = rowData[5];


			if (deliverydate === todaydate) {
				Toast.fire({
					icon: 'error',
					title: '금일 배송 작업은 끝났습니다.'
				})
			} else {
				var url = 'admin_checksubscribe.do?scode=' + scode;
				// 페이지 이동
				window.location.href = url;

			}
		});
	});
}