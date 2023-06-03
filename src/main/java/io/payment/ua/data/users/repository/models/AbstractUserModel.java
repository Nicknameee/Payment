package io.payment.ua.data.users.repository.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.payment.ua.data.users.attributes.Role;
import io.payment.ua.data.users.attributes.Status;
import io.payment.ua.data.users.security.DataEncoderTool;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "users")
@Data
public class AbstractUserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", unique = true, nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "mail", unique = true, nullable = false)
    private String mail;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.LOGOUT;
    @Column(name = "enabled")
    private boolean enabled = true;
    @Column(name = "login_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date loginTime = new Date(0);
    @Column(name = "logout_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logoutTime = new Date(0);
    @Column(name = "timezone", nullable = false)
    private TimeZone timeZone;

    @JsonSetter("timezone")
    public void setTimeZone(String timeZone) {
        this.timeZone = TimeZone.getTimeZone(timeZone);
    }

    @JsonGetter("timezone")
    public String getTimeZone() {
        return this.timeZone.getID();
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return this.enabled;
    }

    public void encryptUserPassword() {
        this.password = DataEncoderTool.encodeData(this.password);
    }
}
