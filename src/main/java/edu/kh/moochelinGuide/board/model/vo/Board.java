package edu.kh.moochelinGuide.board.model.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {
	private int boardNo;
	private String boardTit;
	private String content;
	private Date createDate;
	private Date updateDate;
	private int readCount;
	private String boardSt;
	private int memberNo;
	private int boardCode;
	private String memberNm;
	private long dateCalcul;
	private String msg;
	private String msg2;
}