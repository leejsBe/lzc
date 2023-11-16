package kr.co.lzc.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "lecture")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "lecturer")
  private String lecturer;

  @Column(name = "max_applicant")
  private int maxApplicant;

  @Column(name = "time")
  private LocalDateTime localDateTime;

  @Column(name = "contents")
  private String contents;



  @ManyToOne(fetch = FetchType.LAZY)
  private LectureHall lectureHall;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime modAt;

  private LocalDateTime delAt;

}
