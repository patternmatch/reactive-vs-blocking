package com.patternmatch.nonreactivejpasample;

import com.patternmatch.nonreactivejpasample.model.HistoricalEntry;
import com.patternmatch.nonreactivejpasample.repo.HistoricalEntryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryRestController {

    private final HistoricalEntryRepository historicalEntryRepository;

    public HistoryRestController(final HistoricalEntryRepository historicalEntryRepository) {
        this.historicalEntryRepository = historicalEntryRepository;
    }

    @GetMapping("/{code}")
    public String loaderIoVerify(@PathVariable("code") final String code) {
        return code;
    }

    @GetMapping("/api/v1/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok("1.0-blocking-jpa");
    }

    @GetMapping("/api/v1/history")
    public ResponseEntity<Page<HistoricalEntry>> historyPage(final Pageable pageable) {
        return ResponseEntity.ok(historicalEntryRepository.findAll(pageable));
    }
}
