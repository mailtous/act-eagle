package com.dayi35.framework.page;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeton on 9/25/17.
 */
public class  Page<T> implements Serializable {
    // -- 公共变量 --//
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    public static final int DEFAULT_PAGE_SIZE = 10;
    // -- 分页参数 --//
    protected int pageNo = 1;
    protected int pageSize = DEFAULT_PAGE_SIZE;
    protected String sf = "";      //排序字段，获得排序字段,无默认值.多个排序字段时用','分隔.
    protected String sc = "";      //排序方向，可选值为desc或asc,多个排序字段时用','分隔
    protected boolean autoCount = true;
    protected String[] groupBy;    //分组条件

    protected List<T> items = new ArrayList<T>();  //返回数据列表
    protected long total = 0;  //总条数

    protected String url; //页面的URL

    public Page() {
    }

    public Page(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    public Page<T> pageNo(final int thePageNo) {
        setPageNo(thePageNo);
        return this;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为1.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;

        if (pageSize < 1) {
            this.pageSize = 1;
        }
    }

    public Page<T> pageSize(final int thePageSize) {
        setPageSize(thePageSize);
        return this;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
     */
    public int getFirst() {
        return (pageNo - 1) * pageSize;
    }

    public int getShowSize(){
        if(null == items){
            return getFirst();
        }
        return getFirst() + items.size();
    }


    /**
     * 设置排序字段,多个排序字段时用','分隔.
     */
    public void setSf(final String sortByField) {
        this.sf = sortByField;
    }

    public String getSf() {
        return sf;
    }

    /**
     * 获得排序方向.
     */
    public String getsc() {
        return sc;
    }

    /**
     * 设置排序方式向.
     *
     * @param sc 可选值为desc或asc,多个排序字段时用','分隔.
     */
    public Page<T> setSc(final String sc) {
        // 检查order字符串的合法值
        String[] orders = StringUtils.split(StringUtils.lowerCase(sc), ',');
        for (String orderStr : orders) {
            if (!StringUtils.equals(DESC, orderStr)
                    && !StringUtils.equals(ASC, orderStr)) {
                throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
            }
        }
        this.sc = StringUtils.lowerCase(sc);
        return this;
    }

    /**
     * 是否已设置排序字段,无默认值.
     */
    public boolean isOrderBySetted() {
        return (StringUtils.isNotBlank(sf) && StringUtils
                .isNotBlank(sc));
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数, 默认为true.
     */
    public boolean isAutoCount() {
        return autoCount;
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数.
     */
    public void setAutoCount(final boolean autoCount) {
        this.autoCount = autoCount;
    }

    public Page<T> autoCount(final boolean theAutoCount) {
        setAutoCount(theAutoCount);
        return this;
    }


    /**
     * 取得页内的记录列表.
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setItems(final List<T> items) {
        this.items = items;
    }

    /**
     * 取得总记录数, 默认值为0.
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置总记录数.
     */
    public void setTotal(final long total) {
        this.total = total;
    }

    /**
     * 根据pageSize与total计算总页数, 默认值为0.
     */
    public long getTotalPages() {
        if (total < 0) {
            return 0;
        }

        long count = total / pageSize;
        if (total % pageSize > 0) {
            count++;
        }
        return count;
    }

    /**
     * 是否还有下一页.
     */
    public boolean isHasNext() {
        return (pageNo + 1 <= getTotalPages());
    }

    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    public int getNextPage() {
        if (isHasNext()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }

    /**
     * 是否还有上一页.
     */
    public boolean isHasPre() {
        return (pageNo - 1 >= 1);
    }

    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    public int getPrePage() {
        if (isHasPre()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    public String[] getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String[] groupBy) {
        this.groupBy = groupBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
