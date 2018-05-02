package pers.li.test;

/**
 * create by lishengbo on 2018-05-02 11:19
 */
public class UserDetail {

    /**
     * sessionId
     */
    private String sessionIdString;
    /**
     * IP详情
     */
    private String ipString;
    /**
     * 首次访问时间
     */
    private String firstTimeString;

    public String getSessionIdString() {
        return sessionIdString;
    }

    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getFirstTimeString() {
        return firstTimeString;
    }

    public void setFirstTimeString(String firstTimeString) {
        this.firstTimeString = firstTimeString;
    }
}
