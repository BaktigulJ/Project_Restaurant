package peaksoft.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

public enum Role implements GrantedAuthority {
    DEVELOPER,
    ADMIN,
    CHEF,
    WAITER,
    ;


    @Override
    public String getAuthority() {
        return name();
    }
}
