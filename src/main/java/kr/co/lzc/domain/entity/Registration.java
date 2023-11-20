package kr.co.lzc.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "registration",
  uniqueConstraints = {
    @UniqueConstraint(name = "constraintName", columnNames = {"lecture_id", "employee_id", "duplicate_check"})
  })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Registration {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;


  @ManyToOne(fetch = FetchType.LAZY)
  private Lecture lecture;

  @ManyToOne(fetch = FetchType.LAZY)
  private Employee employee;


  @Column(name = "duplicate_check")
  private String duplicateCheck;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime modAt;

  private LocalDateTime delAt;


  public void changeForCancel() {
    this.duplicateCheck = this.duplicateCheck + "_" + this.id;
    this.modAt = LocalDateTime.now();
    this.delAt = LocalDateTime.now();
  }
}
