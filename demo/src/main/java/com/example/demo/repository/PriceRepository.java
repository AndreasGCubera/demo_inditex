package com.example.demo.repository;

import com.example.demo.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findAll();

    @Query("SELECT p " +
            "FROM Price p " +
            "WHERE p.brandId = :brandId AND p.productId = :productId AND p.startDate = :startDate")
    List<Price> findApplicablePrices(@Param("brandId") int brandId,
                                     @Param("productId") int productId,
                                     @Param("startDate") LocalDateTime startDate);

}
