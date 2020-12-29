package com.patternmatch.reactiver2dbcsample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalEntry {

    @Id
    private Long id;
    private LocalDateTime entryDate;
    private String entryKey;
    private String entryValue;

}
