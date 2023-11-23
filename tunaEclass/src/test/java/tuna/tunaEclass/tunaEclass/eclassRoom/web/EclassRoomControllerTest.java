package tuna.tunaEclass.tunaEclass.eclassRoom.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;
import tuna.tunaEclass.tunaEclass.eclassRoom.dto.EclassRoomDTO;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;
import tuna.tunaEclass.tunaEclass.eclassRoom.service.EclassRoomService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// JUnit5와 Mockito를 함께 사용하는 어노테이션 | MockitoExtension = Mockito 관련 설정 활성화
@ExtendWith(MockitoExtension.class)
class EclassRoomControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(EclassRoomControllerTest.class);

    // EclassRoomService에 대한 Mock 객체 생성, Test에서 사용될 실제 Service 대신 사용될 구라 객체
    @Mock
    private EclassRoomService eclassRoomService;

    // EclassRoomController에 Mock 객체를 주입
    @InjectMocks
    private EclassRoomController eclassRoomController;

    // Spring MVC 테스트를 수행하기 위한 MockMvc 객체 생성
    private MockMvc mockMvc;

    /*
    * 각 테스트가 실행되기 전 MockMvc 객체를 생성
    * MockMvcBuilders = MockMvc를 생성하기 위한 빌더
    * standaloneSetup = 단독으로 특정 컨트롤러를 설정
    * addFilter = 문자 인코딩 추가
    */
    @BeforeEach
    void setup() {
        // MockMvc 설정
        this.mockMvc = MockMvcBuilders.standaloneSetup(eclassRoomController)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    /* 전체 조회 */
    @DisplayName("[mockMvc GET] 전체 조회")
    @Test
    void getAllEclassRooms() throws Exception {
        // 더미데이터 1
        EclassRoomEntity roomEntity1 = EclassRoomEntity.builder()
                .roomCdId("MA-1")
                .roomNm("강의실 101")
                .hdcnt(30)
                .useYn("Y")
                .build();

        // 더미데이터 2
        EclassRoomEntity roomEntity2 = EclassRoomEntity.builder()
                .roomCdId("MA-2")
                .roomNm("강의실 102")
                .hdcnt(25)
                .useYn("N")
                .build();

        // 리스트 생성
        List<EclassRoomEntity> eclassRoomEntityList = Arrays.asList(roomEntity1, roomEntity2);

        // eclassRoomService.getAllEclassRooms()이가 호출되면 eclassRoomEntityList를 반환
        when(eclassRoomService.getAllEclassRooms()).thenReturn(eclassRoomEntityList);

        // 요청 및 응답 확인
        /*
         * 엔드포인트에 대한 GET 요청 시뮬레이션
         * contentType(MediaType.APPLICATION_JSON) = 요청이 JSON 형식임을 나타냄
         * mockMvc.perform = HTTP 요청 시뮬레이션을 하고, 해당 요청에 대한 응답을 테스트
         */
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/selectEclassRoomList")
                        .contentType(MediaType.APPLICATION_JSON))

                // 응답 HTTP 상태 코드가 200(OK)인지 확인
                .andExpect(status().isOk())
                // JSON 응답 배열 길이가 2인지 확인
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2)) // 리스트 크기 확인

                // JSON 배열의 첫 번째 요소가 예상한 값과 일치하는지 확인
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].roomCdId").value("MA-1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].roomNm").value("강의실 101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hdcnt").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].useYn").value("Y"))

                // JSON 배열의 두 번째 요소가 예상한 값과 일치하는지 확인
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].roomCdId").value("MA-2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].roomNm").value("강의실 102"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hdcnt").value(25))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].useYn").value("N"))

                // 테스트 실행 중 추가 정보를 콘솔에 출력
                .andDo(print())
                // MvcResult를 반환하며 추가적인 검증이나 결과를 나타낼 수 있다.
                .andReturn();

        // 리스트 정보 출력
        logger.info("전체 조회 : {}", result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("[mockMvc GET] 단건 조회")
    void getEclassRoom_Exists() throws Exception {
        // Mock 데이터 설정
        String roomCdId = "MA-1";
        EclassRoomEntity mockEntity = EclassRoomEntity.builder()
                .roomCdId(roomCdId)
                .roomNm("강의실 101")
                .hdcnt(30)
                .useYn("Y")
                .build();
        EclassRoomDTO mockDTO = EclassRoomDTO.toDTO(mockEntity);

        // Mock Service의 동작 설정
        when(eclassRoomService.getEclassRoom(roomCdId)).thenReturn(mockDTO);

        // API 요청 및 응답 확인
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/selectEclassRoomList/{roomCdCi}", roomCdId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomCdId").value(roomCdId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomNm").value("강의실 101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hdcnt").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.useYn").value("Y"))
                .andDo(print())
                .andReturn();

        logger.info("단건 조회 : {}", result.getResponse().getContentAsString());
    }

    /* 등록 */
    @Test
    @DisplayName("[mockMvc POST] 등록")
    void createEclassRoom() throws Exception {
        // Mock 데이터 설정
        EclassRoomDTO requestDTO = new EclassRoomDTO(null, "강의실 103", 40, "Y");
        EclassRoomEntity savedEntity = EclassRoomEntity.builder()
                .roomCdId("MA-3")
                .roomNm("강의실 103")
                .hdcnt(40)
                .useYn("Y")
                .build();
        EclassRoomDTO responseDTO = EclassRoomDTO.toDTO(savedEntity);

        // Mock Service의 동작 설정
        doReturn(responseDTO).when(eclassRoomService).createEclassRoom(any(EclassRoomDTO.class));

        // API 요청 및 응답 확인
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/InsertEclassRoom")
                        .contentType(MediaType.APPLICATION_JSON)
                        //JSON 형식
                        .content("{\"roomNm\":\"강의실 103\",\"hdcnt\":40,\"useYn\":\"Y\"}"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomCdId").value("MA-3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomNm").value("강의실 103"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hdcnt").value(40))
                .andExpect(MockMvcResultMatchers.jsonPath("$.useYn").value("Y"))
                .andDo(print())
                .andReturn();

        // 응답 정보 출력
        logger.info("등록 : {}", result.getResponse().getContentAsString());
    }

    /* 수정 */
    @Test
    @DisplayName("[PUT] 수정")
    void updateEclassRoom() {
        // Given
        String roomCdCi = "수정전";
        EclassRoomDTO requestDTO = new EclassRoomDTO("수정전", "전강의실", 30, "Y");
        EclassRoomDTO existingDTO = new EclassRoomDTO("수정후", "후강의실", 20, "N");

        when(eclassRoomService.updateEclassRoom(eq(roomCdCi), any())).thenReturn(existingDTO);

        // When
        ResponseEntity<EclassRoomDTO> responseEntity = eclassRoomController.updateEclassRoom(roomCdCi, requestDTO);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EclassRoomDTO responseDTO = responseEntity.getBody();
        assertEquals(existingDTO.getRoomNm(), responseDTO.getRoomNm());
        assertEquals(existingDTO.getHdcnt(), responseDTO.getHdcnt());
        assertEquals(existingDTO.getUseYn(), responseDTO.getUseYn());

        // Verify that the service method was called with the correct parameters
        verify(eclassRoomService, times(1)).updateEclassRoom(eq(roomCdCi), any());

    }


    /* 삭제 */
    @Test
    @DisplayName("[mockMvc DELETE] 삭제")
    void deleteEclassRoom() throws Exception {
        // Mock 데이터 설정
        String roomCdId = "MA-1";

        // Mock Service의 동작 설정
        // doNothing() = 메서드 호출 시 아무 동작도 하지 않게 설정
        doNothing().when(eclassRoomService).deleteEclassRoom(roomCdId);

        // API 요청 및 응답 확인
        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteEclassRoom/{roomCdCi}", roomCdId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

        // 성공했을 때 콘솔에 출력
        System.out.println("삭제 성공!");
    }
}