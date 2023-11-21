package tuna.tunaEclass.tunaEclass.eclassRoom.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tuna.tunaEclass.tunaEclass.eclassRoom.dto.EclassRoomDTO;
import tuna.tunaEclass.tunaEclass.eclassRoom.dto.EclassRoomEntityBuilder;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;
import tuna.tunaEclass.tunaEclass.eclassRoom.repository.EclassRoomRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // final을 가진 생성자 자동 생성
public class EclassRoomService {

    private final EclassRoomRepository eclassRoomRepository;

    /* Test Class 생성 단축키 : Ctrl + Shift + T */
    /* 전체 조회, 단건 조회 = Entity -> DTO 변환
    *  등록, 수정 = DTO -> Entity 변환
    *  클라이언트 -> DB인지, DB -> 클라이언트인지 생각하면 됨 */

    /* 전체 조회 */
    public List<EclassRoomEntity> getAllEclassRooms() {

        /* Repository에 find.All()을 사용하여 모든 강의실 정보를 DB에서 가져온다.
        *  조회된 강의실 정보를 리스트로 반환한다.*/
        return eclassRoomRepository.findAll(); // findAll() = 전체 조회
    }
    
    /* 단건 조회 */
    public EclassRoomDTO getEclassRoom(String roomCdCi) {

        // roomCdCi에 맞는 강의실 정보를 가져온다. 해당되는 강의실이 없으면 예외 발생
        EclassRoomEntity entity = eclassRoomRepository.findById(roomCdCi) // findById(roomCdCi) = roomCdCi를 이용하여 단건 조회
                .orElseThrow(() -> new EntityNotFoundException("roomCdCi not found ! : " + roomCdCi)); // roomCdCi가 없으면 예외

        return EclassRoomDTO.toDTO(entity); // entity를 DTO로 변환하여 반환
    }
    
    /* 등록 */
    public EclassRoomDTO createEclassRoom(EclassRoomDTO eclassRoomDTO) {
        // Repository에서 JPQL 가져오기
        Integer maxNumericValue = eclassRoomRepository.findMaxNumericValue();

        // 현재 roomCdCI이 null이면 초기값으로 0 설정
        if (maxNumericValue == null) {
            maxNumericValue = 0;
        }

        // 현재 최대값에서 1을 더하여 새로운 roomCdId 생성 | MA-1 -> MA-2 ...
        int newNumericValue = maxNumericValue + 1;
        String newRoomCdId = "MA-" + newNumericValue;

        // newRoomCdId, DTO를 roomEntity에 담고 저장
        EclassRoomEntity roomEntity = EclassRoomEntityBuilder.buildNewId(newRoomCdId, eclassRoomDTO); // 객체 생성

        // roomEntity를 DB에 저장하고, 저장된 Entity를 savedEntity에 반환
        EclassRoomEntity savedEntity = eclassRoomRepository.save(roomEntity); // save = 엔티티가 있으면 수정, 없으면 등록

        return EclassRoomDTO.toDTO(savedEntity); // Entity -> DTO 변환하여 반환
    }

    /* 수정 */
    public EclassRoomDTO updateEclassRoom(String roomCdCi, EclassRoomDTO eclassRoomDTO) {
        
        /* 강의실 코드로 강의실을 조회한다, 해당 코드가 없으면 예외 발생 */
        EclassRoomEntity existingEntity = eclassRoomRepository.findById(roomCdCi)
                .orElseThrow(() -> new EntityNotFoundException("roomCdCi not found ! : " + roomCdCi));

        // DTO를 Entity로 변환
        EclassRoomEntity updatedEntity = EclassRoomEntityBuilder.buildFromDTO(eclassRoomDTO);

        // Entity 식별자를 설정
        updatedEntity.setRoomCdId(existingEntity.getRoomCdId());

        // 수정된 Entity를 DB에 저장하고, updatedEntity에 다시 할당
        updatedEntity = eclassRoomRepository.save(updatedEntity);

        return EclassRoomDTO.toDTO(updatedEntity); // Entity -> DTO 변환하여 반환
    }
    
    /* 삭제 */
    public void deleteEclassRoom(String roomCdCi) {
        /* 강의실 코드로 강의실을 조회한다, 해당 코드가 없으면 예외 발생 */
        EclassRoomEntity existingEntity = eclassRoomRepository.findById(roomCdCi) // findById(roomCdCi) = roomCdCi를 이용하여 조회
                .orElseThrow(() -> new EntityNotFoundException("roomCdCi not found ! : " + roomCdCi)); // roomCdCi가 없으면 예외

        // 엔터티 삭제
        eclassRoomRepository.delete(existingEntity); // .delete = 삭제
    }


}
