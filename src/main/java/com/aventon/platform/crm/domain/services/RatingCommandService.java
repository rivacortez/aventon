package com.aventon.platform.crm.domain.services;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;

import java.util.Optional;

/**
 * @summary
 * Service interface for handling rating commands.
 * Provides methods to handle operations related to ratings.
 */
public interface RatingCommandService {

    /**
     * Handles the creation of a rating based on the provided command.
     *
     * @param command the command containing the details for creating a rating
     * @return an Optional containing the created Rating if successful, or an empty Optional if the operation fails
     */
    Optional<Rating> handle(CreateRatingCommand command);
}