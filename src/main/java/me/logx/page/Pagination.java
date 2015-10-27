/*
 * Hundsun Inc.
 * Copyright (c) 2006-2009 All Rights Reserved.
 *
 * Author     :zhengdd
 * Version    :1.0
 * Create Date:2010-3-25
 */
package me.logx.page;

import java.util.List;

/**
 * ����JEECMS�еķ�ҳPagination�࣬ʵ����Paginable�ӿڵ�getDate()������
 *
 */
public class Pagination<T> extends SimplePage<T> {

    private static final long serialVersionUID = 6398443093873035070L;

    public Pagination() {
    }

    public Pagination(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    public Pagination(int pageNo, int pageSize, int totalCount, List<T> list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * ��ǰҳ������
     */
    private List<T> list;

    /**
     * ȡ�÷�ҳ����
     *
     * @return List<T> ��ҳ����
     */
    public List<T> getData() {
        return list;
    }

    /**
     * ���÷�ҳ����
     *
     * @param date ��ҳ����
     */
    public void setData(List<T> data) {
        this.list = data;
    }

}
