package org.zerock.app1;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.zerock.app1.domain.Board;
import org.zerock.app1.repositories.BoardRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepoTests {

    @Autowired
    private BoardRepository repository;

    @Test
    public void test1(){
        log.info("test1..........................");
        log.info("test1..........................");
        log.info("test1..........................");

    }

    @Test
    public void testInsertDummies() {

        IntStream.range(1,101).forEach(i -> {

            Board board = Board.builder().title("title.."+i).content("content.." + i).writer("user00").build();

            repository.save(board);
        });
    }

    @Test
    public void testReadOne() {

        Optional<Board> result = repository.findById(50L);

        log.info("==================================");
        log.info(result);

        result.ifPresent(board -> log.info(board));

    }

    @Test
    public void testReadByPagingAsc() {

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<Board> result = repository.findAll(pageRequest);

        result.forEach(board -> {
            log.info(board);
        });
    }

    @Test
    public void testReadByPagingDese() {

        PageRequest pageRequest = PageRequest.of(0, 10,  Sort.Direction.DESC, "num");

        Page<Board> result = repository.findAll(pageRequest);

        result.forEach(board -> {
            log.info(board);
        });
    }
}
