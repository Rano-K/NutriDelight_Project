

async function checkRegex() {
  const regExpName = /^[\s가-힣]{1,20}$/;
  const regExpCategory = /^[\s가-힣]{1,20}$/;
  const regExpRice = /^[\s가-힣,()]{1,20}$/;
  const regExpCook1 = /^[\s가-힣,()]{1,20}$/;
  const regExpCook2 = /^[\s가-힣,()]{0,20}$/;
  const regExpCook3 = /^[\s가-힣,()]{0,20}$/;
  const regExpSoup = /^[\s가-힣,()]{1,20}$/;
  const regExpStock = /^[0-9]{0,20}$/;
  const regExpPrice = /^[0-9]{0,20}$/;
  const regExpCalories = /^[0-9]{0,20}$/;

  const name = document.getElementById("name").value;
  const category = document.getElementById("category").value;
  const rice = document.getElementById("rice").value;
  const cook1 = document.getElementById("cook1").value;
  const cook2 = document.getElementById("cook2").value;
  const cook3 = document.getElementById("cook3").value;
  const soup = document.getElementById("soup").value;
  const stock = document.getElementById("stock").value;
  const price = document.getElementById("price").value;
  const calories = document.getElementById("calories").value;

  if (!regExpName.test(name)) {
    await Swal.fire(
      '제품 이름 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpCategory.test(category)) {
    await Swal.fire(
      '카테고리 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpRice.test(rice)) {
    await Swal.fire(
      '밥 항목 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpCook1.test(cook1)) {
    await Swal.fire(
      '첫번째 반찬 항목 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpCook2.test(cook2)) {
    await Swal.fire(
      '두번째 반찬 항목 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpCook3.test(cook3)) {
    await Swal.fire(
      '세번째 반찬 항목 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpSoup.test(soup)) {
    await Swal.fire(
      '국 항목 수정이 필요합니다.',
      '20자 이하 한글 이름만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpStock.test(stock)) {
    await Swal.fire(
      '재고 수량 수정이 필요합니다.',
      '20자 이하 숫자만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpPrice.test(price)) {
    await Swal.fire(
      '가격 수정이 필요합니다.',
      '20자 이하 숫자만 가능합니다.',
      'error'
    );
    return;
  }

  if (!regExpCalories.test(calories)) {
    await Swal.fire(
      '칼로리 수정이 필요합니다.',
      '20자 이하 숫자만 가능합니다.',
      'error'
    );
    return;
  }

  Swal.fire({
    title: '수정 및 입력 확인',
    text: '수정 및 입력하시겠습니까?',
    icon: 'warning',
    showCancelButton: true,
    showCloseButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: '승인',
    cancelButtonText: '취소',
    allowOutsideClick: false,
    allowEscapeKey: false
  }).then(async (result) => {
    if (result.isConfirmed) {
      form.addEventListener('submit', function (event) {
        event.preventDefault();
        form.submit();
      });
      await Swal.fire({
        title: '승인',
        text: '수정 및 입력 처리되었습니다.',
        icon: 'success',
        confirmButtonText: '확인',
        confirmButtonColor: '#3085d6',
        allowOutsideClick: false,
        allowEscapeKey: false
      });
      form.submit();
    }
  }).catch((error) => {
    console.error(error);
  });
}
