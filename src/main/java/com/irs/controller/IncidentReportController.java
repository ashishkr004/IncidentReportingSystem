package com.irs.controller;

import com.irs.entities.ReportDto;
import com.irs.entities.ResponseDto;
import com.irs.exceptions.ReportNotCreatedException;
import com.irs.exceptions.ReportNotFoundException;
import com.irs.exceptions.ReportNotUpdatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.irs.services.IncidentReportService;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/irs/v1.0/report")
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;

    @PostMapping
    public ResponseEntity<ResponseDto> createReport(@RequestBody ReportDto reportDto) throws IOException {
        try {
            log.info("request_body: {}", reportDto.toString());

            ReportDto reportDto1 = incidentReportService.createReport(reportDto);

            ResponseDto responseDto = ResponseDto.builder()
                    .data(reportDto1)
                    .status("200")
                    .message("report added successfully")
                    .build();
            return ResponseEntity.ok(responseDto);
        }
        catch (Exception e) {
            throw new ReportNotCreatedException(e.getLocalizedMessage());
        }


    }

    @PatchMapping
    public ResponseEntity<ResponseDto> updateReportById(@RequestBody ReportDto reportDto) throws IOException {
        try {
            log.info("request_body: {}", reportDto.toString());

            ReportDto reportDto1 = incidentReportService.updateReportById(reportDto);

            ResponseDto responseDto = ResponseDto.builder()
                    .data(reportDto1)
                    .status("200")
                    .message("report updated successfully")
                    .build();

            return ResponseEntity.ok(responseDto);
        }
        catch (Exception e) {
            throw new ReportNotUpdatedException(e.getLocalizedMessage());
        }

    }

    @GetMapping
    public ResponseEntity<ResponseDto> getReportById(@RequestParam (name = "id") Long reportId) {
        try {
            log.info("request id: {}", reportId);

            ReportDto reportDto1 = incidentReportService.getReportById(reportId);

            ResponseDto responseDto = ResponseDto.builder()
                    .data(reportDto1)
                    .status("200")
                    .message("report fetched successfully")
                    .build();

            return ResponseEntity.ok(responseDto);

        }
        catch (Exception e) {
            throw new ReportNotFoundException(e.getLocalizedMessage());
        }
    }
}
