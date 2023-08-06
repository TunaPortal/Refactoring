package co.refactoring.tuna.domain.lectureNotice.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.web.LectureNoticeController;

//@WebMvcTest(LectureNoticeController.class)
public class LectureNoticeControllerTest {

    @Mock
    private LectureNoticeService lectureNoticeService;
    /* @Mock은 스프링과는 무관하게 단위 테스트에서 Mockito를 사용할 때 주로 사용
       @MockBean은 스프링과 통합된 테스트에서 Mock 객체를 주입할 때 사용*/

    @InjectMocks // @Mock 달린 애들이 @InjectMocks 붙은 필드에 자동 주입됨
    private LectureNoticeController lectureNoticeController;

    private MockMvc mockMvc;

    @BeforeEach // 테스트 시작 전 1번만
    void setUp() { //setUp는 각각의 테스트가 종료되면 초기화, @BeforeEach랑 동일한 기능인데 왜 2개 쓴지는 의문
        MockitoAnnotations.openMocks(this); // Test Class 내의 Mock 쉑히들을 초기화
        mockMvc = MockMvcBuilders.standaloneSetup(lectureNoticeController).build(); // Mock 쉑히들 생성, standaloneSetup는 단독 테스트 환경 컨트롤러 테스트용
    }

    @Test // 이거 붙여야 테스트 가능
    @DisplayName("리스트") // 콘솔창 왼쪽에 뜨는 테스트 목록들 이름
    @Order(2) // 테스트 실행 순서
    public void testGetAllLectureNotices() throws Exception {
        // given = 테스트를 위해 사전 조건을 설정하는 부분
        List<LectureNotice> mockLectureNotices = new ArrayList<>();
        mockLectureNotices.add(new LectureNotice(1L, "Title 1", "Content 1")); // 더미 데이타 추가
        mockLectureNotices.add(new LectureNotice(2L, "Title 2", "Content 2"));

        // when = 특정 메소드가 호출되면 어떤 값으로 반환해준다.
        // 아래는 lectureNoticeService.getAllLectureNotices()가 호출되면 mockLectureNotices이라는 위에 더미 데이타로 반환
        when(lectureNoticeService.getAllLectureNotices()).thenReturn(mockLectureNotices);

        // when = 실제 테스트를 수행하는 부분
        // mockMvc.perform() = 메서드 요청 실행
        // MockMvcRequestBuilders.get("/lecture-notices") -> GET 요청 생성, 걍 /lecture-notices일로 날리는듯, 물론 테스트 코드에서만
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/lecture-notices")).andReturn();

        // then = 테스트 결과를 검증하는 부분
        // verify = 검증 기능 -> times = verify 중에 몇 번 호출 되었는지 확인, 아래는 1번 호출되었는지. 최소, 최대, 시간별로 옵션이 있음.
        verify(lectureNoticeService, times(1)).getAllLectureNotices();
    }

    @Test
    @DisplayName("1건 조회")
    @Order(3)
    public void testGetLectureNoticeById() throws Exception {
        // given
        Long id = 1L;
        LectureNotice mockLectureNotice = new LectureNotice(id, "Title 1", "Content 1"); // 더미 데이타

        when(lectureNoticeService.getLectureNoticeById(id)).thenReturn(mockLectureNotice);

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/lecture-notices/1")).andReturn();

        // then
        //verify.times =  몇번 실행됐는지 아래는 1번만 실행 됐는지, ID값이 한번만 불러왔는지
        verify(lectureNoticeService, times(1)).getLectureNoticeById(id);
    }

    @Test
    @DisplayName("등록")
    @Order(1)
    public void testCreateLectureNotice() throws Exception {
        // given
        LectureNotice mockLectureNotice = new LectureNotice(null, "Title 1", "Content 1");

        when(lectureNoticeService.saveLectureNotice(any())).thenReturn(mockLectureNotice);

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/lecture-notices").flashAttr("lectureNotice", mockLectureNotice)).andReturn();

        // then
        verify(lectureNoticeService, times(1)).saveLectureNotice(any());
    }

    @Test
    @DisplayName("수정")
    @Order(4)
    public void testUpdateLectureNotice() throws Exception {
        // given
        Long id = 1L;
        LectureNotice existingLectureNotice = new LectureNotice(id, "Title 1", "Content 1"); // 수정 전 데이터
        LectureNotice updatedLectureNotice = new LectureNotice(id, "Updated Title", "Updated Content"); // 수정 후 데이터

        when(lectureNoticeService.getLectureNoticeById(id)).thenReturn(existingLectureNotice); // 수정 전 데이터 반환

        // any는 값 말고 메서드가 호출되었는지 여부만 검증
        when(lectureNoticeService.saveLectureNotice(any())).thenReturn(updatedLectureNotice); // 수정 후 데이터 반환

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/lecture-notices/1/update").flashAttr("updatedLectureNotice", updatedLectureNotice)).andReturn();

        // then
        verify(lectureNoticeService, times(1)).getLectureNoticeById(id);
        verify(lectureNoticeService, times(1)).saveLectureNotice(any());
    }

    @Test
    @DisplayName("삭제")
    @Order(5)
    public void testDeleteLectureNotice() throws Exception {
        // given
        Long id = 1L;

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/lecture-notices/1/delete")).andReturn();

        // then
        verify(lectureNoticeService, times(1)).deleteLectureNotice(id);
    }
}