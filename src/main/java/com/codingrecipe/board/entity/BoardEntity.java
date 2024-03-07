package com.codingrecipe.board.entity;

import com.codingrecipe.board.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//DB의 테이블 역할을 하는 클래스, service와 repository에서 사용
@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id //pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increament
    private Long id;

    @Column(length = 20, nullable = false) //크기는 20, not null
    private String boardWriter;

    @Column // 크기 255, null 가능
    private String boardPsss;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    // entity를 dto로 변환
    // save에서 넘겨준 boardDTO를 Entity로 옮겨 담는 작업
    // 여기서 옮겨담아도 되고 service에서 옮겨담아도 무관
    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPsss(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }

}
