package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserOrdersDao_LYJ;

public class NDUserOrdersInsertCommand_LYJ implements NDCommand {

    // 콤마로 구분된 문자열을 배열로 분리하는 메서드
    private String[] splitValues(String str) {
        return str.split(",");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("userid"); // 단일 값으로 변경
        String pcode = request.getParameter("pcodeList"); // 단일 값으로 변경
        String count = request.getParameter("countList"); // 단일 값으로 변경
        String address = request.getParameter("address"); // 단일 값으로 변경

        String[] userids = splitValues(userid);
        String[] pcodeList = splitValues(pcode);
        String[] countList = splitValues(count);
        String[] addresses = splitValues(address);

        NDUserOrdersDao_LYJ ndUserOrdersDao_LYJ = new NDUserOrdersDao_LYJ();

        for (int i = 0; i < userids.length; i++) {
            userid = userids[i];
            address = addresses[i];
            pcode = pcodeList[i];

            // count를 int로 변환
            int countValue = Integer.parseInt(countList[i].replace(",", ""));
            
            boolean list = ndUserOrdersDao_LYJ.insertOrder(userid, pcode, countValue, address);

            // 각 상품에 대한 구매 기록을 리스트에 추가합니다.
            request.setAttribute("list" + i, list);
        }
    }
}
