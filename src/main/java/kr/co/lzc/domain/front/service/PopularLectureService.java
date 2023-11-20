package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.Registration;
import kr.co.lzc.domain.front.dto.popularLecture.PopularLectureRes;
import kr.co.lzc.domain.repository.LectureRepo;
import kr.co.lzc.domain.repository.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PopularLectureService {

  private final RegistrationRepo registrationRepo;
  private final LectureRepo lectureRepo;


  /**
   * 3일간 인기가 가장 많은 순서로 강연 리스트 조회
   */
  public List<PopularLectureRes> search() {
    List<Registration> registrations = registrationRepo.findByAfterPointTime(LocalDateTime.now().minusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    Map<Long, Long> lectureListMap = registrations.stream().collect(Collectors.groupingBy(registration -> registration.getLecture().getId(), Collectors.counting()));

    Map<Long, Lecture> lectureMap = lectureRepo.findAllByIds(lectureListMap.keySet().stream().toList()).stream().collect(Collectors.toMap(Lecture::getId, Function.identity()));

    /// 신청 많은 순서로 정렬
    List<Long> keySet = new ArrayList<>(lectureListMap.keySet());
    keySet.sort((o1, o2) -> lectureListMap.get(o2).compareTo(lectureListMap.get(o1)));

    return keySet.stream().map(lectureId -> new PopularLectureRes(lectureMap.get(lectureId), lectureListMap.get(lectureId))).toList();
  }

}
