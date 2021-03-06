
package com.irs.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irs.Constants.IncidentType;
import com.irs.Constants.ReportStatus;
import lombok.*;
import springfox.documentation.spring.web.json.Json;

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

//        Property property = objectMapper.readValue(incidentDetails, Property.class);

//        JsonNode jsonNode = objectMapper.readTree(this.incidentDetails);

        ReportEntity reportEntity = ReportEntity.builder()
                .id(this.id)
                .incidentDetails(this.incidentDetails)
                .reportStatus(ReportStatus.valueOf(this.reportStatus))
                .incidentType(IncidentType.valueOf(this.incidentType))
                .build();


        return reportEntity;
    }


}
