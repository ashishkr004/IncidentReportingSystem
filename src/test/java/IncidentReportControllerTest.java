import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irs.controller.IncidentReportController;
import com.irs.entities.ReportDto;
import com.irs.entities.ResponseDto;
import com.irs.services.IncidentReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IncidentReportControllerTest {

    @InjectMocks
    private IncidentReportController incidentReportController;

    @Mock
    private IncidentReportService incidentReportService;

    @Test
    public void createReport() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode incidentDetails = objectMapper.readTree("{\n" +
                "\t\"id\":2,\n" +
                "\t\"incidentType\": \"PROPERTY_DAMAE\",\n" +
                "\t\"incidentDetails\": {\n" +
                "\t\t\"id\": 123,\n" +
                "\t\t\"name\": \"tv\",\n" +
                "        \"amount\": 511,\n" +
                "\t\t\"reporter\" : {\n" +
                "\t\t\t\"employeeId\" : 54321,\n" +
                "\t\t\t\"name\": \"Abhishek\"\n" +
                "\t\t},\n" +
                "\t\t\"accuserDetails\": {\n" +
                "\t\t\t\"name\":\"ankit\",\n" +
                "\t\t\t\"address\":\"gurgaon\",\n" +
                "\t\t\t\"phone\": 999999999\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"reportStatus\": \"CREATED\"\n" +
                "\n" +
                "}");

        ReportDto reportDto = ReportDto.builder()
                .id(1L)
                .reportStatus("CREATED")
                .incidentDetails(incidentDetails)
                .incidentType("PROPERTY_DAMAE")
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .data(reportDto)
                .status("200")
                .message("report added successfully")
                .build();

        when( incidentReportService.createReport(reportDto)).thenReturn(reportDto);
        assertEquals(responseDto.getStatus(), incidentReportController.createReport(reportDto).getBody().getStatus());
    }

    @Test
    public void updateReportById() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode incidentDetails = objectMapper.readTree("{\n" +
                "\t\"id\":2,\n" +
                "\t\"incidentType\": \"PROPERTY_DAMAE\",\n" +
                "\t\"incidentDetails\": {\n" +
                "\t\t\"id\": 123,\n" +
                "\t\t\"name\": \"tv\",\n" +
                "        \"amount\": 511,\n" +
                "\t\t\"reporter\" : {\n" +
                "\t\t\t\"employeeId\" : 54321,\n" +
                "\t\t\t\"name\": \"Abhishek\"\n" +
                "\t\t},\n" +
                "\t\t\"accuserDetails\": {\n" +
                "\t\t\t\"name\":\"ankit\",\n" +
                "\t\t\t\"address\":\"gurgaon\",\n" +
                "\t\t\t\"phone\": 999999999\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"reportStatus\": \"CREATED\"\n" +
                "\n" +
                "}");

        ReportDto reportDto = ReportDto.builder()
                .id(1L)
                .reportStatus("Updated")
                .incidentDetails(incidentDetails)
                .incidentType("PROPERTY_DAMAE")
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .data(reportDto)
                .status("200")
                .message("report added successfully")
                .build();

        when(incidentReportService.updateReportById(reportDto)).thenReturn(reportDto);
        assertEquals(responseDto.getStatus(), incidentReportController.updateReportById(reportDto).getBody().getStatus());
    }

    @Test
    public void getReportById() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode incidentDetails = objectMapper.readTree("{\n" +
                "\t\"id\":2,\n" +
                "\t\"incidentType\": \"PROPERTY_DAMAE\",\n" +
                "\t\"incidentDetails\": {\n" +
                "\t\t\"id\": 123,\n" +
                "\t\t\"name\": \"tv\",\n" +
                "        \"amount\": 511,\n" +
                "\t\t\"reporter\" : {\n" +
                "\t\t\t\"employeeId\" : 54321,\n" +
                "\t\t\t\"name\": \"Abhishek\"\n" +
                "\t\t},\n" +
                "\t\t\"accuserDetails\": {\n" +
                "\t\t\t\"name\":\"ankit\",\n" +
                "\t\t\t\"address\":\"gurgaon\",\n" +
                "\t\t\t\"phone\": 999999999\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"reportStatus\": \"CREATED\"\n" +
                "\n" +
                "}");

        ReportDto reportDto = ReportDto.builder()
                .id(1L)
                .reportStatus("CREATED")
                .incidentDetails(incidentDetails)
                .incidentType("PROPERTY_DAMAE")
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .data(reportDto)
                .status("200")
                .message("report added successfully")
                .build();

        when(incidentReportService.getReportById(reportDto.getId())).thenReturn(reportDto);
        assertEquals(responseDto.getStatus(), incidentReportController.getReportById(reportDto.getId()).getBody().getStatus());

    }


}
