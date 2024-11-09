package com.aventon.platform.crm.application.internal;


import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.crm.domain.services.RatingCommandService;
import com.aventon.platform.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingCommandServiceImpl  implements RatingCommandService {

    private final RatingRepository ratingRepository;


    public RatingCommandServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Optional<Rating> handle(CreateRatingCommand command) {

        var emailAddress = new EmailAddress(command.userEmailAddress());
        var productId = new ProductId(command.productId());

        if (ratingRepository.existsByEmailAddressAndProductIdAndRatingAspect(
                emailAddress, productId, RatingAspect.valueOf(command.ratingAspect()))) {

            throw new IllegalArgumentException("Rating already exists");
        }

        var rating = new Rating(command);
        ratingRepository.save(rating);

        return Optional.of(rating);
    }
}
