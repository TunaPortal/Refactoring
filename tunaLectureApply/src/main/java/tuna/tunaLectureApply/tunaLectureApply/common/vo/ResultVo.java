package tuna.tunaLectureApply.tunaLectureApply.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tuna.tunaLectureApply.tunaLectureApply.common.ResponseMsg;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ResultVo<T>
{

    @Schema(description = "처리 형태(OK: 성공 // ERROR: 실패)")
    String resultType = ResponseMsg.RES_OK.getResponseType();

    @Schema(description = "처리 결과 코드")
    String resultCd = ResponseMsg.RES_OK.getResponseCd();

    @Schema(description = "처리 결과 메시지")
    String resultMsg = "";

    @Schema(description = "데이터")
    List<T> data = Arrays.asList();

    @Builder
    public ResultVo(ResponseMsg  responseMsg, List<T> data, String resultMsg)
    {
        this.resultType = responseMsg == null ? ResponseMsg.RES_OK.getResponseType() : responseMsg.getResponseType();
        this.resultCd = responseMsg == null ? ResponseMsg.RES_OK.getResponseCd() : responseMsg.getResponseCd();
        this.data = data;
        this.resultMsg = resultMsg == null ? (responseMsg == null ? ResponseMsg.RES_OK.getResponseMsg() : responseMsg.getResponseMsg()) : resultMsg;
    }

    @Builder(builderMethodName = "handleBuilder")
    public ResultVo(String resultType, String resultCd, String resultMsg, List<T> data)
    {
        this.resultType = resultType;
        this.resultCd = resultCd;
        this.resultMsg = resultMsg;
        this.data = data;
    }

}
