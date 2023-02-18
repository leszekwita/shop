package com.radzik.michal.shop.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.radzik.michal.shop.validator.SamePassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@SamePassword
public class UserDto {

    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min=5, max=10)
    private String password;

    @NotBlank
    @Length(min=5, max=10)
    private String confirmPassword;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
