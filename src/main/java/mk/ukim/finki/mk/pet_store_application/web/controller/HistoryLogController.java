package mk.ukim.finki.mk.pet_store_application.web.controller;

import mk.ukim.finki.mk.pet_store_application.model.HistoryLog;
import mk.ukim.finki.mk.pet_store_application.repository.HistoryLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryLogController {

    private final HistoryLogRepository historyLogRepository;

    public HistoryLogController(HistoryLogRepository historyLogRepository) {
        this.historyLogRepository = historyLogRepository;
    }

    @GetMapping("api/history")
    public List<HistoryLog> getHistory(){
        return historyLogRepository.findAll();
    }



}
