//package com.cs.demo.common;
//
//import lombok.Getter;
//
//@Getter
//public enum ResponseMsg {
//    //공통
//    RES_OK("OK", "C001")
//    , RES_ERROR("ERROR","C003")
//    , RES_ERROR_VALID("ERROR", "C004")  //파라미터 오류
//    , RES_ERROR_JSON("ERROR", "C005")   //JSON 형태 오류
//    , RES_ERROR_LOGIN_DUPUSR("ERROR", "C006")   //중복 로그인
//    , RES_ERROR_LOGIN_FAILPW("ERROR", "C007")   //패스워드 오류
//    , RES_ERROR_LOGIN_NOUSER("ERROR", "C008")   //존재 하지 않는 사용자
//    , RES_ERROR_NOUSER_TO_LOGOUT("ERROR", "C009")   //로그아웃 할 정보 없음
//    , RES_ERROR_LOGIN_NOTERMINAL("ERROR", "C010")   //등록되지 않은 단말기
//
//    // MQ
//    // MQ 전송은 Service 이후 처리 됨으로 MQ 전송이 실패 하더라고 서비스는 성공했다고 간주
//    , RES_ERROR_MQ("OK", "M001")
//
//
//    // 파일
//    , FILE_ERROR_CREATE("ERROR", "U001")
//    , FILE_ERROR_NOUPDATE("OK", "U002")
//    ;
//
//    private final String responseType;
//    private final String responseCd;
//
//    ResponseMsg(String responseType, String responseCd) {
//        this.responseType = responseType;
//        this.responseCd = responseCd;
//    }
//}

package tuna.tunaLectureApply.tunaLectureApply.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMsg
{

    //공통
    RES_OK("OK", "R200", "Success")                                    // 서비스 성공
    , RES_OK_NO_TRANSACTION("OK", "R202", "Success")                   // 서비스 성공, 트랜젝션 없음
    , RES_OK_NO_CANCEL("OK", "R201", "Service is OK, But irrevocable ")
    , RES_OK_NO_DATA("OK", "R204", "Success")                          // 서비스 성공, 데이터 없음
    , RES_OK_MQ_ERROR("OK", "R251", "Service is OK, But MQ send is Failed.")                         // 서비스 성공, MQ 실패
    , RES_ERROR("ERROR", "R500", "Success")                            // 서버 오류
    , RES_ERROR_BAD_REQUEST("ERROR", "R400", "Success")                // 서비스 요청 실패
    , RES_ERROR_UNAUTHORIZED("ERROR", "R401", "Success")               // 서비스 요청 권한 없음
    , RES_ERROR_BAD_PARAMETER("ERROR", "R460", "Success")              // 파라미터 오류
    , RES_ERROR_BAD_JSON("ERROR", "R461", "Success")                   // JSON 형태 오류
    , RES_ERROR_NO_TRANSACTION("ERROR", "R462", "Success")             // 트랜젝션 데이터 없음
    , RES_ERROR_MQ("ERROR", "R550", "Success");                        // 서비스 실행 실패(MQ)


    private final String responseType;
    private final String responseCd;
    private final String responseMsg;
}
