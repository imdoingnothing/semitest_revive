package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {
		Connection conn = getConnection();
		Member loginMember = new MemberDao().loginMember(conn, member);
		
		close(conn);
		return loginMember;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, member);
		
		if( result > 0 ) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = new MemberDao().selectMember(conn, userId);
		close(conn);
		return member;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, member);
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId);
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
