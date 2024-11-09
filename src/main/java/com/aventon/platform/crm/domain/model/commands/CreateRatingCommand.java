package com.aventon.platform.crm.domain.model.commands;

/**
 * Create Rating Command
 *
 * <p>This class represents the create rating command. It is used to encapsulate
 * the details required to create a rating for a product, including the product id,
 * user email address, rating value, rating aspect, and an optional comment.</p>
 *
 * <p>The rating is validated to ensure it is between 1 and 5.</p>
 *
 * @param productId the product id
 * @param userEmailAddress the user email address
 * @param rating the rating
 * @param ratingAspect the rating aspect
 * @param comment the comment
 * @throws IllegalArgumentException if the rating is not between 1 and 5
 *
 * @see com.aventon.platform.crm.domain.model.valueobjects.ProductId
 * @see com.aventon.platform.crm.domain.model.valueobjects.EmailAddress
 * @see com.aventon.platform.crm.domain.model.valueobjects.RatingAspect
 *
 * @autor Ely Rivaldo Cortez Flores
 */
public record CreateRatingCommand(Long productId, String userEmailAddress,
                                  Integer rating, String ratingAspect, String comment) {

    /**
     * Constructor
     *
     * <p>The constructor validates the rating to ensure it is between 1 and 5.
     * If the rating is not within this range, an {@link IllegalArgumentException} is thrown.</p>
     *
     * @param productId the product id
     * @param userEmailAddress the user email address
     * @param rating the rating
     * @param ratingAspect the rating aspect
     * @param comment the comment
     * @throws IllegalArgumentException if the rating is not between 1 and 5
     */
    public CreateRatingCommand {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
