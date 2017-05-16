package com.akina.util.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  16:56
 * @Describe ： 分页实体
 */
public class CutPageBean {

    /***
     * 数据集合
     */
    private List<?> dataList = new ArrayList<Object>();

    /***
     * 记录总条数
     */
    private int count;

    /**
     * 总页数
     */
    private int totalPage;

    @Override
    public String toString() {
        return "PageBean [dataList=" + dataList + ", count=" + count + ", totalPage=" + totalPage + "]";
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
