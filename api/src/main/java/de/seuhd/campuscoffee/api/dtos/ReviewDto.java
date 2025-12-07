package de.seuhd.campuscoffee.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * DTO record for POS metadata.
 */
@Builder(toBuilder = true)
public record ReviewDto (
    @Nullable Long id,

    @Nullable LocalDateTime createdAt, // is null when using DTO to create a new Review
    @Nullable LocalDateTime updatedAt, // is set when creating or updating a Review

    @NotNull
    @NonNull Long posId,

    @NotNull
    @NonNull Long authorId,

    @NotBlank(message = "Review cannot be empty.")
    @NonNull String review,

    @Nullable Boolean approved
) implements Dto<Long> {
    @Override
    public @Nullable Long getId() {
        return id;
    }
}
