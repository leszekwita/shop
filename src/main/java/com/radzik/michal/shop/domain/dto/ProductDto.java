package com.radzik.michal.shop.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDto {

    private Long id;

    private String name;

    private Integer price;

    private Integer number;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
