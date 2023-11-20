package tuna.tunaEclass.tunaEclass.eclassRoom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;

public interface EclassRoomRepository extends JpaRepository<EclassRoomEntity, String> {

    // 등록 시 현재 DB에서 가장 큰 roomCdId SELECT하는 쿼리문
    /*
        room_cd_id에서 MA-다음 숫자 부분을 추출하고 최대값을 찾는다.
        room_cd_id에서 4번째 문자부터 끝까지 문자열을 추출하고 문자열 -> 정수로 변환
        nativeQuery = true == JPA 쿼리(JPQL)가 아닌 SQL 쿼리를 사용할 때는 적어줘야됨
        service에서도 쿼리를 작성할 수 있지만 가독성을 위해 Repository에 작성함
    */
    @Query(value = "SELECT MAX(CAST(SUBSTRING(room_cd_id, 4) AS int)) FROM room_cd", nativeQuery = true)
    Integer findMaxNumericValue();

}
