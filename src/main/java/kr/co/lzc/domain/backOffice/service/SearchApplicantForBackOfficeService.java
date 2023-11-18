package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchApplicant.SearchApplicantForBackOfficeRes;
import kr.co.lzc.domain.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchApplicantForBackOfficeService {

  private final EmployeeRepo employeeRepo;

  public List<SearchApplicantForBackOfficeRes> search() {
    return null;
  }
}
