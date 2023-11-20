package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRepo extends CrudRepository<Lecture, Long> {


  @Query("SELECT l FROM Lecture l JOIN FETCH l.lectureHall")
  List<Lecture> findAll();


  @Query(nativeQuery = true, value = "SELECT l.* FROM lecture l join lecture_hall lh on l.lecture_hall_id = lh.id " +
    "WHERE l.del_at IS NULL AND lh.del_at IS NULL AND :aWeekAgo > l.time AND :aDayPasses < l.time")
  List<Lecture> findAllByTime(@Param("aWeekAgo") String aWeekAgo, @Param("aDayPasses") String aDayPasses);


  @Query("SELECT l FROM Lecture l JOIN FETCH l.lectureHall lh WHERE l.id IN(:ids)")
  List<Lecture> findAllByIds(@Param("ids") List<Long> ids);
}
