package tuna.tunaEclass.tunaEclass.eclassRoom.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuna.tunaEclass.tunaEclass.eclassRoom.dto.EclassRoomDTO;
import tuna.tunaEclass.tunaEclass.eclassRoom.entity.EclassRoomEntity;
import tuna.tunaEclass.tunaEclass.eclassRoom.service.EclassRoomService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor // final을 가진 생성자 자동 생성
@Tag(name = "Eclass - Room")
public class EclassRoomController {

	private final EclassRoomService eclassRoomService; // 생성자 주입 방식

	/* @RestController이 적용되면 @ResponseBody를 사용하지 않아도 자동으로 됨 /*
	/* Test Class 생성 단축키 : Ctrl + Shift + T */

	/* 전체 조회 */
	@GetMapping("/selectEclassRoomList")
	@Operation(summary = "강의실 리스트", description = "강의실 리스트")
	public ResponseEntity<List<EclassRoomDTO>> getAllEclassRooms() {
		
		// Service에서 모든 강의실 정보를 조회하여 List<EclassRoomEntity>로 받아옴
		List<EclassRoomEntity> eclassRoomEntityList = eclassRoomService.getAllEclassRooms();

		List<EclassRoomDTO> eclassRoomDTOList = eclassRoomEntityList
				.stream() // List -> stream()으로 변환
				.map(EclassRoomDTO::toDTO) // 각각의 EclassRoomEntity를 EclassRoomDTO로 변환
				.collect(Collectors.toList()); // stream() -> List 변환

		// 강의실 정보를 ResponseEntity로 감싸서 반환
		// 성공 시 200 코드와 정보가 담긴 eclassRoomDTOList가 담긴 ResponseEntity를 반환
		return new ResponseEntity<>(eclassRoomDTOList, HttpStatus.OK);
	}

	/* 단건 조회 */
	@GetMapping("/selectEclassRoomList/{roomCdCi}")
	@Operation(summary = "강의실 단건 조회", description = "강의실 단건 조회")
	public ResponseEntity<EclassRoomDTO> getEclassRoom(@PathVariable String roomCdCi) {
		
		// Service에 getEclassRoom(roomCdCi)를 호출하여 단일 정보를 가져오고 DTO에 저장.
		// Service에서 Controller로 넘겨줄 때 Entity -> DTO로 변환하여 넘겨줌
		EclassRoomDTO eclassRoomDTO = eclassRoomService.getEclassRoom(roomCdCi);

		if (eclassRoomDTO == null) { // eclassRoomDTO가 null이면 해당 404 에러 코드 반환
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (eclassRoomDTO.getRoomCdId() == null) { // roomCdId가 null이면 해당 404 에러 코드 반환
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			// 성공 시 200 코드와 정보가 담긴 eclassRoomDTO가 담긴 ResponseEntity를 반환
			return new ResponseEntity<>(eclassRoomDTO, HttpStatus.OK); 
		}

	}

	/* 등록 */
	@PostMapping("/InsertEclassRoom")
	@Operation(summary = "강의실 등록", description = "강의실 등록")
	public ResponseEntity<EclassRoomDTO> createEclassRoom(@RequestBody EclassRoomDTO eclassRoomDTO) {
		
		/* eclassRoomService.createEclassRoom(eclassRoomDTO)을 호출하여
		   등록 정보가 담긴 DTO를 사용하여 강의실을 등록하고, 등록된 정보를 createdRoom에 저장 */
		EclassRoomDTO createdRoom = eclassRoomService.createEclassRoom(eclassRoomDTO);

		// 강의실 정보를 ResponseEntity로 감싸서 반환
		return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
	}

	/* 수정 */
	@PutMapping("/UpdateEclassRoom/{roomCdCi}")
	@Operation(summary = "강의실 수정", description = "강의실 정보 수정")
	public ResponseEntity<EclassRoomDTO> updateEclassRoom(@PathVariable String roomCdCi, @RequestBody EclassRoomDTO eclassRoomDTO) {
		
		/* eclassRoomService.updateEclassRoom(roomCdCi, eclassRoomDTO)을 호출하여
		   등록 정보가 담긴 DTO를 사용하여 강의실을 등록하고, 등록된 정보를 updatedRoom에 저장 */
		EclassRoomDTO updatedRoom = eclassRoomService.updateEclassRoom(roomCdCi, eclassRoomDTO);

		// 강의실 정보를 ResponseEntity로 감싸서 반환
		return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
	}

	/* 삭제 */
	@DeleteMapping("/DeleteEclassRoom/{roomCdCi}")
	@Operation(summary = "강의실 삭제", description = "강의실 삭제")
	// Void를 사용한 이유 = 해당 메서드가 반환하는데 반환할 데이터가 없음을 나타내기 위해
	public ResponseEntity<Void> deleteEclassRoom(@PathVariable String roomCdCi) {

		/* eclassRoomService.deleteEclassRoom(roomCdCi)를 호출하여
		해당되는 roomCdCi를 포함하는 강의실을 삭제합니다 */
		eclassRoomService.deleteEclassRoom(roomCdCi);
		return ResponseEntity.noContent().build();
	}

}


