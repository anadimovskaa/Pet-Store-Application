package mk.ukim.finki.mk.pet_store_application.repository;

import mk.ukim.finki.mk.pet_store_application.model.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryLogRepository extends JpaRepository<HistoryLog, Long> {

}
