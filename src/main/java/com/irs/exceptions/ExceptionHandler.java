package com.irs.exceptions;

import com.irs.entities.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ApiIgnore
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ReportNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDto handleInvalidReportid(HttpServletRequest req, ReportNotFoundException ex) {
        ResponseDto responseDto = ResponseDto.builder()
                .data(null)
                .status("601")
                .message("Invalid Report Id : " + ex.getLocalizedMessage())
                .build();
        return responseDto;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ReportNotUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDto handleReportNotUpdatedException(HttpServletRequest req, ReportNotUpdatedException ex) {
        ResponseDto responseDto = ResponseDto.builder()
                .data(null)
                .status("601")
                .message("Invalid Report data : " + ex.getLocalizedMessage())
                .build();
        return responseDto;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ReportNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDto handleReportNotCreatedException(HttpServletRequest req, ReportNotCreatedException ex) {
        ResponseDto responseDto = ResponseDto.builder()
                .data(null)
                .status("601")
                .message("Invalid Report data : " + ex.getLocalizedMessage())
                .build();
        return responseDto;
    }

}
