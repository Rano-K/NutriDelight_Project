/**
 * 
 */
function dataConnect(dataSetOrders) {
	let dataOrders = dataSetOrders;
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

	var dataSet = dataOrders;

	$(document).ready(function() {
		var table = $('#orders').DataTable({
			data: dataSet,
			columns: [
				{ title: '주문번호' },
				{ title: '주문 id' },
				{ title: '상품 코드' },
				{ title: '배송 주소' },
				{ title: '주문 갯수' },
				{ title: '재고' },
				{ title: '주문날짜' },
				{ title: '환불날짜' },
				{ title: '배송날짜' }
			]
		});

		// 행 클릭 이벤트 처리
		$('#orders tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var ordercode = rowData[0];
			var refunddate = rowData[7];
			var deliverydate = rowData[8];

			if (refunddate === '환불되지 않았습니다.' && deliverydate === '배송되지 않았습니다.') {
				var url = 'admin_updateorders.do?ordercode=' + ordercode;
				console.log(url);
				// 페이지 이동
				window.location.href = url;
			} else {
				Toast.fire({
					icon: 'error',
					title: '필요 없는 작업입니다.'
				})
			}
		});
	});
}