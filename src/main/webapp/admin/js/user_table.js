/**
 * 
 */
function dataConnect(dataSetUser) {
	var dataSet = dataSetUser;

	$(document).ready(function() {
		var table = $('#user').DataTable({
			data: dataSet,
			columns: [{
				title: 'ID'
			}, {
				title: '이름'
			}, {
				title: '성별'
			}, {
				title: '나이'
			}, {
				title: '전화 번호'
			}, {
				title: '주소'
			}, {
				title: '이메일'
			}, {
				title: '총 구매액'
			}, {
				title: '알러지 정보'
			}, {
				title: '가입날짜'
			}, {
				title: '회원상태'
			}],
			"order": [
				[10, 'desc']
			]
		});

	});
}