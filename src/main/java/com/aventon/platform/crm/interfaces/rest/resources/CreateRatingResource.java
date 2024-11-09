package com.aventon.platform.crm.interfaces.rest.resources;

public record CreateRatingResource(String userEmailAddress,
                                   Integer rating,
                                   String ratingAspect,
                                   String comment) {
}
