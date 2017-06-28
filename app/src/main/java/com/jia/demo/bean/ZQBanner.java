package com.jia.demo.bean;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/7.
 * 人之所以能，是相信能
 */
public class ZQBanner {


    /**
     * pageSize : 5
     * orderBy : 0
     * totalCount : 8
     * items : [{"WEBURL":"http://hzph.p.webtrn.cn/cms/sikuku/23161.htm","IMGURL":"http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_2/5_27/7hu5j36zjalp.jpg","RN":"1","TITLE":"测试"},{"WEBURL":"http://hzph.p.webtrn.cn/cms/sikuku/23081.htm","IMGURL":"http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_2/4_1/s5d0j0yugmxb.jpg","RN":"2","TITLE":"四库图片"},{"WEBURL":"http://hzph.p.webtrn.cn/cms/sikuku/23043.htm","IMGURL":"http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_1/3_8/9qtrj00nfv7j.png","RN":"3","TITLE":"新的四库图片2"},{"WEBURL":"http://hzph.p.webtrn.cn/cms/sikuku/23041.htm","IMGURL":"http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_1/3_8/hg4vj00ng77g.png","RN":"4","TITLE":"新的四库图片"},{"WEBURL":"http://hzph.p.webtrn.cn/cms/sikuku/23001.htm","IMGURL":"http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_1/3_8/79bej00ngs6o.png","RN":"5","TITLE":"测试"}]
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
         * WEBURL : http://hzph.p.webtrn.cn/cms/sikuku/23161.htm
         * IMGURL : http://hzph.p.webtrn.cn/cms/res_base/saccms_com_www/upload/article/image/2017_2/5_27/7hu5j36zjalp.jpg
         * RN : 1
         * TITLE : 测试
         */

        private String WEBURL;
        private String IMGURL;
        private String RN;
        private String TITLE;

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

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }
    }
}
