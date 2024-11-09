package com.aventon.platform.crm.interfaces.rest.resources;

import java.util.Date;

public record RatingResource(Long id,
                             Long productId,
                             String userEmailAddress,
                             Integer rating,
                             String ratingAspect,
                             String comment,
                             Date ratedAt) {
}
