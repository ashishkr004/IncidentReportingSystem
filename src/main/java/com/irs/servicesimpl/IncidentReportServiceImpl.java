package com.irs.servicesimpl;

import com.irs.constants.IncidentType;
import com.irs.constants.ReportStatus;
import com.irs.entities.ReportDto;
import com.irs.entities.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irs.repositories.IncidentReportRepository;
import com.irs.services.IncidentReportService;

import java.io.IOException;

@Service
public class IncidentReportServiceImpl implements IncidentReportService {

    @Autowired
    private IncidentReportRepository incidentReportRepository;

    @Override
    public ReportDto createReport(ReportDto reportDto) throws IOException {

        ReportEntity reportEntity = incidentReportRepository.save(reportDto.convertToEntity());

        return reportEntity.convertToDto();
    }

    @Override
    public ReportDto updateReportById(ReportDto reportDto) throws IOException {
        ReportEntity reportEntity = incidentReportRepository.getOne(reportDto.getId());

        updateReport(reportEntity, reportDto);

        ReportEntity reportEntity1 = incidentReportRepository.save(reportEntity);

        return reportEntity1.convertToDto();
    }

    @Override
    public ReportDto getReportById(Long reportId){
        ReportEntity reportEntity = incidentReportRepository.getOne(reportId);
        return reportEntity.convertToDto();
    }

    private void updateReport(ReportEntity reportEntity, ReportDto reportDto) {
        reportEntity.setIncidentDetails(reportDto.getIncidentDetails());
        reportEntity.setReportStatus(ReportStatus.valueOf(reportDto.getReportStatus()));
        reportEntity.setIncidentType(IncidentType.valueOf(reportDto.getIncidentType()));
    }

}
