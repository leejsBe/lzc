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
@Table(name = "registration")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;


  @ManyToOne(fetch = FetchType.LAZY)
  private Lecture lecture;

  @ManyToOne(fetch = FetchType.LAZY)
  private Employee employee;


  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime modAt;

  private LocalDateTime delAt;

}
