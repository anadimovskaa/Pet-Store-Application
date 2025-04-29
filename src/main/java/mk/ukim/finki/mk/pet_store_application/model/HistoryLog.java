package mk.ukim.finki.mk.pet_store_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class HistoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private LocalDateTime dateOfLog;

    private int successfulPurchase;
    private int failedPurchase;

    public HistoryLog(LocalDateTime dateOfLog, int successfulPurchase, int failedPurchase) {
        this.dateOfLog = dateOfLog;
        this.successfulPurchase = successfulPurchase;
        this.failedPurchase = failedPurchase;
    }

    public LocalDateTime getDateOfLog() {
        return dateOfLog;
    }

    public int getSuccessfulPurchase() {
        return successfulPurchase;
    }

    public int getFailedPurchase() {
        return failedPurchase;
    }
}
