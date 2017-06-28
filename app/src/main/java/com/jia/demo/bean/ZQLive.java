package com.jia.demo.bean;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/7.
 * 人之所以能，是相信能
 */
public class ZQLive {

    /**
     * pageSize : 10
     * orderBy : 0
     * totalCount : 3
     * items : [{"ID":"4028ad0c5a1c8534015a1ca65e54000a","TIME":"2017-02-08","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_zhiBoCourseDetaiToJsp.action?courseType=zhibo&courseId=4028ad0c5a1c8534015a1ca65e54000a&batchId=4028ad0c5a1c8534015a1ca65c610009","RN":"1","TITLE":"直播课程003"},{"ID":"4028adfd5bf57057015bf60b978b0009","TIME":"2017-05-18","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_zhiBoCourseDetaiToJsp.action?courseType=zhibo&courseId=4028adfd5bf57057015bf60b978b0009&batchId=4028adfd5bf57057015bf60b96560008","RN":"2","TITLE":"测试00000001"},{"ID":"4028ad0c5ad4ad61015ad4e9faea0001","TIME":"2017-03-16","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_zhiBoCourseDetaiToJsp.action?courseType=zhibo&courseId=4028ad0c5ad4ad61015ad4e9faea0001&batchId=4028ad0c5ad4ad61015ad4e9f8170000","RN":"3","TITLE":"手机端直播测试"}]
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
         * ID : 4028ad0c5a1c8534015a1ca65e54000a
         * TIME : 2017-02-08
         * WEBURL : http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_zhiBoCourseDetaiToJsp.action?courseType=zhibo&courseId=4028ad0c5a1c8534015a1ca65e54000a&batchId=4028ad0c5a1c8534015a1ca65c610009
         * RN : 1
         * TITLE : 直播课程003
         */

        private String ID;
        private String TIME;
        private String WEBURL;
        private String RN;
        private String TITLE;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTIME() {
            return TIME;
        }

        public void setTIME(String TIME) {
            this.TIME = TIME;
        }

        public String getWEBURL() {
            return WEBURL;
        }

        public void setWEBURL(String WEBURL) {
            this.WEBURL = WEBURL;
        }

        public String getRN() {
            return RN;
        }

        public void setRN(String RN) {
            this.RN = RN;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }
    }
}
