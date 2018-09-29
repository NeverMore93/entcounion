package com.microfocus.entcounion.entity;

import com.microfocus.entcounion.enums.Gender;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@ToString
@Table(name = "users")
@RedisHash("user")
public class User implements UserDetails {

    @NotNull
    @Id
    @Column(name = "id",unique=true)
    private String id;

    @Email
    @Column(name = "email",unique=true)
    private String email;

    @NotNull
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Gender gender;

    @Getter(AccessLevel.NONE)
    @Column(name = "authorities")
    private String[] authorities;


    @Getter(AccessLevel.NONE)
    @Column(name = "accountNonExpired")
    private Boolean AccountNonExpired;

    @Getter(AccessLevel.NONE)
    @Column(name = "accountNonLocked")
    private Boolean AccountNonLocked;

    @Getter(AccessLevel.NONE)
    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired;

    @Getter(AccessLevel.NONE)
    @Column(name = "enabled")
    private Boolean enabled;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.AccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.AccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
