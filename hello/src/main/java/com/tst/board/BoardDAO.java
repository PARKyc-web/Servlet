package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO{
	
	
	// 등록
	public void insertBoard(BoardVO vo) {
		
		String sql = "INSERT INTO board VALUES((SELECT nvl(max(board_id), 0)+1 FROM board), ?, ?, ?, sysdate, 0)";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료.");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		
	}
	
	
	// 목록
	public List<BoardVO> boardList(){
		
		List<BoardVO> list = new ArrayList<>();
		String sql = "SELECT * FROM board order by 1";	
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();			
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setBoardId(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("createDate"));
				vo.setCnt(rs.getInt("cnt"));
	
				list.add(vo);
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		
		return list;
	}
	
	public BoardVO getBoard(int boardNo) {
				
		String sql = "SELECT * FROM board WHERE board_id = ? order by 1";	
		BoardVO vo = new BoardVO();
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
			
			rs = pstmt.executeQuery();						
			if(rs.next()) {
				vo.setBoardId(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("createDate"));
				vo.setCnt(rs.getInt("cnt"));
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
			setCnt(boardNo);
		}
		
		return vo;
	}
	
	public void setCnt(int boardNo) {
		
		String sql = "UPDATE board SET cnt=cnt+1 WHERE board_id = ?";
		
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			int result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}		
	}
	
	//글 내용 수정
	public void updateBoard(BoardVO vo) {
		
		String sql = "UPDATE Board SET title =?, content=? WHERE board_id =?";
		
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			
			int result = pstmt.executeUpdate();			
			System.out.println(vo.getBoardId() + "번 게시글을 수정하였습니다");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
	}
	
	public void deleteBoard(int boardNo) {
		
		String sql = "DELETE FROM Board WHERE board_id =?";
		
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			
			int result = pstmt.executeUpdate();			
			System.out.println(boardNo + "번 게시글을 삭제하였습니다");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
	}
	
	public UserVO loginCheck(String id, String passwd) {
		
		UserVO vo = null;
		String sql = "SELECT * FROM users WHERE id= ? and passwd= ?";
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		
		return vo;
	}
	
}
