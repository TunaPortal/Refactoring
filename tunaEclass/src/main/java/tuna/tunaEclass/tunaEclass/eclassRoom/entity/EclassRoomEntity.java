package tuna.tunaEclass.tunaEclass.eclassRoom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "room_cd")
public class EclassRoomEntity {

    @Id
    @Column(name = "room_cd_id", length = 36)
    private String roomCdId;

    @Column(nullable = false, length = 100)
    private String roomNm; // 강의실명

    @Column(nullable = false)
    private int hdcnt; // 정원, headCount

    @Column(length = 1, columnDefinition = "varchar (1) default 'N'")
    private String useYn; // 사용여부

    /* 기본 생성자 추가 */
    public EclassRoomEntity() {
    }

    /* 초기화용 생성자 */
    public EclassRoomEntity(String roomCdId) {
        this.roomCdId = roomCdId;
    }

    /* @Builder = 생성자 자동 생성 */
    @Builder
    public EclassRoomEntity(String roomCdId, String roomNm, int hdcnt, String useYn) {
        this.roomCdId = roomCdId;
        this.roomNm = roomNm;
        this.hdcnt = hdcnt;
        this.useYn = useYn;
    }

}
