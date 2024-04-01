package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AuditUpdateResponse {
        @NotNull(message = "ID is required")
        private Long id;

        @NotBlank(message = "Audit Updated Successfully")
        private String message;

        public AuditUpdateResponse(Long id, String message) {
            this.id = id;
            this.message = "Audit Updated successfully";
        }
}
