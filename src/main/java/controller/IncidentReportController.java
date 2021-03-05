package controller;

import entities.ReportDto;
import entities.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import services.IncidentReportService;

@Controller
@RequestMapping("/irs/v1.0/report")
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;

    @PostMapping
    public ResponseEntity<ResponseDto> createReport(@RequestBody ReportDto reportDto) {
        ResponseDto responseDto = new ResponseDto();
        return ResponseEntity.ok(responseDto);
    }
}
