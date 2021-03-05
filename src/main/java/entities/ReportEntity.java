package entities;

import Constants.IncidentType;
import Constants.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "incident_report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "incident_type", nullable = false)
    private IncidentType incidentType;

    @Column(name = "incident_details", nullable = false)
    private Json incidentDetails;

    @Column(name = "report_status", nullable = false)
    private ReportStatus reportStatus;

    public ReportDto convertToDto() {
        ReportDto reportDto = new ReportDto();
        this.id = reportDto.getId();
        return reportDto;
    }
}
