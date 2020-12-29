package com.patternmatch.reactiver2dbcsample;

import com.patternmatch.reactiver2dbcsample.model.HistoricalEntry;
import com.patternmatch.reactiver2dbcsample.repo.HistoricalEntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
        return ResponseEntity.ok("1.0-reactive-r2dbc");
    }

    @GetMapping("/api/v1/history")
    public ResponseEntity<Flux<HistoricalEntry>> historySlice(
            @RequestParam(required = false, defaultValue = "10") final int size,
            @RequestParam(required = false, defaultValue = "0") final int offset) {
        return ResponseEntity.ok(historicalEntryRepository.findSlice(size, offset));
    }
}
