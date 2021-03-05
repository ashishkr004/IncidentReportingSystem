package com.irs.servicesimpl;

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
    public ReportDto updateReportById(ReportDto reportDto){
        return reportDto;
    }

    @Override
    public ReportDto getReportById(ReportDto reportDto){
        return reportDto;
    }
}
