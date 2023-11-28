package tuna.tunaEclass.tunaEclass.eclassRoom.dto;

import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;

public class EclassRoomEntityBuilder {


    public static EclassRoomEntity buildFromDTO(EclassRoomDTO eclassRoomDTO) { // DTO -> Entity 변환
        return EclassRoomEntity.builder() // builder을 이용하여 entity 객체 생성
                .roomCdId(eclassRoomDTO.getRoomCdId())
                .roomNm(eclassRoomDTO.getRoomNm())
                .hdcnt(eclassRoomDTO.getHdcnt())
                .useYn(eclassRoomDTO.getUseYn())
                .build();
    }

    /* EclassRoom Insert roomCdId 자동 증가용 */
    public static EclassRoomEntity buildNewId(String newRoomCdId, EclassRoomDTO eclassRoomDTO) { // DTO -> Entity 변환
        return EclassRoomEntity.builder() // builder을 이용하여 entity 객체 생성
                .roomCdId(newRoomCdId)
                .roomNm(eclassRoomDTO.getRoomNm())
                .hdcnt(eclassRoomDTO.getHdcnt())
                .useYn(eclassRoomDTO.getUseYn())
                .build();
    }

}
