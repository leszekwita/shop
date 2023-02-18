package com.radzik.michal.shop.domain.dao;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class Order {

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;
}
