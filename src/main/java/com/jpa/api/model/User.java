package com.jpa.api.model;

import lombok.*;
import javax.persistence.*;

@Entity                 //jpa entity 로 선언
@Table(name="tb_member")    //table 정보
@Getter
@NoArgsConstructor      //인자 없는 기본 생성자
@AllArgsConstructor     //모든 인자 가지는 생성자
@Builder                //빌더 패턴으로 생성하게 해줌.
public class User {
    @Id     //pk 필드. 반드시 필요,
    @Column(name="userNo", nullable = false)    //테이블 컬럼과 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(unique =  true, nullable = false, length = 30)
    private String userId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 10)
    private String name;
}
