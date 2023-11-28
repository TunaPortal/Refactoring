package tuna.tunaEclass.tunaEclass.eclassRoom.dto;

import lombok.*;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;

@Data // @Data = @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class EclassRoomDTO {

    private String roomCdId; // 강의실 코드
    private String roomNm;   // 강의실명
    private int hdcnt;        // 정원
    private String useYn;     // 사용여부

    // 기본 생성자
    public EclassRoomDTO() {
    }

   /* public EclassRoomDTO(String roomCdId, String roomNm, int hdcnt, String useYn) {
    }*/

    public EclassRoomDTO(String roomCdId, String roomNm, int hdcnt, String useYn) {
        this.roomCdId = roomCdId;
        this.roomNm = roomNm;
        this.hdcnt = hdcnt;
        this.useYn = useYn;
    }

    /* ex) DB에서 조회할 때 강의실 정보를 Entity 객체에 담아오고, DTO로 변환하여 클라이언트에게 전달 */
    public static EclassRoomDTO toDTO(EclassRoomEntity entity) { // Entity -> DTO 변환
        EclassRoomDTO dto = new EclassRoomDTO(); // DTO 객체 생성
        dto.setRoomCdId(entity.getRoomCdId());
        dto.setRoomNm(entity.getRoomNm());
        dto.setHdcnt(entity.getHdcnt());
        dto.setUseYn(entity.getUseYn());
        return dto;
    }
}
