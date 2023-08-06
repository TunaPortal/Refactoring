package co.refactoring.tuna.domain.lectureNotice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository.LectureNoticeRepository;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LectureNoticeServiceTest {

    @Mock
    private LectureNoticeRepository lectureNoticeRepository;

    @InjectMocks
    private LectureNoticeService lectureNoticeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("리스트")
    @Order(2)
    public void testGetAllLectureNotices() {
        // given = 테스트를 위해 사전 조건을 설정하는 부분
        // when(lectureNoticeRepository.findAll()) = Repository의 findAll() 호출을 홈쳐서 미리 동작하라고 모키토한테 꼰지름
        // .thenReturn(mockLectureNotices())은 findAll()이 호출 되었을 때 반환값을 설정
        when(lectureNoticeRepository.findAll()).thenReturn(mockLectureNotices());

        // when = 특정 메소드가 호출되면 어떤 값으로 반환해준다.
        List<LectureNotice> result = lectureNoticeService.getAllLectureNotices();

        // then = 테스트 결과를 검증하는 부분
        // assertThat()는 예상 결과와 실제 결과를 비교하는 것, 쥰나 많이쓰는듯
        // assertThat(result).isNotNull(); = result가 null이면 안돼
        assertThat(result).isNotNull();
        // assertThat(result).hasSize(2); = result가 객체 2개를 가지고 있는지, 최하단에 보면 데이터 2개 집어넣어줌
        assertThat(result).hasSize(2);
    }

    @Test
    @DisplayName("1건 조회")
    @Order(3)
    public void testGetLectureNoticeById() {
        // given
        Long id = 1L;
        // Optional = 값이 있을수도 있고 없을수도 있고
        // 값이 존재함 : isPresent() 메서드가 true를 반환하고, get() 메서드를 통해 실제 값을 얻을 수 있다
        // 값이 없음   : isPresent() 메서드가 false를 반환하고, get() 메서드를 호출하면 NoSuchElementException 발생
        // 하단에 id가 1인 애를 집어 넣었으니 true여야됨
        when(lectureNoticeRepository.findById(id)).thenReturn(Optional.of(mockLectureNotice()));

        // when
        LectureNotice result = lectureNoticeService.getLectureNoticeById(id);

        // then
        assertThat(result).isNotNull();
        // 이 Test에서 가져온 result.getNo()의 값과, ID의 값이 같은지 확인
        assertThat(result.getNo()).isEqualTo(id);
        System.out.println("ID는 : " + result.getNo()+ ", 제목은 : " + result.getTitle() + ", 내용은 : " + result.getContent());
    }

    @Test
    @DisplayName("등록")
    @Order(1)
    public void testCreateLectureNotice() {
        // given
        LectureNotice mockLectureNotice = mockLectureNotice();
        when(lectureNoticeRepository.save(any())).thenReturn(mockLectureNotice);

        // when
        LectureNotice result = lectureNoticeService.saveLectureNotice(mockLectureNotice);

        // then
        assertThat(result).isNotNull();
        // 새로운 데이터의 ID와 예상되는 ID가 일치하는지 확인
        assertThat(result.getNo()).isEqualTo(1L);
        System.out.println("ID는 : " + result.getNo()+ ", 제목은 : " + result.getTitle() + ", 내용은 : " + result.getContent());
    }

    @Test
    @DisplayName("수정")
    @Order(4)
    public void testUpdateLectureNotice() {
        // given = 테스트 기본 세팅
        Long id = 1L;
        LectureNotice existingLectureNotice = mockLectureNotice(); // 페이지 하단에 더미데이타
        // 수정할 값
        LectureNotice updatedLectureNotice = new LectureNotice(id, "Updated Content", "Updated Title");

        // 수정 전 ID 값을 불러와서
        when(lectureNoticeRepository.findById(id)).thenReturn(Optional.of(existingLectureNotice));
        // 수정 전 ID에다가 바뀐 값을 저장시켜버리기
        when(lectureNoticeRepository.save(any())).thenReturn(updatedLectureNotice);

        // when = 테스트 조건 지정
        LectureNotice result = lectureNoticeService.updateLectureNotice(id, updatedLectureNotice);

        // then = 테스트 검증하는 행동/절차 [예상과 실제가 같은지]
        //assertThat()는 예상 결과와 실제 결과를 비교한느 것
        assertThat(result).isNotNull();
        //result.getNo랑 id 값이랑 같냐
        assertThat(result.getNo()).isEqualTo(id);
        //result.getTitle이랑 위에서 수정한 데이터랑 같냐
        assertThat(result.getTitle()).isEqualTo("Updated Title");
        assertThat(result.getContent()).isEqualTo("Updated Content");
    }

    @Test
    @DisplayName("삭제")
    @Order(5)
    public void testDeleteLectureNotice() {
        // given
        Long id = 1L;

        // when
        lectureNoticeService.deleteLectureNotice(id);

        // then
        // lectureNoticeRepository.deleteById()가 한 번 호출되는지 확인
        verify(lectureNoticeRepository, times(1)).deleteById(id);
    }

    // 더미 데이터 생성 (테스트에서 사용될 LectureNotice 객체를 생성)
    private LectureNotice mockLectureNotice() {
        return new LectureNotice(1L, "단건내용1", "단건제목1");
    }

    // 더미 데이터 생성 메서드 (테스트에서 사용될 LectureNotice 리스트 생성)

    //LectureNotice 하단에다가 생성자? 만들어서 그거 가져와서 사용중
    private List<LectureNotice> mockLectureNotices() {
        List<LectureNotice> lectureNotices = new ArrayList<>();
        lectureNotices.add(new LectureNotice(1L, "리스트내용1", "리스트제목1"));
        lectureNotices.add(new LectureNotice(2L, "리스트내용2", "리스트제목1"));
        return lectureNotices;
    }
}