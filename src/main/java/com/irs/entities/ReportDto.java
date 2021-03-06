
package com.irs.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irs.constants.IncidentType;
import com.irs.constants.ReportStatus;
import lombok.*;

import java.io.IOException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private Long id;
    private String incidentType;
    private JsonNode incidentDetails;
    private String reportStatus;

    public Long getId(){
        return this.id;
    }

    public ReportEntity convertToEntity() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ReportEntity reportEntity = ReportEntity.builder()
                .id(this.id)
                .incidentDetails(this.incidentDetails)
                .reportStatus(ReportStatus.valueOf(this.reportStatus))
                .incidentType(IncidentType.valueOf(this.incidentType))
                .build();


        return reportEntity;
    }


}
