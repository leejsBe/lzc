package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepo extends CrudRepository<Lecture, Long> {


  @Query("SELECT l FROM Lecture l JOIN FETCH l.lectureHall")
  List<Lecture> findAll();

}