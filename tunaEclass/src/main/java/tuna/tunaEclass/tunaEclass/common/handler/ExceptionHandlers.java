package tuna.tunaEclass.tunaEclass.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tuna.tunaEclass.tunaEclass.common.ResponseMsg;
import tuna.tunaEclass.tunaEclass.common.vo.ResultVo;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlers
{

    /**
     * json 파싱에러
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVo jsonException(Exception e)
    {
        String logString = String.format("[E][%s][%s]", e.getStackTrace()[0], e.getMessage());
        log.error(logString);
        return ResultVo.builder()
                .responseMsg(ResponseMsg.RES_ERROR_BAD_JSON)
                .data(Arrays.asList(e.getLocalizedMessage()))
                .build();
    }

    /**
     * Param 의 valid 체크 오류
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo validException(Exception e)
    {
        String logString = String.format("[E][%s][%s]", e.getStackTrace()[0], e.getMessage());
        log.error(logString);
        return ResultVo.builder()
                .responseMsg(ResponseMsg.RES_ERROR_BAD_PARAMETER)
                .data(Arrays.asList(e.getLocalizedMessage()))
                .build();
    }

//    /**
//     * mq 에러
//     */
//    @ExceptionHandler(AmqpException.class)
//    public ResultVo amqpException(Exception e)
//    {
//        String logString = String.format("[E][%s][%s]", e.getStackTrace()[0], e.getMessage());
//        log.error(logString);
//        return ResultVo.builder()
//                .responseMsg(ResponseMsg.RES_ERROR_MQ)
//                .data(Arrays.asList(e.getLocalizedMessage()))
//                .build();
//    }

    @ExceptionHandler(Exception.class)
    public ResultVo handleException(Exception e)
    {
        String logString = String.format("[E][%s][%s]", e.getStackTrace()[0], e.getMessage());
        e.printStackTrace();
        log.error(logString);
        return ResultVo.builder()
                .responseMsg(ResponseMsg.RES_ERROR)
                .data(Arrays.asList(e.getLocalizedMessage()))
                .build();
    }

    @ExceptionHandler(DataAccessException.class)
    public ResultVo dataAccessException(Exception e)
    {
        String logString = String.format("[E][%s][%s]", e.getStackTrace()[0], e.getMessage());
        e.printStackTrace();
        log.error(logString);


        return ResultVo.builder()
                .responseMsg(ResponseMsg.RES_ERROR)
                .data(Arrays.asList(e.getLocalizedMessage()))
                .build();
    }
}

