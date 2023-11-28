package tuna.tunaEclass.tunaEclass.eclassUser.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
public class EclassUserEntity {

    @Id
    @Column(name = "user_sn", length = 36)
    private String userSn; // 사용자 일련번호, PK

    @Column(nullable = false, unique = true, length = 30) // not null, unique
    private String userId; // 사용자 아이디

    @Column(nullable = false, length = 30) // not null
    private String userPw; // 사용자 비밀번호

    @Column(length = 30)
    private String imgAtchflSn; //사용자 사진

    @Column(nullable = false, length = 100) // not null
    private String userNm; // 사용자명

    @Column(nullable = false, length = 100) // not null
    private String email; // 사용자 이메일

    @Column(nullable = false, length = 50) // not null
    private String telSn; // 사용자 전화번호

    @Column(nullable = false, length = 10) // not null
    private String postSn; // 사용자 우편번호

    @Column(nullable = false, length = 100) // not null
    private String addr; // 사용자 주소

    @Column(length = 100)
    private String dtlAddr; // 사용자 상세주소

    @Column(nullable = false) // not null
    private Date inDe; // 입학/입사일

    //@ColumnDefault("'N'") // 기본값 N, create 할 때 기본값 적용
    @Column(length = 1, columnDefinition = "varchar (1) default 'N'")
    private String outYn; // 졸업/퇴사 여부

    @Column
    private Date outDe; // 졸업/퇴사일

    @Column(nullable = false, length = 10) // not null
    private String userDivCd; // 사용자 구분 코드 : 학생/교직원

    @Column(nullable = false, length = 10) // not null
    private String userDtlDivCd; // 사용자 세부 구분 코드 : 학년/부서

    @Column(nullable = false, length = 10) // not null
    private String userSttsCd; // 사용자 상태 코드 : 재학, 휴학, 퇴학, 졸업 / 재직, 휴직, 퇴사

    @Column(length = 10) // not null
    private String deptCd; // 학과코드

    @Column(length = 10) // not null
    private String bankCd; // 은행코드 : 교직원용

    @Column(length = 50) // not null
    private String acntNo; // 계좌번호 : 교직원용

    @Column
    private Date fnlLgnDt; // 최종 로그인 일시

    @ColumnDefault("0") // 기본값 0, create 할 때 기본값 적용
    private int pwErrCnt; // 비밀번호 오류 수

    @Temporal(TemporalType.DATE)
    @ColumnDefault("'9999-12-31'") // 기본값 9999-12-31, create 할 때 기본값 적용
    private Date pwMdfyDt; // 비밀번호 수정 일시

    @Column(nullable = false, length = 30) // not null
    private String rgstUserSn; // 최초 등록 사용자 일련번호

    @CreationTimestamp // 생성 시간
    @Column(updatable = false) // 업데이트 할 때 관여 안함
    private LocalDateTime rgstDt; // 최초 등록 일시

    @Column(nullable = false, length = 30) // not null
    private String mdfyUserSn; // 최종 수정 사용자 일련번호

    @UpdateTimestamp // 수정 시간
    @Column(insertable = false) // 생성 할 때 관여 안함
    private LocalDateTime mdfyDt; // 최종 수정 일시
/*
    @ManyToOne
    @JoinColumn(name = "sbjno", referencedColumnName = "no")
    private SubjectEntity subjectEntity;

    @Column(name = "sbjno", insertable = false, updatable = false) // 컬럼 중복 해결
    private int sbjno;
*/

    

    
}
