package com.bwardweb.security.security_service.entities;

import com.bwardweb.security.security_service.model.jpa.LoginId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LoginId.class)
public class Login {
    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID userId;

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID clientId;

    private String authCode;

    private String accessToken;

    private String refreshToken;

    @NonNull
    private LocalDateTime loginTime;

    @Size(max = 50)
    @Column(length = 50)
    private String codeChallenge;

    private LocalDateTime codeChallengeCreated;
}
