package com.irembo.ride.driveronboarding.configuration.security;

import com.irembo.ride.driveronboarding.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsImpl implements UserDetails {

    private List<GrantedAuthority> authorities = new ArrayList<>();
    private String username;
    private String password;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private User user;

}
