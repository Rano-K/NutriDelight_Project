package com.javalec.bbs.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDBoardDao_OKH;
import com.javalec.bbs.dao.NDNoticeDao_OKH;
import com.javalec.bbs.dao.NDProductDao_OKH;
import com.javalec.bbs.dao.NDReviewDao_OKH;
import com.javalec.bbs.dto.NDBoardDto_OKH;
import com.javalec.bbs.dto.NDNoticeDto_OKH;
import com.javalec.bbs.dto.NDReviewDto_OKH;

public class NDBoardSearchCommand_OKH implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// DAO
		NDBoardDao_OKH boardDao = new NDBoardDao_OKH();
		NDReviewDao_OKH reviewDao = new NDReviewDao_OKH();
		NDNoticeDao_OKH noticeDao = new NDNoticeDao_OKH();

		NDProductDao_OKH productDao = new NDProductDao_OKH();
		// DTO

		// Board
		ArrayList<NDBoardDto_OKH> dtoBoard = boardDao.searchBoard();

		ArrayList<ArrayList<String>> dataSetBoard = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoBoard.size(); i++) {
			NDBoardDto_OKH boardDto = dtoBoard.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(boardDto.getSeq()) + "'");
			row.add("'" + Integer.toString(boardDto.getParent()) + "'");
			row.add("'" + Integer.toString(boardDto.getLayer()) + "'");
			if (boardDto.getAdminid() == null) { // 글쓴이가 유저일때.
				row.add("'user'");
				row.add("'" + boardDto.getUserid() + "'");
				row.add("'" + productDao.getPname(boardDto.getPcode()) + "'");
				row.add("'" + (boardDto.getInsertdate() != null ? dateFormat.format(boardDto.getInsertdate()) : "")
						+ "'");
				if (boardDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				}
				row.add("'" + boardDto.getBwtitle() + "'");
				row.add("'" + boardDto.getBwcontext() + "'");
				if (boardDto.getBwimage() != null) {
					row.add("'" + boardDto.getBwimage() + "'");
				} else {
					row.add("' '");
				}
				row.add("'" + (boardDto.getBwupdatedate() != null ? dateFormat.format(boardDto.getBwupdatedate()) : "")
						+ "'");

			} else { // 글쓴이가 관리자 일때.
				row.add("'admin'");
				row.add("'" + boardDto.getAdminid() + "'");
				row.add("'" + productDao.getPname(boardDto.getPcode()) + "'");
				row.add("'" + (boardDto.getInsertdate() != null ? dateFormat.format(boardDto.getInsertdate()) : "")
						+ "'");
				if (boardDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				}
				row.add("'" + boardDto.getBrtitle() + "'");
				row.add("'" + boardDto.getBrcontext() + "'");
				row.add("'이미지가 없습니다.'");
				row.add("'" + (boardDto.getBrupdatedate() != null ? dateFormat.format(boardDto.getBrupdatedate()) : "")
						+ "'");
			}

			dataSetBoard.add(row);
		}

		// Review
		ArrayList<NDReviewDto_OKH> dtoReview = reviewDao.searchBoard();

		ArrayList<ArrayList<String>> dataSetReview = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoBoard.size(); i++) {
			NDReviewDto_OKH reviewDto = dtoReview.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(reviewDto.getSeq()) + "'");
			row.add("'" + Integer.toString(reviewDto.getParent()) + "'");
			row.add("'" + Integer.toString(reviewDto.getLayer()) + "'");

			if (reviewDto.getAdminid() == null) { // 글쓴이가 유저일때.
				row.add("'user'");
				row.add("'" + reviewDto.getUserid() + "'");
				row.add("'" + productDao.getPname(reviewDto.getPcode()) + "'");
				row.add("'" + (reviewDto.getInsertdate() != null ? dateFormat.format(reviewDto.getInsertdate()) : "")
						+ "'");
				if (reviewDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				}
				row.add("'" + reviewDto.getRwcontext() + "'");
				if (reviewDto.getRwimage() == null) {
					row.add("'" + reviewDto.getRwimage() + "'");
				} else {
					row.add("' '");
				}
				row.add("'"
						+ (reviewDto.getRwupdatedate() != null ? dateFormat.format(reviewDto.getRwupdatedate()) : "")
						+ "'");
			} else { // 글쓴이가 관리자 일때.
				row.add("'admin'");
				row.add("'" + reviewDto.getAdminid() + "'");
				row.add("'" + productDao.getPname(reviewDto.getPcode()) + "'");
				row.add("'" + (reviewDto.getInsertdate() != null ? dateFormat.format(reviewDto.getInsertdate()) : "")
						+ "'");
				if (reviewDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				}
				row.add("'" + reviewDto.getRrcontext() + "'");
				row.add("'이미지가 없습니다.'");
				row.add("'"
						+ (reviewDto.getRrupdatedate() != null ? dateFormat.format(reviewDto.getRrupdatedate()) : "")
						+ "'");
			}
			dataSetReview.add(row);
		}

		// Notice
		ArrayList<NDNoticeDto_OKH> dtoNotice = noticeDao.searchBoard();

		ArrayList<ArrayList<String>> dataSetNotice = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoNotice.size(); i++) {
			NDNoticeDto_OKH noticeDto = dtoNotice.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(noticeDto.getSeq()) + "'");
			row.add("'" + noticeDto.getAdminid() + "'");
			row.add("'" + (noticeDto.getInsertdate() != null ? dateFormat.format(noticeDto.getInsertdate()) : "") + "'");
			if (noticeDto.getInvalidate() == 1) {
				row.add("'유효한 글'");
			} else {
				row.add("'삭제된 글'");
			}
			row.add("'" + noticeDto.getTitle() + "'");
			row.add("'" + noticeDto.getContext() + "'");
			row.add("'" + (noticeDto.getUpdatedate() != null ? dateFormat.format(noticeDto.getUpdatedate()) : "") + "'");

			dataSetNotice.add(row);
		}

		// data
		request.setAttribute("dataSetBoard", dataSetBoard);
		request.setAttribute("dataSetReview", dataSetReview);
		request.setAttribute("dataSetNotice", dataSetNotice);
	}

}
