package com.patternmatch.reactiver2dbcsample.repo;

import com.patternmatch.reactiver2dbcsample.model.HistoricalEntry;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface HistoricalEntryRepository extends ReactiveCrudRepository<HistoricalEntry, Long> {

    @Query("SELECT * FROM historical_entry ORDER BY entry_date ASC LIMIT :size OFFSET :offset")
    Flux<HistoricalEntry> findSlice(int size, int offset);
}
