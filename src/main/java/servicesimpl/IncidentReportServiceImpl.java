package servicesimpl;

import entities.ReportDto;
import org.springframework.stereotype.Service;
import services.IncidentReportService;

@Service
public class IncidentReportServiceImpl implements IncidentReportService {

    @Override
    public ReportDto createReport(ReportDto reportDto) {
        return reportDto;
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
