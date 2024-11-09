package com.aventon.platform.crm.interfaces.rest.transform;

import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.interfaces.rest.resources.CreateRatingResource;

public class CreateRatingCommandFromResourceAssembler {

    public static CreateRatingCommand toCommandFromResource(CreateRatingResource resource, Long productId) {
        return new CreateRatingCommand(
                productId,
                resource.userEmailAddress(),
                resource.rating(),
                resource.ratingAspect(),
                resource.comment()
        );
    }
}
