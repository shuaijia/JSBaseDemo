package com.jia.demo.bean;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/7.
 * 人之所以能，是相信能
 */
public class ZQRemen {


    /**
     * data : {"pageSize":4,"orderBy":"0","totalCount":68,"items":[{"PINGFEN":"0","COUNT":"26","TEACHERNAME":"无","COURSEDATE":"1","ID":"4028ad0c59824a2e0159824cc0010007","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad0c59824a2e0159824cc0010007","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/0zlr0vls08.jpg","RN":"1","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"课程空间007"},{"PINGFEN":"6.0","COUNT":"19","TEACHERNAME":"万勇","COURSEDATE":"3","ID":"4028ad225a8492a7015a8497bbdd0000","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad225a8492a7015a8497bbdd0000","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/9vr62ckokr.jpg","RN":"2","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"app测试长度测试长度测试长度测试"},{"PINGFEN":"0.0","COUNT":"16","TEACHERNAME":"桂云娥","COURSEDATE":"16","ID":"ff8080815bcd2935015bcd7b40d20015","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=ff8080815bcd2935015bcd7b40d20015","IMGURL":"http://hzph.p.webtrn.cn/entity/mobileStudent/images/thumbs/courseImg11.png","RN":"3","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"课程空间010"},{"PINGFEN":"0","COUNT":"14","TEACHERNAME":"123","COURSEDATE":"12","ID":"4028ad0c5a1c8534015a1ca65e54000a","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad0c5a1c8534015a1ca65e54000a","IMGURL":"http://hzph.p.webtrn.cn/entity/mobileStudent/images/thumbs/courseImg11.png","RN":"4","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"直播课程003"}],"curPage":1}
     * errorCode : 1
     * errorMessage : 成功
     */

    private DataBean data;
    private String errorCode;
    private String errorMessage;

    @Override
    public String toString() {
        return "ZQRemen{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "pageSize=" + pageSize +
                    ", orderBy='" + orderBy + '\'' +
                    ", totalCount=" + totalCount +
                    ", curPage=" + curPage +
                    ", items=" + items +
                    '}';
        }

        /**
         * pageSize : 4
         * orderBy : 0
         * totalCount : 68
         * items : [{"PINGFEN":"0","COUNT":"26","TEACHERNAME":"无","COURSEDATE":"1","ID":"4028ad0c59824a2e0159824cc0010007","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad0c59824a2e0159824cc0010007","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/0zlr0vls08.jpg","RN":"1","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"课程空间007"},{"PINGFEN":"6.0","COUNT":"19","TEACHERNAME":"万勇","COURSEDATE":"3","ID":"4028ad225a8492a7015a8497bbdd0000","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad225a8492a7015a8497bbdd0000","IMGURL":"http://hzph.p.webtrn.cn/incoming/photo/9vr62ckokr.jpg","RN":"2","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"app测试长度测试长度测试长度测试"},{"PINGFEN":"0.0","COUNT":"16","TEACHERNAME":"桂云娥","COURSEDATE":"16","ID":"ff8080815bcd2935015bcd7b40d20015","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=ff8080815bcd2935015bcd7b40d20015","IMGURL":"http://hzph.p.webtrn.cn/entity/mobileStudent/images/thumbs/courseImg11.png","RN":"3","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"课程空间010"},{"PINGFEN":"0","COUNT":"14","TEACHERNAME":"123","COURSEDATE":"12","ID":"4028ad0c5a1c8534015a1ca65e54000a","WEBURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad0c5a1c8534015a1ca65e54000a","IMGURL":"http://hzph.p.webtrn.cn/entity/mobileStudent/images/thumbs/courseImg11.png","RN":"4","MOREURL":"http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action","TITLE":"直播课程003"}]
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
            @Override
            public String toString() {
                return "ItemsBean{" +
                        "PINGFEN='" + PINGFEN + '\'' +
                        ", COUNT='" + COUNT + '\'' +
                        ", TEACHERNAME='" + TEACHERNAME + '\'' +
                        ", COURSEDATE='" + COURSEDATE + '\'' +
                        ", ID='" + ID + '\'' +
                        ", WEBURL='" + WEBURL + '\'' +
                        ", IMGURL='" + IMGURL + '\'' +
                        ", RN='" + RN + '\'' +
                        ", MOREURL='" + MOREURL + '\'' +
                        ", TITLE='" + TITLE + '\'' +
                        '}';
            }

            /**
             * PINGFEN : 0
             * COUNT : 26
             * TEACHERNAME : 无
             * COURSEDATE : 1
             * ID : 4028ad0c59824a2e0159824cc0010007
             * WEBURL : http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseDetaiToJsp.action?courseId=4028ad0c59824a2e0159824cc0010007
             * IMGURL : http://hzph.p.webtrn.cn/incoming/photo/0zlr0vls08.jpg
             * RN : 1
             * MOREURL : http://hzph.p.webtrn.cn/entity/mobile/mobileSortCourse_courseHotToJsp.action
             * TITLE : 课程空间007
             */



            private String PINGFEN;
            private String COUNT;
            private String TEACHERNAME;
            private String COURSEDATE;
            private String ID;
            private String WEBURL;
            private String IMGURL;
            private String RN;
            private String MOREURL;
            private String TITLE;

            public String getPINGFEN() {
                return PINGFEN;
            }

            public void setPINGFEN(String PINGFEN) {
                this.PINGFEN = PINGFEN;
            }

            public String getCOUNT() {
                return COUNT;
            }

            public void setCOUNT(String COUNT) {
                this.COUNT = COUNT;
            }

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
}
