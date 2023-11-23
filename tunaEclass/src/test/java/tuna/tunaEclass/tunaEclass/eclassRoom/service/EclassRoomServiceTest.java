package tuna.tunaEclass.tunaEclass.eclassRoom.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tuna.tunaEclass.tunaEclass.eclassRoom.dto.EclassRoomDTO;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;
import tuna.tunaEclass.tunaEclass.eclassRoom.repository.EclassRoomRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Mockito 설정 어노테이션 | LENIENT = 유연한, STRICT = 엄격한
@MockitoSettings(strictness = Strictness.LENIENT)
// JUnit5와 Mockito를 함께 사용하는 어노테이션 | MockitoExtension = Mockito 관련 설정 활성화
@ExtendWith(MockitoExtension.class)
class EclassRoomServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(EclassRoomServiceTest.class);

    // EclassRoomRepository에 대한 Mock 객체 생성, Test에서 사용될 실제 Repository 대신 사용될 구라 객체
    @Mock
    private EclassRoomRepository eclassRoomRepository;

    // EclassRoomService에 Mock 객체를 자동 주입
    @InjectMocks
    private EclassRoomService eclassRoomService;


    /* 전체 조회 */
    @DisplayName("[GET] 전체 조회")
    @Test
    void testGetAllEclassRooms() {
        /* given : 상황 설정, 가짜 데이터 생성 */
        EclassRoomEntity room1 = new EclassRoomEntity("MA-1", "강의실1", 30, "Y");
        EclassRoomEntity room2 = new EclassRoomEntity("MA-2", "강의실2", 25, "N");

        /* when : 동작 */
        List<EclassRoomEntity> mockRoomList = Arrays.asList(room1, room2);

        /*
        * Mock Repository의 동작 설정
        * 테스트에서 eclassRoomService.getAllEclassRooms()가 호출될 때
        * 실제 Repository 대신 mockRoomList가 반환하도록 만들어줌
        */
        when(eclassRoomRepository.findAll()).thenReturn(mockRoomList);

        // 서비스 호출
        List<EclassRoomEntity> result = eclassRoomService.getAllEclassRooms();

        /* then : 결과 검증 */
        assertAll("전체 조회 확인",
                () -> assertEquals(2, result.size(), "리스트 크기 불일치 !"),

                () -> assertAll("첫번째 강의실 확인",
                        () -> assertEquals("MA-1", result.get(0).getRoomCdId(), "첫 번째 강의실 코드 불일치 !"),
                        () -> assertEquals("강의실1", result.get(0).getRoomNm(), "첫 번째 강의실 이름 불일치 !"),
                        () -> assertEquals(30, result.get(0).getHdcnt(), "첫 번째 강의실 정원 불일치 !"),
                        () -> assertEquals("Y", result.get(0).getUseYn(), "첫 번째 강의실 사용 여부 불일치 !")
                ),

                () -> assertAll("두 번째 강의실 확인",
                        () -> assertEquals("MA-2", result.get(1).getRoomCdId(), "두 번째 강의실 코드 불일치 !"),
                        () -> assertEquals("강의실2", result.get(1).getRoomNm(), "두 번째 강의실 이름 불일치 !"),
                        () -> assertEquals(25, result.get(1).getHdcnt(), "두 번째 강의실 정원 불일치 !"),
                        () -> assertEquals("N", result.get(1).getUseYn(), "두 번째 강의실 사용 여부 불일치 !")
                )
        );

        for (EclassRoomEntity roomEntity : result) {
            logger.info("리스트 : {}", roomEntity);
        }
    }

    /* 단건 조회 */
    @DisplayName("[GET] 단건 조회")
    @Test
    void getEclassRoom() {
        /* given : 상황 설정, mockRoom이라는 가짜 데이터 생성 */
        String roomCdId = "MA-1";
        EclassRoomEntity mockRoom = new EclassRoomEntity(roomCdId, "강의실1", 30, "Y");

        /* when : 동작
        * 실제 Repository 대신에 mockRoom 반환
        * Optional = 값이 있을수도 있고 없을수도 있고, null을 반환하지 않고 값이 없음을 나타낼 수 있다.
        * Optional.of = 이 값은 null이 아니어야 함, null이면 NullPointerException 발생
        */
        when(eclassRoomRepository.findById(roomCdId)).thenReturn(Optional.of(mockRoom));

        // 서비스 호출
        EclassRoomDTO result = eclassRoomService.getEclassRoom(roomCdId);

        /* then : 결과 검증 */
        assertAll("단건 조회 결과 확인",
                () -> assertNotNull(result),
                () -> assertEquals(roomCdId, result.getRoomCdId(), "강의실 코드 불일치 !"),
                () -> assertEquals("강의실1", result.getRoomNm(), "강의실 이름 불일치 !"),
                () -> assertEquals(30, result.getHdcnt(), "수용 인원 불일치 !"),
                () -> assertEquals("Y", result.getUseYn(), "사용 여부 불일치 !")
        );

        logger.info("단건 조회 : {}", result);
    }

    /* 등록 */
    @DisplayName("[POST] 강의실 등록")
    @Test
    void CreateEclassRoom() {
        // Mock 데이터 설정, 가짜 데이터 생성
        EclassRoomDTO requestDTO = new EclassRoomDTO("MA-1", "강의실", 25, "N");

        // Mock Repository의 동작 설정
        // eclassRoomRepository.findMaxNumericValue()가 호출될 때 현재 최대값을 1로 설정, 등록된 강의실 코드의 최대값을 나타냄
        when(eclassRoomRepository.findMaxNumericValue()).thenReturn(1);

        // save 메서드가 호출될 때 사용할 Mock 엔터티 생성
        EclassRoomEntity savedEntity = new EclassRoomEntity("MA-1", "강의실", 25, "N");

        // save 메서드가 호출되면 savedEntity를 반환하도록 설정
        when(eclassRoomRepository.save(any())).thenReturn(savedEntity);

        // 테스트 수행
        // 실제 코드 public EclassRoomDTO createEclassRoom(EclassRoomDTO eclassRoomDTO)에 해당함
        EclassRoomDTO resultDTO = eclassRoomService.createEclassRoom(requestDTO);

        // 결과 검증
        assertAll("등록 결과 확인",
                () -> assertNotNull(resultDTO),
                () -> assertEquals("MA-1", resultDTO.getRoomCdId(), "강의실 코드 불일치 !"),
                () -> assertEquals("강의실", resultDTO.getRoomNm(), "강의실 이름 불일치 !"),
                () -> assertEquals(25, resultDTO.getHdcnt(), "수용 인원 불일치 !"),
                () -> assertEquals("N", resultDTO.getUseYn(), "사용 여부 불일치 !")
        );

        // save 메서드가 1번 호출되었는지 확인
        verify(eclassRoomRepository, times(1)).save(any());

        logger.info("등록 : {}", resultDTO);
    }




    /* 수정 */
    @Test
    @DisplayName("[PUT] 강의실 수정")
    void UpdateEclassRoom() {
        // 주어진 상황 설정
        String roomCdCi = "MA-1"; // 수정할 강의실의 코드 ID

        // 기존 강의실 데이터
        EclassRoomEntity existingEntity = new EclassRoomEntity("MA-1", "Existing Room", 30, "N"); // 기존의 강의실 엔터티

        // 수정할 강의실 데이터
        EclassRoomDTO updatedDTO = new EclassRoomDTO("MA-1", "Updated Room", 50, "Y"); // 업데이트할 정보가 담긴 DTO

        // findById 메서드가 호출될 때 기존 데이터를 반환하도록 Mock 객체 설정
        when(eclassRoomRepository.findById(roomCdCi)).thenReturn(Optional.of(existingEntity));

        /* save 메서드가 호출될 때 업데이트된 데이터를 반환하도록 Mock 객체 설정
        * thenAnswer = 메서드 호출에 대한 응답을 제공하는 방법 정의
        * invocation = 메소드 호출 정보
        * invocation.getArgument(0) = 메서드 호출에서 첫 번째 인자를 반환 | EclassRoomEntity를 반환
        */
        when(eclassRoomRepository.save(any(EclassRoomEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When - 강의실 업데이트 메서드 호출
        EclassRoomDTO resultDTO = eclassRoomService.updateEclassRoom(roomCdCi, updatedDTO);

        // Then - 메서드 호출 검증
        // findById가 올바르게, 한 번만 호출되었는지 확인
        verify(eclassRoomRepository, times(1)).findById(roomCdCi);

        // save가 한 번만 호출되었는지 확인
        verify(eclassRoomRepository, times(1)).save(any(EclassRoomEntity.class));

        // 결과 값 검증
        assertAll("수정된 강의실 정보 확인",
                () -> assertNotNull(resultDTO), // 결과 DTO가 null이 아닌지 확인
                () -> assertEquals("MA-1", resultDTO.getRoomCdId(), "강의실 코드 불일치 !"),
                () -> assertEquals("Updated Room", resultDTO.getRoomNm(), "강의실 이름 불일치 !"),
                () -> assertEquals(50, resultDTO.getHdcnt(), "수용 인원 불일치 !"),
                () -> assertEquals("Y", resultDTO.getUseYn(), "사용 여부 불일치 !")
        );

        // 수정된 정보 로그 출력
        logger.info("수정 : {}", resultDTO);
    }

    @Test
    @DisplayName("[DELETE] 강의실 삭제")
    void deleteEclassRoom() {
        // Given
        // 삭제할 코드 ID를 생성, 삭제 대상이 되는 대상의 데이터 생성
        String roomCdCi = "MA-1";
        EclassRoomEntity existingEntity = new EclassRoomEntity("MA-1", "Existing Room", 30, "N"); // 기존의 강의실 엔터티

        logger.info("삭제할 데이타 : {}", existingEntity);

        // findById 메서드가 호출될 때 기존 엔터티 반환하도록 Repository Mock 객체 설정
        when(eclassRoomRepository.findById(roomCdCi)).thenReturn(Optional.of(existingEntity));

        // When - 강의실 삭제 메서드 호출
        eclassRoomService.deleteEclassRoom(roomCdCi);

        // Then - 메서드 호출 검증
        // findById가 올바르게 한 번만 호출되었는지 확인
        verify(eclassRoomRepository, times(1)).findById(roomCdCi);

        // delete가 올바르게 한 번만 호출되었는지 확인
        verify(eclassRoomRepository, times(1)).delete(any(EclassRoomEntity.class));
    }
}