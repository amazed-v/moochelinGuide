package edu.kh.moochelinGuide.member.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/moochelinGuide/sql/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 이메일 중복확인
	 * @param conn
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(Connection conn, String memberEmail) throws Exception {
		int result=0;
		try {
			String sql = prop.getProperty("emailDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/** 회원가입
	 * @param conn
	 * @param mem
	 * @return
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem) throws Exception {
		int result=0;
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberName());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 로그인
	 * @param conn
	 * @param mem
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		Member member = null;
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberName(rs.getString("MEMBER_NM"));
				member.setProfileImage(rs.getString(4));
				member.setProfileBackImage(rs.getString(5));
				member.setEnrollDate(rs.getString(6));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	/** 특정 키워드로 유저 검색 DAO
	 * @param conn
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser(Connection conn, String query) throws Exception{
		List<Member> userList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("searchUser");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member mem = new Member();
				
				mem.setMemberNo(rs.getInt(1));
				mem.setMemberName(rs.getString(2));
				mem.setProfileImage(rs.getString(3));
				
				userList.add(mem);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return userList;
	}

	/** 특정 키워드로 영화 검색 DAO
	 * @param conn
	 * @param query
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> searchTitle(Connection conn, String query) throws Exception{
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("searchTitle");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Movie m = new Movie();
				
				m.setMovieNo(rs.getInt(1));
				m.setMovieTitle(rs.getString(2));
				m.setPosterImage(rs.getString(3));
				m.setReleaseYear(rs.getInt(4));
				m.setCountry(rs.getString(5));
				
				movieList.add(m);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return movieList;
	}

	/** 회원 탈퇴 - 비밀번호 일치여부 확인 DAO
	 * @param conn
	 * @param memberNo
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int secessionCheckPw(Connection conn, int memberNo, String inputPw) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("secessionCheckPw");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
					
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	

	/** 회원정보 수정 DAO 
	 * @param conn
	 * @param memberMod
	 * @param memberNo 
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member memberMod, int memberNo) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberMod.getMemberName());
			pstmt.setString(2, memberMod.getProfileImage());
			pstmt.setString(3, memberMod.getProfileBackImage());
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 평가하기 - 랜덤 영화 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> selectRandomMovie(Connection conn, int memberNo) throws Exception {
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			String sql = prop.getProperty("selectRandomMovie");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMovieNo(rs.getInt(1));
				m.setMovieTitle(rs.getString(2));
				m.setPosterImage(rs.getString(3));
				m.setReleaseYear(rs.getInt(4));
				m.setCountry(rs.getString(5));
						
				movieList.add(m);
			}	
			
		}finally {
			close(rs);
			close(pstmt);	
		}
		
		return movieList;
	}
	
	/** 평가 update DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return result
	 * @throws Exception
	 */
	public int updateEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, score);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, movieNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	/** 평가 insert DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return result
	 * @throws Exception
	 */
	public int insertEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			pstmt.setDouble(3, score);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 평가 delete DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return
	 * @throws Exception
	 */
	public int deleteEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}

	
	/** 평가한 영화 개수 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return count
	 * @throws Exception
	 */
	public int evaluationCount(Connection conn, int memberNo) throws Exception {
		int count = 0;
		
		try {
			
			String sql = prop.getProperty("evaluationCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}

	/** 로그인 회원의 팔로워 목록 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Follow> selectFollower(Connection conn, int memberNo) throws Exception{
		
		List<Follow> fList = new ArrayList<Follow>();
		
		try {
			
			String sql = prop.getProperty("selectFollower");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Follow f = new Follow();
				
				f.setTargetNo(memberNo); // 현재 회원번호
				
				f.setMemberNo(rs.getInt(1)); // 팔로워번호
				f.setMemberName(rs.getString(2)); // 팔로워 이름
				f.setEvaluationCount(rs.getInt(3)); // 팔로워의 평가개수
				f.setProfileImage(rs.getString(4)); // 팔로워의 프로필경로
				
				fList.add(f);				
			}			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return fList;
	}

	/** 로그인 회원의 팔로잉 목록 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Follow> selectFollowing(Connection conn, int memberNo) throws Exception{
		
		List<Follow> fList = new ArrayList<Follow>();
		
		try {
			
			String sql = prop.getProperty("selectFollowing");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Follow f = new Follow();
				
				f.setMemberNo(memberNo); // 현재 회원번호
				
				f.setTargetNo(rs.getInt(1)); // 팔로잉 회원 번호
				f.setMemberName(rs.getString(2)); // 팔로잉 회원 이름
				f.setEvaluationCount(rs.getInt(3)); // 팔로워의 평가개수
				f.setProfileImage(rs.getString(4)); // 팔로워의 프로필경로
				
				fList.add(f);	
				
			}
			
			
		}finally {
			
		}
		
		return fList;
	}

}
