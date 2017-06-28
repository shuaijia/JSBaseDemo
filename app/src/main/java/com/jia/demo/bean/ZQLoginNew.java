package com.jia.demo.bean;

/**
 * Describtion:
 * Created by jia on 2017/6/8.
 * 人之所以能，是相信能
 */
public class ZQLoginNew {


    /**
     * site : {"name":"中国证券业协会","domain":"hzph.p.webtrn.cn:80","code":"localhost"}
     * loginId : F41422
     * nickName :
     * unTyxlLoginToken : aHpwaC5wLndlYnRybi5jbjo4MHx8ZWM5MDE1ZWYyZTQ5NDMwNmE1YzgzMjM0ZjEyNzhjZGJ8fEY0MTQyMnx8bG9jYWxob3N0
     * photo :
     * loginType : ec9015ef2e494306a5c83234f1278cdb
     */

    private SiteBean site;
    private String loginId;
    private String nickName;
    private String unTyxlLoginToken;
    private String photo;
    private String loginType;

    public SiteBean getSite() {
        return site;
    }

    public void setSite(SiteBean site) {
        this.site = site;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUnTyxlLoginToken() {
        return unTyxlLoginToken;
    }

    public void setUnTyxlLoginToken(String unTyxlLoginToken) {
        this.unTyxlLoginToken = unTyxlLoginToken;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public static class SiteBean {
        /**
         * name : 中国证券业协会
         * domain : hzph.p.webtrn.cn:80
         * code : localhost
         */

        private String name;
        private String domain;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
