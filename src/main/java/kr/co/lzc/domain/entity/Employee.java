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
@Table(name = "employee", catalog = "lzc")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "no", unique = true)
  private String no;

  @Column(name = "name")
  private String name;


  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime modAt;

  private LocalDateTime delAt;

}
