package repositories;

import Constants.IncidentType;
import Constants.ReportStatus;
import entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springfox.documentation.spring.web.json.Json;

@Repository
public interface IncidentReportRepository extends JpaRepository<ReportEntity, Long> {
//
//    @Query()
//    ReportEntity createReport(@Param("incident_type") IncidentType incident_type,
//                              @Param("incident_details") Json incident_details,
//                              @Param("report_status") ReportStatus reportStatus);
}
