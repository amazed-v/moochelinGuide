package edu.kh.moochelinGuide.comment.service;
import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.moochelinGuide.comment.dao.CommentDAO;
import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.comment.vo.Pagination;

public class CommentService {
	private CommentDAO dao = new CommentDAO();

    /** 코멘트 목록 조회 Service
     * @param movieNo
     * @param cp
     * @return amp
     * @throws Exception
     */
    public Map<String, Object> selectComentList(int movieNo, int cp) throws Exception{
        
        Connection conn = getConnection();
        Comment Coment = new Comment();
        // 영화 이름 조회 DAO
        String movieTitle = dao.selectMovieTitle(conn, movieNo);
        // 특정 영화 코멘트 수 조회 DAO
        int comentCount = dao.getcomentCount(conn, movieNo);
        // 코멘트 수 + 현재 페이지(CP)를 이용해서 페이지네이션 객체 생성
        Pagination pagination = new Pagination(cp, comentCount);
        // 게시글 목록 조회
        List<Comment> comentList = dao.selectComentList(conn, pagination, movieNo);
        // Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("movieTitle", movieTitle);
        map.put("pagination", pagination);
        map.put("boardList", comentList);
        
        close(conn);
        
        
        return map; // Map 반환
    }
    

}