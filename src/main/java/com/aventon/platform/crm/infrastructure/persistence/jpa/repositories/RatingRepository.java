package com.aventon.platform.crm.infrastructure.persistence.jpa.repositories;


import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    boolean existsByEmailAddressAndProductIdAndRatingAspect(EmailAddress emailAddress, ProductId productId, RatingAspect ratingAspect);
}
