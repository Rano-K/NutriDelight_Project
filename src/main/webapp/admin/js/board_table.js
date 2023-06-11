/**
 * 
 */
function previewImage(event) {
	var reader = new FileReader();
	reader.onload = function() {
		var imagePreview = document.getElementById('image-preview');
		imagePreview.src = reader.result;
		imagePreview.style.display = 'block';
	};
	reader.readAsDataURL(event.target.files[0]);
}

function dataConnect(dataSetBoard, dataSetReview, dataSetNotice, sessionId) {
	let dataBoard = dataSetBoard;
	let dataReview = dataSetReview;
	let dataNotice = dataSetNotice;
	let sessionadmin = sessionId;

	//	Board Table
	$(document).ready(function() {
		var table = $('#boardTable').DataTable({
			data: dataBoard,
			columns: [
				{ title: '게시판 번호' }, // 0
				{ title: 'parent' }, // 1
				{ title: 'layer' }, // 2
				{ title: 'user or admin' }, // 3
				{ title: '글쓴이' }, // 4
				{ title: '제품 이름' }, // 5 
				{ title: '글 등록일자' }, // 6
				{ title: '글 등록 여부' }, // 7
				{ title: '글 제목' }, // 8
				{ title: '글 내용' }, // 9
				{ title: '글 이미지' }, // 10
				{ title: '글 업데이트 일자' } // 11

			],
			columnDefs: [{
				targets: [1, 2, 3, 8, 9, 10], // 감추고자 하는 열의 인덱스
				visible: false // 열을 감춤
			}]
		});

		// 행 클릭 이벤트 처리
		$('#boardTable tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();

			Swal.fire({
				title: '게시글 관리',
				html: '<div style="text-align: left;">' +
					'<strong>제목: </strong> ' + rowData[8] +
					'<br><strong>내용: </strong> ' + rowData[9] +
					'<br><strong>아미지: </strong><img src="' + rowData[10] + '" alt="게시글 이미지">' +
					'</div>',
				icon: 'info',
				showConfirmButton: true,
				showDenyButton: true,
				showCancelButton: true,

				showCloseButton: true,

				confirmButtonText: '답글 달기',
				cancelButtonText: '수정 하기',
				denyButtonText: '삭제 하기'
			}).then((result) => {
				if (result.isConfirmed) { // 답글 달기로 선택한 경우
					if (rowData[3] === 'admin') { // 어드민 일때,
						Swal.fire({
							title: '본인 글의 답글',
							text: '본인 글에 답글을 달 수 없습니다.',
							icon: 'error',
							confirmButtonText: '확인'
						});

					} else {
						Swal.fire({
							title: '답글 달기',
							html:
								'<div style="text-align: left;">' +
								'<strong>제목: </strong> ' +
								'<input id="reply-title" class="swal2-input" placeholder="제목을 입력하세요" value="">' +
								'<strong>내용: </strong> ' +
								'<textarea id="reply-content" class="swal2-input" placeholder="내용을 입력하세요"></textarea>' +
								'<strong>이미지: </strong> ' +
								'<input id="reply-image" type="file" onchange="previewImage(event)">' +
								'<img id="image-preview" src="" alt="미리보기" style="max-width: 200px;" >' +
								'</div>',
							icon: 'info',
							showCancelButton: true,
							showCloseButton: true,
							confirmButtonText: '저장',
							cancelButtonText: '취소'
						}).then((result) => {
							if (result.isConfirmed) {
								const replyTitle = document.getElementById('reply-title').value;
								const replyContent = document.getElementById('reply-content').value;
								const replyImage = document.getElementById('reply-image').files[0];
							} 
						});
					}


				} else if (result.isDenied) { // 삭제할때.
					Swal.fire({
						title: '글 삭제',
						text: '글을 삭제 하시겠습니까?',
						icon: 'warning',
						showCancelButton: true,
						showCloseButton: true,
						confirmButtonText: '삭제',
						cancelButtonText: '취소'
					}).then((result) => {
						if (result.isConfirmed) {
							Swal.alert('삭제', '글이 삭제 완료되었습니다.', 'success');

						}
					});
				} else if (result.dismiss === Swal.DismissReason.cancel) { // 수정할때.
					if (rowData[3] === 'user') { // 어드민 일때,
						Swal.fire({
							title: '본인 글외 수정할수 없습니다.',
							text: '본인 글에 답글을 달 수 없습니다.',
							icon: 'error',
							confirmButtonText: '확인'
						});

					} else {
						Swal.fire({
							title: '수정 하기',
							html:
								'<div style="text-align: left;">' +
								'<strong>제목: </strong> ' +
								'<input id="reply-title" class="swal2-input" placeholder="제목" value="' + rowData[8] + '">' +
								'<strong>내용: </strong> ' +
								'<textarea id="reply-content" class="swal2-input" placeholder="내용">' + rowData[9] + '</textarea>' +
								'<strong>이미지: </strong> ' +
								'<input id="reply-image" type="file" onchange="previewImage(event)">' +
								'<img id="image-preview" src="' + rowData[10] + '" alt="미리보기" style="max-width: 200px;" >' +
								'</div>',
							icon: 'info',
							showCancelButton: true,
							showCloseButton: true,
							confirmButtonText: '저장',
							cancelButtonText: '취소'
						}).then((result) => {
							if (result.isConfirmed) {
								const replyTitle = document.getElementById('reply-title').value;
								const replyContent = document.getElementById('reply-content').value;
								const replyImage = document.getElementById('reply-image').files[0];
								
								
								Swal.alert('수정', '글이 수정 완료되었습니다.', 'success');
							}
						});
					}
				}
			});
		});

	});

	$(document).ready(function() {
		var table = $('#reviewTable').DataTable({
			data: dataReview,
			columns: [
				{ title: '게시판 번호' },		//0
				{ title: 'parent' },		//1
				{ title: 'layer' },			//2
				{ title: 'user or admin' },	//3
				{ title: '글쓴이' },			//4
				{ title: '제품 이름' },		//5
				{ title: '글 등록일자' },		//6
				{ title: '글 등록 여부' },		//7
				{ title: '글 내용' },			//8
				{ title: '글 이미지' },		//9
				{ title: '글 업데이트 일자' }	//10

			],
			columnDefs: [
				{
					targets: [1, 2, 3, 8, 9], // 감추고자 하는 열의 인덱스
					visible: false // 열을 감춤
				}
			]
		});

		// 행 클릭 이벤트 처리
		$('#reviewTable tbody').on('click', 'tr', function() {
			var rowData = table.row(this).data();
			// 게시글 내용 표시
			$('#post-seq').val(rowData[0]);
			$('#post-parent').val(rowData[1]);
			$('#post-layer').val(rowData[2]);
			$('#post-pcode').val(rowData[5]);
			$('#title').val("리뷰이므로, 제목이 없습니다.");
			$('#content').val(rowData[9]);
			$('#image').attr('src', rowData[10]);


			// 게시글 보기 화면 숨기고 모달 열기


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
				{ title: '글 업데이트 일자' }

			],
			columnDefs: [
				{
					targets: [5], // 감추고자 하는 열의 인덱스
					visible: false // 열을 감춤
				}
			]
		});

		// 행 클릭 이벤트 처리
		$('#noticeTable tbody').on('click', 'tr', function() {
			// 게시글 보기 화면 숨기고 모달 열기
			$('#post-modal').modal('show');
			var rowData = table.row(this).data();

			// 게시글 내용 표시
			$('#post-seq').val(rowData[0]);
			$('#post-parent').val("");
			$('#post-layer').val("");
			$('#post-pcode').val("");
			$('#title').val(rowData[4]);
			$('#content').text(rowData[5]);



		});
	});
}