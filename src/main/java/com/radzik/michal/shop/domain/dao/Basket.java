package com.radzik.michal.shop.domain.dao;


import lombok.*;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private Integer amount;




}
