package controller;

import entities.ReportDto;
import entities.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.IncidentReportService;

@Controller
@RequestMapping("/irs/v1.0/report")
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;

    @PostMapping
    public ResponseEntity<ResponseDto> createReport(@RequestBody ReportDto reportDto) {
        ReportDto reportDto1 = incidentReportService.createReport(reportDto);
        ResponseDto responseDto = new ResponseDto();
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> updateReportById(@RequestBody ReportDto reportDto) {
        ReportDto reportDto1 = incidentReportService.updateReportById(reportDto);
        ResponseDto responseDto = new ResponseDto();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getReportById(@RequestBody ReportDto reportDto) {
        ReportDto reportDto1 = incidentReportService.getReportById(reportDto);
        ResponseDto responseDto = new ResponseDto();
        return ResponseEntity.ok(responseDto);
    }
}
