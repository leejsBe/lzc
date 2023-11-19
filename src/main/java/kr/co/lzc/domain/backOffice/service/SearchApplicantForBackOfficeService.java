package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchApplicant.SearchApplicantForBackOfficeRes;
import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.Registration;
import kr.co.lzc.domain.repository.EmployeeRepo;
import kr.co.lzc.domain.repository.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchApplicantForBackOfficeService {

  private final RegistrationRepo registrationRepo;
  private final EmployeeRepo employeeRepo;

  public List<SearchApplicantForBackOfficeRes> search() {
    List<Registration> registrations = registrationRepo.findAll();
    Map<Long, Employee> employeeMap = getEmployeeInfo(registrations);

    Map<Lecture, List<Long>> list = registrations.stream()
      .collect(Collectors.groupingBy(Registration::getLecture, Collectors.mapping(registration -> registration.getEmployee().getId(), Collectors.toList())));

    return list.keySet().stream().map(lecture -> new SearchApplicantForBackOfficeRes(lecture, list.get(lecture), employeeMap)).toList();
  }


  /**
   * 사원 정보 조회
   */
  private Map<Long, Employee> getEmployeeInfo(List<Registration> registrations) {
    return employeeRepo.findAllById(registrations.stream()
      .map(r -> r.getEmployee().getId()).toList()).stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
  }
}
