package com.aventon.platform.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Email Address Value Object
 *
 * <p>This class represents the email address value object. It is used to encapsulate
 * the email address in a type-safe manner and ensure that it adheres to the specified
 * validation constraints.</p>
 *
 * <p>The email address is validated to ensure it is not null, not empty, and conforms
 * to a valid email format with a maximum length of 50 characters.</p>
 *
 * @param emailAddress the email address
 * @throws IllegalArgumentException if the email address is null or empty
 *
 * @see jakarta.persistence.Embeddable
 * @see jakarta.validation.constraints.Email
 * @see jakarta.validation.constraints.Size
 *
 * @author Ely Rivaldo Cortez Flores
 */
@Embeddable
public record EmailAddress(@Email @Size(max=50) String emailAddress) {

    /**
     * Constructor
     *
     * <p>The constructor validates the email address to ensure it is not null or empty.
     * If the email address is null or empty, an {@link IllegalArgumentException} is thrown.</p>
     *
     * @param emailAddress the email address
     * @throws IllegalArgumentException if the email address is null or empty
     */
    public EmailAddress {
        if (emailAddress == null || emailAddress.isBlank()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }
    }

}