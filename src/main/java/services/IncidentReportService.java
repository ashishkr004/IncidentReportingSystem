package services;

import entities.ReportDto;

public interface IncidentReportService {
    ReportDto createReport(ReportDto reportDto);
    ReportDto updateReportById(ReportDto reportDto);
    ReportDto getReportById(ReportDto reportDto);
}
