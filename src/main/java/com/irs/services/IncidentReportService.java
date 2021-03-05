package com.irs.services;

import com.irs.entities.ReportDto;

import java.io.IOException;

public interface IncidentReportService {
    ReportDto createReport(ReportDto reportDto) throws IOException;
    ReportDto updateReportById(ReportDto reportDto);
    ReportDto getReportById(ReportDto reportDto);
}