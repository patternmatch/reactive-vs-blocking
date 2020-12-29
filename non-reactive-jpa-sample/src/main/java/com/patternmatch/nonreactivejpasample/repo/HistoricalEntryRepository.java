package com.patternmatch.nonreactivejpasample.repo;

import com.patternmatch.nonreactivejpasample.model.HistoricalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalEntryRepository extends JpaRepository<HistoricalEntry, Long> {
}
