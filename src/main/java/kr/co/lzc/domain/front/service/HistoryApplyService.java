package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyReq;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyRes;
import kr.co.lzc.domain.front.enumeration.FrontResCode;
import kr.co.lzc.domain.front.exception.FrontException;
import kr.co.lzc.domain.repository.EmployeeRepo;
import kr.co.lzc.domain.repository.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryApplyService {

  private final RegistrationRepo registrationRepo;
  private final EmployeeRepo employeeRepo;


  public List<HistoryApplyRes> search(HistoryApplyReq historyApplyReq) {
    Employee employee = employeeRepo.findByNo(historyApplyReq.getEmployeeNo()).orElseThrow(() -> new FrontException(FrontResCode.NOT_FOUND_EMPLOYEE));
    return registrationRepo.findByEmployeeNo(historyApplyReq.getEmployeeNo()).stream().map(history -> new HistoryApplyRes(history, employee)).toList();
  }

}