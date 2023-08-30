package com.example.b01.service;

import com.example.b01.dto.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

//    @Test
//    public void testRegister(){
//        log.info(boardService.getClass().getName());
//        BoardDTO boardDTO =BoardDTO.builder()
//                .title("smaple title")
//                .content("sample content")
//                .writer("user00")
//                .build();
//        Long bno = boardService.register(boardDTO);
//        log.info("bno:"+bno);
//    }
//    @Test
//    public  void testModify(){
//        BoardDTO boardDTO = BoardDTO.builder()
//                .bno(101l)
//                .title("updated 101")
//                .content("updated content 101")
//                .build();
//        boardService.modify(boardDTO);
//    }
//    @Test
//    public void testList(){
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .type("tcw")
//                .keyword("1")
//                .page(1)
//                .size(10)
//                .build();
//
//        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
//        log.info(responseDTO);
//    }

//    @Test
//    public void testRegisterWithImages(){
//        log.info(boardService.getClass().getName());
//
//        BoardDTO boardDTO = BoardDTO.builder()
//                .title("file...sample title")
//                .content("sample content....")
//                .writer("user00")
//                .build();
//
//        boardDTO.setFileNames(
//                Arrays.asList(
//                        UUID.randomUUID()+"_aaa.jpg",
//                        UUID.randomUUID()+"_bbb.jpg",
//                        UUID.randomUUID()+"_bbb.jpg"
//                )
//        );
//        Long bno =boardService.register(boardDTO);
//        log.info("bno" +bno);
//    }
//    @Test
//    public void testReadAll(){
//        Long bno = 100L;
//        BoardDTO boardDTO = boardService.readOne(bno);
//        log.info(boardDTO);
//
//        for(String fileName :boardDTO.getFileNames()){
//            log.info(fileName);
//        }//end for
//    }

//    @Test
//    public void testModify(){
//        BoardDTO boardDTO = BoardDTO.builder()
//                .bno(100L)
//                .title("Updated ...100")
//                .content("Updated content 100")
//                .build();
//        boardDTO.setFileNames(Arrays.asList(UUID.randomUUID()+"_zzz.jpg"));
//        boardService.modify(boardDTO);
//    }
    @Test
    public void testListWithAll(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        PageResponseDTO<BoardListAllDTO> responseDTO = boardService.listWithAll(pageRequestDTO);
        List<BoardListAllDTO> dtoList =responseDTO.getDtoList();
        dtoList.forEach(boardListAllDTO -> {
            log.info(boardListAllDTO.getBno()+":"+boardListAllDTO.getTitle());

            if(boardListAllDTO.getBoardImages()!=null){
                for(BoardImageDTO boardImage:boardListAllDTO.getBoardImages()){
                    log.info(boardImage);
                }
            }
            log.info("-------------------------------");
        });
    }
}
