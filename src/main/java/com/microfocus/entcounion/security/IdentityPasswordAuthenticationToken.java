package com.microfocus.entcounion.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

@Slf4j
public class IdentityPasswordAuthenticationToken extends AbstractAuthenticationToken {
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */

    private String identity;
    private String password;

    public IdentityPasswordAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String identity, String username) {
        super(authorities);
        this.identity = identity;
        this.password = username;
        setAuthenticated(false);
    }

    public IdentityPasswordAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {
        return this.identity;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
