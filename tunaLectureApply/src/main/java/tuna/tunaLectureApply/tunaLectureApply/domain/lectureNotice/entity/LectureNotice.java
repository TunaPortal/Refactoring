package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lecturenotice")
public class LectureNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String content;
    private String title;

    @ManyToOne
    @JoinColumn(name = "sbjno", referencedColumnName = "no")
    private SubjectEntity subjectEntity;

    @Column(name = "sbjno", insertable = false, updatable = false) // 컬럼 중복 해결
    private int sbjno;


    
    // 테스트 코드에서 사용할 거
    public LectureNotice() {
    }

    public LectureNotice(Long no, String content, String title) {
        this.no = no;
        this.content = content;
        this.title = title;
    }
    
}
