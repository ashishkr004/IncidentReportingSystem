package com.irs.repositories;

import com.irs.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentReportRepository extends JpaRepository<ReportEntity, Long> {
//
//    @Query()
//    ReportEntity createReport(@Param("incident_type") IncidentType incident_type,
//                              @Param("incident_details") Json incident_details,
//                              @Param("report_status") ReportStatus reportStatus);
}
