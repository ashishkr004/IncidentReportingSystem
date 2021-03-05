package servicesimpl;

import entities.ReportDto;
import entities.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IncidentReportRepository;
import services.IncidentReportService;

@Service
public class IncidentReportServiceImpl implements IncidentReportService {

    @Autowired
    private IncidentReportRepository incidentReportRepository;

    @Override
    public ReportDto createReport(ReportDto reportDto) {

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
