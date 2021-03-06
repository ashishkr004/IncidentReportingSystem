package com.irs.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.irs.constants.IncidentType;
import com.irs.constants.ReportStatus;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "incident_report")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "incident_type", nullable = false)
    private IncidentType incidentType;

    @Type(type = "jsonb")
    @Column(name = "incident_details", nullable = false, columnDefinition = "jsonb")
    private JsonNode incidentDetails;

    @Column(name = "report_status", nullable = false)
    private ReportStatus reportStatus;

    public ReportDto convertToDto() {
        ReportDto reportDto = ReportDto.builder()
                .id(this.id)
                .incidentDetails(this.incidentDetails)
                .incidentType(this.incidentType.toString())
                .reportStatus(this.reportStatus.toString())
                .build();
        return reportDto;
    }
}
