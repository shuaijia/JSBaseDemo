package com.jia.demo.bean;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/8.
 * 人之所以能，是相信能
 */
public class ZQTuijian {

    /**
     * pageSize : 4
     * orderBy : 0
     * totalCount : 381
     * items : [{"TEACHERNAME":"陶玲","COURSEDATE":"2","ID":"C10004","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=C10004","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/C10004.jpg","RN":"1","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action?pageType=tuijian","TITLE":"我国反洗钱法律制度与案例分析"},{"TEACHERNAME":"陈少强","COURSEDATE":"3","ID":"C10022","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=C10022","IMGURL":"http://hzph.p.webtrn.cn/entity/mobileStudent/images/thumbs/courseImg11.png","RN":"2","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action?pageType=tuijian","TITLE":"公司财务报表分析"},{"TEACHERNAME":"欧阳国黎","COURSEDATE":"2","ID":"C09010","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=C09010","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/C09010.jpg","RN":"3","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action?pageType=tuijian","TITLE":"《证券经纪人执业规范_试行》与《证券经纪人委托合同必备条款》解读"},{"TEACHERNAME":"安青松","COURSEDATE":"2","ID":"C12001","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=C12001","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/C12001.jpg","RN":"4","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action?pageType=tuijian","TITLE":"上市公司治理"}]
     * curPage : 1
     */

    private int pageSize;
    private String orderBy;
    private int totalCount;
    private int curPage;
    private List<ItemsBean> items;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * TEACHERNAME : 陶玲
         * COURSEDATE : 2
         * ID : C10004
         * WEBURL : http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=C10004
         * IMGURL : http://hzph.p.webtrn.cn/incoming/photo/C10004.jpg
         * RN : 1
         * MOREURL : http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action?pageType=tuijian
         * TITLE : 我国反洗钱法律制度与案例分析
         */

        private String TEACHERNAME;
        private String COURSEDATE;
        private String ID;
        private String WEBURL;
        private String IMGURL;
        private String RN;
        private String MOREURL;
        private String TITLE;

        public String getTEACHERNAME() {
            return TEACHERNAME;
        }

        public void setTEACHERNAME(String TEACHERNAME) {
            this.TEACHERNAME = TEACHERNAME;
        }

        public String getCOURSEDATE() {
            return COURSEDATE;
        }

        public void setCOURSEDATE(String COURSEDATE) {
            this.COURSEDATE = COURSEDATE;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getWEBURL() {
            return WEBURL;
        }

        public void setWEBURL(String WEBURL) {
            this.WEBURL = WEBURL;
        }

        public String getIMGURL() {
            return IMGURL;
        }

        public void setIMGURL(String IMGURL) {
            this.IMGURL = IMGURL;
        }

        public String getRN() {
            return RN;
        }

        public void setRN(String RN) {
            this.RN = RN;
        }

        public String getMOREURL() {
            return MOREURL;
        }

        public void setMOREURL(String MOREURL) {
            this.MOREURL = MOREURL;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }
    }
}
