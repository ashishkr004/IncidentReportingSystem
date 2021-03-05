package com.irs.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.irs.Constants.IncidentType;
import com.irs.Constants.ReportStatus;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import java.util.Map;

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
    private Map<String,Map<String,String>> incidentDetails;

    @Column(name = "report_status", nullable = false)
    private ReportStatus reportStatus;

    public ReportDto convertToDto() {
        ReportDto reportDto = new ReportDto();
        this.id = reportDto.getId();
        return reportDto;
    }
}
