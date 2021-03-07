import com.irs.constants.IncidentType;
import com.irs.constants.ReportStatus;
import com.irs.entities.ReportDto;
import com.irs.entities.ReportEntity;
import com.irs.repositories.IncidentReportRepository;
import com.irs.servicesimpl.IncidentReportServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IncidentReportServiceImplTest {

    @InjectMocks
    private IncidentReportServiceImpl incidentReportServiceImpl;

    @Mock
    private IncidentReportRepository incidentReportRepository;

    @Test
    public void createReport() throws IOException {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setId(1L);
        reportEntity.setIncidentType(IncidentType.FIRE_INCIDENT);
        reportEntity.setReportStatus(ReportStatus.OPEN);
        ReportDto reportDto = reportEntity.convertToDto();
        when(incidentReportRepository.save(reportEntity)).thenReturn(reportEntity);
        assertEquals(reportEntity.getId(), incidentReportServiceImpl.createReport(reportDto).getId());
    }

    @Test
    public void updateReportById() throws IOException {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setId(1L);
        reportEntity.setIncidentType(IncidentType.FIRE_INCIDENT);
        reportEntity.setReportStatus(ReportStatus.OPEN);
        ReportDto reportDto = reportEntity.convertToDto();
        when(incidentReportRepository.getOne(reportDto.getId())).thenReturn(reportEntity);
        when(incidentReportRepository.save(reportEntity)).thenReturn(reportEntity);
        assertEquals(reportEntity.getId(), incidentReportServiceImpl.updateReportById(reportDto).getId());
    }

    @Test
    public void getReportById() throws IOException {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setId(1L);
        reportEntity.setIncidentType(IncidentType.FIRE_INCIDENT);
        reportEntity.setReportStatus(ReportStatus.OPEN);
        ReportDto reportDto = reportEntity.convertToDto();
        when(incidentReportRepository.getOne(reportDto.getId())).thenReturn(reportEntity);
        assertEquals(reportEntity.getId(), incidentReportServiceImpl.getReportById(reportDto.getId()).getId());
    }
}
