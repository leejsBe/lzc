package kr.co.lzc.domain.repository;


import kr.co.lzc.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {


  @Query("SELECT e FROM Employee e WHERE e.delAt IS NULL")
  List<Employee> findAll();


  @Query("SELECT e FROM Employee e WHERE e.id IN(:ids)")
  List<Employee> findAllById(@Param("ids") List<Long> ids);


  Optional<Employee> findByNo(String no);

}
