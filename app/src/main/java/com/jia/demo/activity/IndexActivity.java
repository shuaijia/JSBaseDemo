package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.adapter.IndexAdapter;
import com.jia.demo.bean.IndexEntry;
import com.jia.demo.view.JsIndexBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Describtion:
 * Created by jia on 2017/4/6
 * 人之所以能，是相信能
 */
public class IndexActivity extends Activity {

    private RecyclerView rv;
    private JsIndexBar indexBar;

    private IndexAdapter mAdapter;

    private List<IndexEntry> list = new ArrayList<>();

    private LinearLayoutManager layoutManager;

    private View vFlow;
    private TextView tvFlowIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        rv = (RecyclerView) findViewById(R.id.rv_index_content);
        indexBar = (JsIndexBar) findViewById(R.id.ib_index);

        initData();

        initIndex();

        initFlowIndex();
    }

    private void initData() {
        Map<String, Object> map = convertSortList(getData());
        list.clear();
        list.addAll((List<IndexEntry>) map.get("sortList"));

        // 获取索引值
        Object[] keys = (Object[]) map.get("keys");
        String[] letters = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            letters[i] = keys[i].toString();

        }
        indexBar.setIndexs(letters);

        mAdapter=new IndexAdapter(IndexActivity.this,list);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(mAdapter);
    }

    private void initIndex(){
        TextView tvToast = (TextView) findViewById(R.id.tv_toast);
        indexBar.setSelectedIndexTextView(tvToast);
        indexBar.setOnIndexChangedListener(new JsIndexBar.OnIndexChangedListener() {
            @Override
            public void onIndexChanged(String index) {
                for (int i = 0; i < list.size(); i++) {
                    String firstWord = list.get(i).getFirstWord();
                    if (index.equals(firstWord)) {
                        // 滚动列表到指定的位置
                        layoutManager.scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    /**
     * 初始化顶部悬浮标签
     */
    private void initFlowIndex() {
        vFlow = findViewById(R.id.ll_index);
        tvFlowIndex = (TextView) findViewById(R.id.tv_index);
        rv.addOnScrollListener(new mScrollListener());
        //设置首项的索引字母
        if (list.size() > 0) {
            tvFlowIndex.setText(list.get(0).getFirstWord());
            vFlow.setVisibility(View.VISIBLE);
        }
    }

    private List<IndexEntry> getData() {
        List<IndexEntry> list = new ArrayList<>();
        list.add(new IndexEntry("加内特", "J"));
        list.add(new IndexEntry("韦德", "W"));
        list.add(new IndexEntry("詹姆斯", "Z"));
        list.add(new IndexEntry("安东尼", "A"));
        list.add(new IndexEntry("科比", "K"));
        list.add(new IndexEntry("乔丹", "Q"));
        list.add(new IndexEntry("奥尼尔", "A"));
        list.add(new IndexEntry("麦格雷迪", "M"));
        list.add(new IndexEntry("艾弗森", "A"));
        list.add(new IndexEntry("哈达威", "H"));
        list.add(new IndexEntry("纳什", "N"));
        list.add(new IndexEntry("弗朗西斯", "F"));
        list.add(new IndexEntry("姚明", "Y"));
        list.add(new IndexEntry("库里", "K"));
        list.add(new IndexEntry("邓肯", "D"));
        list.add(new IndexEntry("吉诺比利", "J"));
        list.add(new IndexEntry("帕克", "P"));
        list.add(new IndexEntry("杜兰特", "D"));
        list.add(new IndexEntry("韦伯", "W"));
        list.add(new IndexEntry("威斯布鲁克", "W"));
        list.add(new IndexEntry("霍华德", "H"));
        list.add(new IndexEntry("保罗", "B"));
        list.add(new IndexEntry("罗斯", "L"));
        list.add(new IndexEntry("加索尔", "J"));
        list.add(new IndexEntry("隆多", "L"));
        list.add(new IndexEntry("诺维斯基", "N"));
        list.add(new IndexEntry("格里芬", "G"));
        list.add(new IndexEntry("波什", "B"));
        list.add(new IndexEntry("伊戈达拉", "Y"));
        return list;
    }

    /**
     * 按首字母将数据排序
     *
     * @param list 需要排序的数组
     * @return 返回按首字母排序的集合（集合中插入标签项），及所有出现的首字母数组
     */
    public Map<String, Object> convertSortList(List<IndexEntry> list) {
        HashMap<String, List<IndexEntry>> map = new HashMap<>();
        for (IndexEntry item : list) {
            String firstWord;
            if (TextUtils.isEmpty(item.getFirstWord())) {
                firstWord = "#";
            } else {
                firstWord = item.getFirstWord().toUpperCase();
            }
            if (map.containsKey(firstWord)) {
                map.get(firstWord).add(item);
            } else {
                List<IndexEntry> mList = new ArrayList<>();
                mList.add(item);
                map.put(firstWord, mList);
            }
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        List<IndexEntry> sortList = new ArrayList<>();

        for (Object key : keys) {
            IndexEntry t = getIndexItem(key.toString());
            sortList.add(t);
            sortList.addAll(map.get(key));
        }

        HashMap<String, Object> resultMap = new HashMap();
        resultMap.put("sortList", sortList);
        resultMap.put("keys", keys);
        return resultMap;
    }

    private IndexEntry getIndexItem(String firstWord) {
        IndexEntry entity = new IndexEntry();
        entity.setFirstWord(firstWord);
        entity.setIndex(true);
        return entity;
    }

    class mScrollListener extends RecyclerView.OnScrollListener {

        private int mFlowHeight;
        private int mCurrentPosition = -1;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            mFlowHeight = vFlow.getMeasuredHeight();
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            View view = layoutManager.findViewByPosition(firstVisibleItemPosition + 1);

            if (view != null) {
                if (view.getTop() <= mFlowHeight && isItem(firstVisibleItemPosition + 1)) {
                    vFlow.setY(view.getTop() - mFlowHeight);
                } else {
                    vFlow.setY(0);
                }
            }

            if (mCurrentPosition != firstVisibleItemPosition) {
                mCurrentPosition = firstVisibleItemPosition;
                tvFlowIndex.setText(list.get(mCurrentPosition).getFirstWord());
            }
        }

        /**
         * @param position 对应项的下标
         * @return 是否为标签项
         */
        private boolean isItem(int position) {
            return mAdapter.getItemViewType(position) == IndexAdapter.TYPE_INDEX;
        }
    }
}
