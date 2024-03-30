package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ClientUpdateResponse {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Updated Successfully")
    private String message;

    public ClientUpdateResponse(Long id, String message) {
        this.id = id;
        this.message = "Client Updated successfully";
    }
}
