package com.sopen.landingpageviettel.demo.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
