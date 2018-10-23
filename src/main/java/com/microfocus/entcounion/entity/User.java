package com.microfocus.entcounion.entity;

import com.microfocus.entcounion.enums.Gender;
import lombok.*;
import org.joda.time.LocalDateTime;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.commons.lang3.ArrayUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@NotNull: The CharSequence, Collection, Map or Array object is not null, but can be empty.
//@NotEmpty: The CharSequence, Collection, Map or Array object is not null and size > 0.
//@NotBlank: The string is not null and the trimmed length is greater than zero.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@ToString
@Table(name = "users")
@RedisHash("user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true)
    private Long id;

    @Email
    @Column(name = "email",unique=true)
    private String email;

    @NotBlank
    @Column(name = "username",unique=true)
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Gender gender;

    @Getter(AccessLevel.NONE)
    @NotEmpty
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

    @Column(name = "updated")
    private LocalDateTime updated;


    public List<GrantedAuthority> getAuthorities(){
        return AuthorityUtils.createAuthorityList(authorities);
    }

    public List<GrantedAuthority> addAuthorities(String authority) {
        authorities = ArrayUtils.add( authorities, authority );
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
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

    @PrePersist
    private void prePersist() {
        updated = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        updated = LocalDateTime.now();
    }
}
