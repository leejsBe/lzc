package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepo extends CrudRepository<Registration, Long> {


  @Query("SELECT r FROM Registration r JOIN FETCH r.lecture")
  List<Registration> findAll();

}
