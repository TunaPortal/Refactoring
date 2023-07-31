package co.refactoring.tuna.domain.common.service.impl;

import co.refactoring.tuna.domain.common.service.FileService;
import org.springframework.stereotype.Service;

/**
 * @brief 파일 업로드, 삭제
 * @author 지수빈
 * @date 2022/07/13
 * @details
 * 1. upload() - 파일 업로드
 *   parameter : MultipartFile file(파일 목록 배열), 
 *   			 String folder(WEB-INF/files/* 폴더명)
 *   return : String[] 
 *   		  [originName(실제 파일명), fileName(변환되어 저장된 파일명)]
 * 2. delete() - 파일 삭제
 *   parameter : String fileName(변환되어 저장된 파일명), 
 *   			 String folder(WEB-INF/files/* 폴더명)
 *   
 * Controller에서 '@Autowired FileService 변수명'으로 주입하여 메서드 사용
 */

@Service
public class FileServiceImpl implements FileService {

}
