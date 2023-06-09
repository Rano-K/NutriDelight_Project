/**
 * 
 */
function dataConnect(dataSetProduct) {
	let dataProduct = dataSetProduct;

	//	Modal
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
	});

	//	Table
	$(document).ready(function() {
		var table = $('#product').DataTable({
			data: dataProduct,
			columns: [
				{ title: '상품번호' },
				{ title: '상품 이름' },
				{ title: '카테고리' },
				{ title: '밥' },
				{ title: '반찬 1' },
				{ title: '반찬 2' },
				{ title: '반찬 3' },
				{ title: '국' },
				{ title: '재고' },
				{ title: '가격' },
				{ title: '등록일자' },
				{ title: '업데이트 일자' },
				{ title: '상품상태' }


			]
		});

		// 행 클릭 이벤트 처리
		$('#product tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var ordercode = rowData[0];

				var url = 'admin_findproduct.do?pcode=' + ordercode;
				window.location.href = url;
					
		});
	});
}