package org.zerock.dao;

import com.sun.tools.javac.comp.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void setUp() {
        // Initialize TodoDAO here if needed.
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() {
        try {
            String time = todoDAO.getTime2();
            System.out.println(time);
            assertNotNull(time, "Result should not be null");
            // You can add further assertions based on your expectations.
            // For example, you can check if the time string has a specific format.
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public  void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("sample title")
                .dueDate(LocalDate.of(2023,9,1))
                .build();
        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws  Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public  void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);
    }
    @Test
    public void deleteOne() throws Exception {
        Long tno = 5L;
         todoDAO.deleteOne(tno);
    }

    @Test
    public  void  testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(5L)
                .title("sample title")
                .dueDate(LocalDate.of(2023,8,24))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }
}
