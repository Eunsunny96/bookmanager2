package com.fastcampus.jpa.bookmanager.domain;


import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity //해당객체가 jpa에서 관리고 있는 객체인것을 확인
@EntityListeners(value = { UserEntityListener.class})
@ToString(callSuper = true) //toString 재정의
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Auditable {
    @Id //레코드를 유일하게 식별할수 있는 키 = primary key
    @GeneratedValue
    private Long id; //long type 의 값은 개발자가 set 해주는게 아니고 지정을 해줌

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//    @Transient
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

//    @PrePersist
//    public void perPersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void PreUpdate(){
//        this.updatedAt = LocalDateTime.now();
//
//    }


}