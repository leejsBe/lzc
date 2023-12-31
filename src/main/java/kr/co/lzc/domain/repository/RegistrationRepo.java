package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepo extends CrudRepository<Registration, Long> {


  @Query("SELECT r FROM Registration r JOIN FETCH r.lecture")
  List<Registration> findAll();


  @Query("SELECT r FROM Registration r JOIN FETCH r.lecture l JOIN FETCH l.lectureHall lh WHERE r.employee.no = :employeeNo AND r.duplicateCheck = concat(r.lecture.id , '_', r.employee.id)")
  List<Registration> findByEmployeeNo(@Param("employeeNo") String employeeNo);

  @Query("SELECT COUNT(r) FROM Registration r WHERE r.delAt IS NULL AND r.lecture.id = :lectureId")
  int countByLectureIdAndDelAtIsNull(@Param("lectureId") long lectureId);


  @Query(nativeQuery = true, value = "SELECT r.* FROM registration r WHERE r.del_at IS NULL AND :afterPointTime < r.create_at")
  List<Registration> findByAfterPointTime(@Param("afterPointTime") String afterPointTime);
}
