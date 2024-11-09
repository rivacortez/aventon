package com.aventon.platform.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ProductId Value Object
 *
 * <p>This class represents the value object for the product id. It is used to encapsulate
 * the product id in a type-safe manner and ensure that it adheres to the specified
 * validation constraints.</p>
 *
 * <p>The product id is validated to ensure it is not null and greater than zero.</p>
 *
 * @param productId the product id
 * @throws IllegalArgumentException if the product id is null or less than or equal to zero
 *
 * @see jakarta.persistence.Embeddable
 *
 * @autor Ely Rivaldo Cortez Flores
 */
@Embeddable
public record ProductId(Long productId) {

    /**
     * Constructor
     *
     * <p>The constructor validates the product id to ensure it is not null or less than or equal to zero.
     * If the product id is null or less than or equal to zero, an {@link IllegalArgumentException} is thrown.</p>
     *
     * @param productId the product id
     * @throws IllegalArgumentException if the product id is null or less than or equal to zero
     */
    public ProductId {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Invalid product id");
        }
    }
}