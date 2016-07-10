package com.artkostm.flymer.flymerclient2.login.model;

import java.util.Map;

/**
 * Created by arttsiom.chuiko on 10/07/16.
 */
public class FlymerUserInfo {
    private String ac;
    private String sid;
    private String fkey;
    private Map<String, String> cookiesMap;
    private Error error;

    public FlymerUserInfo(String ac, String sid, String fkey, Map<String, String> cookiesMap, Error error) {
        this.ac = ac;
        this.sid = sid;
        this.fkey = fkey;
        this.cookiesMap = cookiesMap;
        this.error = error;
    }

    public FlymerUserInfo(String ac, String sid, String fkey, Map<String, String> cookiesMap) {
        this.ac = ac;
        this.sid = sid;
        this.fkey = fkey;
        this.cookiesMap = cookiesMap;
    }

    public FlymerUserInfo() {
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getFkey() {
        return fkey;
    }

    public void setFkey(String fkey) {
        this.fkey = fkey;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Map<String, String> getCookiesMap() {
        return cookiesMap;
    }

    public void setCookiesMap(Map<String, String> cookiesMap) {
        this.cookiesMap = cookiesMap;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public boolean hasError() {
        return error == null;
    }
}
