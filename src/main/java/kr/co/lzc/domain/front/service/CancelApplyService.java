package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Registration;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyReq;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyRes;
import kr.co.lzc.domain.front.enumeration.FrontResCode;
import kr.co.lzc.domain.front.exception.FrontException;
import kr.co.lzc.domain.repository.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelApplyService {

  private final RegistrationRepo registrationRepo;


  @Transactional
  public CancelApplyRes cancel(CancelApplyReq cancelApplyReq) {
    Registration registration = registrationRepo.findById(cancelApplyReq.getBookNo()).orElseThrow(() -> new FrontException(FrontResCode.NOT_FOUND_REGISTRATION));

    registration.changeForCancel();

    return CancelApplyRes.builder().bookNo(registration.getId()).build();
  }

}
