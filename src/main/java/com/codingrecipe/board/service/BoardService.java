package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        // BoardEntity에서 DTO를 Entity로 바꿔서 전달
        BoardEntity saveEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(saveEntity); //매개변수를 entity로 받게 되어있고 return도 entity로 주게 됨
    }

    public List<BoardDTO> findAll() {
        // Entity로 객체를 받아와서 다시 컨트롤러로 줄때는 DTO로 바꿔서 줘야함
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        // entity객체에 담고 담은 entity객체를 DTO로 담는다
        for (BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }

        return boardDTOList;
    }
}
