package com.aventon.platform.crm.domain.model.aggregates;

import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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

    @Embedded
    private ProductId productId;

    @Embedded
    private EmailAddress emailAddress;

    @Getter
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;

    @Getter
    @NotNull
    private RatingAspect ratingAspect;

    @Getter
    @Size(max=360)
    private String comment;

    @Getter
    private Date ratedAt;

    @Getter
    private Date createdAt;

    @Getter
    private Date updatedAt;

    public Rating() {
    }

    public Rating(CreateRatingCommand command) {
        this.productId = new ProductId(command.productId());
        this.emailAddress = new EmailAddress(command.userEmailAddress());
        this.rating = command.rating();
        this.ratingAspect = RatingAspect.valueOf(command.ratingAspect());
        this.comment = command.comment();
        this.ratedAt = new Date();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Long getProductId() {
        return this.productId.productId();
    }

    public String getEmailAddress() {
        return this.emailAddress.emailAddress();
    }
}