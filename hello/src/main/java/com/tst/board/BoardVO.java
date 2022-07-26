package com.tst.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVO {

	private int boardId;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int cnt;
	
	
	
}
