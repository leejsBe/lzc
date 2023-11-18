package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchApplicant.SearchApplicantForBackOfficeRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SearchApplicantForBackOfficeServiceTest {


  @Autowired
  public SearchApplicantForBackOfficeService searchApplicantForBackOfficeService;


  @Test
  @DisplayName("강연 신청자 목록 정상 조회")
  void success() {
    List<SearchApplicantForBackOfficeRes> result = searchApplicantForBackOfficeService.search();

    assertNotNull(result);

    result.forEach(SearchApplicantForBackOfficeRes::toString);
  }

}