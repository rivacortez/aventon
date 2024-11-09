package com.aventon.platform.crm.interfaces.rest.transform;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.interfaces.rest.resources.RatingResource;

public class RatingResourceFromEntityAssembler {

    public static RatingResource toResourceFromEntity(Rating rating) {
        return new RatingResource(
                rating.getId(),
                rating.getProductId(),
                rating.getEmailAddress(),
                rating.getRating(),
                rating.getRatingAspect().name(),
                rating.getComment(),
                rating.getRatedAt()
        );
    }
}
