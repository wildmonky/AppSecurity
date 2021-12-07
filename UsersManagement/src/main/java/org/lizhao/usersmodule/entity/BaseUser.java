package org.lizhao.usersmodule.entity;

import java.util.List;
/**
 * @author lizhao
 * @version 1.0
 * @ClassName BaseUser
 * @Description TODO
 * @Date 2021-10-03 19:35
 * @since 1.8
 */
public class BaseUser {
    private String id;
    private String name;
    private String password;
    private char[] mobilePhone;
    private String email;
    private List<BaseAuthorities> authorities;
    private List<BaseAuthoritiesGroup> authoritiesGroup;

    public String getId() throws Exception{
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char[] getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(char[] mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BaseAuthorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<BaseAuthorities> authorities) {
        this.authorities = authorities;
    }

    public List<BaseAuthoritiesGroup> getAuthoritiesGroup() {
        return authoritiesGroup;
    }

    public void setAuthoritiesGroup(List<BaseAuthoritiesGroup> authoritiesGroup) {
        this.authoritiesGroup = authoritiesGroup;
    }
}
