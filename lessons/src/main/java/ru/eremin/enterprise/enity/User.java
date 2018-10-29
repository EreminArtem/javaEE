package ru.eremin.enterprise.enity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @Setter(AccessLevel.NONE)
    private String id = UUID.randomUUID().toString();

    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false)
    private String hashPassword;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private int permissionLevel;
}
