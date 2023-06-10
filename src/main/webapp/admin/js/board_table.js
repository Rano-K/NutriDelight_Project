/**
 * 
 */
function dataConnect(dataSetBoard, dataSetReview, dataSetNotice, sessionId) {
	let dataBoard = dataSetBoard;
	let dataReview = dataSetReview;
	let dataNotice = dataSetNotice;
	let sessionadmin = sessionId;

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

	//	Board Table
	$(document).ready(function() {
		var table = $('#boardTable').DataTable({
			data: dataBoard,
			columns: [
				{ title: '게시판 번호' },
				{ title: '원본글 번호' },
				{ title: 'layer' },
				{ title: 'user or admin' },
				{ title: '글쓴이' },
				{ title: '제품 이름' },
				{ title: '글 등록일자' },
				{ title: '글 등록 여부' },
				{ title: '글 제목' },
				{ title: '글 내용' },
				{ title: '글 이미지' },
				{ title: '글 업데이트 일자' },

			],
			columnDefs: [
				{
					targets: [1, 2, 3, 8, 9, 10], // 감추고자 하는 열의 인덱스
					visible: false // 열을 감춤
				}
			]
		});

		// 행 클릭 이벤트 처리
		$('#boardTable tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var ordercode = rowData[0];

				var url = 'admin_findproduct.do?pcode=' + ordercode;
				window.location.href = url;
					
		});
	});

	$(document).ready(function() {
		var table = $('#reviewTable').DataTable({
			data: dataReview,
			columns: [
				{ title: '게시판 번호' },
				{ title: 'parent' },
				{ title: 'layer' },
				{ title: 'user or admin' },
				{ title: '글쓴이' },
				{ title: '제품 이름' },
				{ title: '글 등록일자' },
				{ title: '글 등록 여부' },
				{ title: '글 내용' },
				{ title: '글 이미지' },
				{ title: '글 업데이트 일자' },

			],
			columnDefs: [
				{
					targets: [1, 2, 3, 8, 9], // 감추고자 하는 열의 인덱스
					visible: false // 열을 감춤
				}
			]
		});

		// 행 클릭 이벤트 처리
		$('#boardTable tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var ordercode = rowData[0];

				var url = 'admin_findproduct.do?pcode=' + ordercode;
				window.location.href = url;
					
		});
	});


	$(document).ready(function() {
		var table = $('#noticeTable').DataTable({
			data: dataNotice,
			columns: [
				{ title: '게시판 번호' },
				{ title: '관리자 아이디' },
				{ title: '글 등록일자' },
				{ title: '글 등록 여부' },
				{ title: '글 제목' },
				{ title: '글 내용' },
				{ title: '글 업데이트 일자' },

			],
			columnDefs: [
				{
					targets: [5], // 감추고자 하는 열의 인덱스
					visible: false // 열을 감춤
				}
			]
		});

		// 행 클릭 이벤트 처리
		$('#boardTable tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			var ordercode = rowData[0];

				var url = 'admin_findproduct.do?pcode=' + ordercode;
				window.location.href = url;
					
		});
	});
}