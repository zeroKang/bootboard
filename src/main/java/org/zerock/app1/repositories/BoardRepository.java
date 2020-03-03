package org.zerock.app1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.app1.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
