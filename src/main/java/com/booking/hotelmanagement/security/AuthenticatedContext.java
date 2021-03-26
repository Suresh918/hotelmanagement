package com.booking.hotelmanagement.security;

import com.booking.hotelmanagement.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthenticatedContext {

    public Set<String> getRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority().substring(5)).collect(Collectors.toSet());
    }

    private User getPrincipalUser() {
        if (SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext().getAuthentication() == null ||
                SecurityContextHolder.getContext().getAuthentication().getCredentials() == null)
            return null;
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    public User getUser() {
        User principalUser = getPrincipalUser();
        if (Objects.isNull(principalUser)) {
            return null;
        }
        User user = new User();
        user.setUserId(principalUser.getUserId());
        user.setFullName(principalUser.getFullName());
        user.setAbbreviation(principalUser.getAbbreviation());
        user.setEmail(principalUser.getEmail());
        user.setDepartmentName(principalUser.getDepartmentName());
        return user;
    }
}
