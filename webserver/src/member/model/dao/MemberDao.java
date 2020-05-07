package member.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;


public class MemberDao {
	Properties prop = new Properties();
			
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		Member loginMember = null;
		
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				loginMember = new Member();
				loginMember.setUserNo(rset.getInt("USER_NO"));
				loginMember.setUserId(rset.getString("USER_ID"));
				loginMember.setUserPwd(rset.getString("USER_PWD"));
				loginMember.setUserName(rset.getString("USER_NAME"));
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setAddr(rset.getString("ADDRESS"));
				loginMember.setInterest(rset.getString("INTEREST"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setModifyDate(rset.getDate("MODIFY_DATE"));
				loginMember.setStatus(rset.getString("STATUS"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return loginMember;
//		다시 Service로 돌아가자
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddr());
			pstmt.setString(7, member.getInterest());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("PHONE"),
						rset.getString("EMAIL"),
						rset.getString("ADDRESS"),
						rset.getString("INTEREST"),
						rset.getDate("ENROLL_DATE"),
						rset.getDate("MODIFY_DATE"),
						rset.getString("STATUS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getInterest());
			pstmt.setString(6, member.getUserId());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}










