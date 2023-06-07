package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDUserCartDao_LYJ;

public class NDuserCartDeleteCommand implements NDCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	
			
		
			String seq = request.getParameter("seq");

			
			NDUserCartDao_LYJ ndUserCartDao_LYJ = new NDUserCartDao_LYJ();
			ndUserCartDao_LYJ.delete(seq);
			
		
		}

	}
