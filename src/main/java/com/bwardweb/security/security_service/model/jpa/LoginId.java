package com.bwardweb.security.security_service.model.jpa;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LoginId implements Serializable {
    private UUID userId;
    private UUID clientId;
}
