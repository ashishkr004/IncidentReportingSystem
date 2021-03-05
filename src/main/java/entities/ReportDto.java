package entities;

import Constants.IncidentType;
import Constants.ReportStatus;
import lombok.*;
import springfox.documentation.spring.web.json.Json;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private Long id;
    private IncidentType incidentType;
    private Json incidentDetails;
    private ReportStatus reportStatus;

    public Long getId(){
        return this.id;
    }

    public ReportEntity convertToEntity(){
        ReportEntity reportEntity = new ReportEntity();
        return reportEntity;
    }


}
