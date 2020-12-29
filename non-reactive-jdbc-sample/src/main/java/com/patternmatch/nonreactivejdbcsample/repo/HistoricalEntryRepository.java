package com.patternmatch.nonreactivejdbcsample.repo;

import com.patternmatch.nonreactivejdbcsample.model.HistoricalEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HistoricalEntryRepository extends PagingAndSortingRepository<HistoricalEntry, Long> {
}
