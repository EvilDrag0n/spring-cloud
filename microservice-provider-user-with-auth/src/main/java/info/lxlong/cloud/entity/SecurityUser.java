package info.lxlong.cloud.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * HTTP basic 检验用
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.entity
 * @ClassName: SecurityUser
 * @Author: lxlong
 * @Date: 2019-04-03 16:39
 * @Version: 1.0
 */
public class SecurityUser implements UserDetails {

    private Long id ;
    private String username;
    private String password;
    private String role;

    public SecurityUser(String username, String password, String role) {
        super();
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public SecurityUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.role);
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
