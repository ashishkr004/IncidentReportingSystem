package entities;

import Constants.IncidentType;
import Constants.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.spring.web.json.Json;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntity {
    private Long id;
    private IncidentType incidentType;
    private Json incidentDetails;
    private ReportStatus reportStatus;

    public ReportEntity dtoToEntity(ReportDto reportDto) {
        this.id = reportDto.getId();
        return this;
    }
}
