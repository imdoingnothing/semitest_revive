package board.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;

import board.model.dao.BoardDao;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		int count = new BoardDao().getListCount(conn);
		close(conn);
		return count;
	}

}
