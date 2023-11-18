package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {


  @Query("SELECT e FROM Employee e WHERE e.id IN(:ids)")
  List<Employee> findAllById(@Param("ids") List<Long> ids);

}
