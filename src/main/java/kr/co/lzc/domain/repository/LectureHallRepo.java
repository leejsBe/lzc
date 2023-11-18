package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.LectureHall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureHallRepo extends CrudRepository<LectureHall, Long> {


}
