package com.aventon.platform.crm.domain.model.aggregates;

import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;
/**
 * Rating Aggregate Root
 *
 * <p>This class represents the rating aggregate root. It is used to encapsulate
 * the details of a rating for a product, including the product id, user email address,
 * rating value, rating aspect, and an optional comment.</p>
 *
 * <p>The rating value is validated to ensure it is between 1 and 5.</p>
 *
 * @author Ely Rivaldo Cortez Flores
 */
@Entity
public class Rating extends AuditableAbstractAggregateRoot<Rating> {

    /**
     * The product id value object
     */
    @Embedded
    private ProductId productId;

    /**
     * The email address value object
     */
    @Embedded
    private EmailAddress emailAddress;

    /**
     * The rating value
     */
    @Getter
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;

    /**
     * The rating aspect value object
     */
    @Getter
    @NotNull
    private RatingAspect ratingAspect;

    /**
     * The comment value
     */
    @Getter
    @Size(max=360)
    private String comment;

    /**
     * The date the rating was created
     */
    @Getter
    private Date ratedAt;

    /**
     * Default constructor
     */
    public Rating() {
    }

    /**
     * This constructor creates a rating aggregate root from a create rating command
     *
     * @param command the create rating command
     */
    public Rating(CreateRatingCommand command) {
        this.productId = new ProductId(command.productId());
        this.emailAddress = new EmailAddress(command.userEmailAddress());
        this.rating = command.rating();
        this.ratingAspect = RatingAspect.valueOf(command.ratingAspect());
        this.comment = command.comment();
        this.ratedAt = new Date();
    }

    /**
     * Gets the product id
     *
     * @return the product id
     */
    public Long getProductId() {
        return this.productId.productId();
    }

    /**
     * Gets the email address
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return this.emailAddress.emailAddress();
    }
}