package me.logx.page;

import java.util.Collection;

/**
 * ����JEECMS�еķ�ҳPaginable�ӿڣ������˻�÷�ҳ���ݵ�getDate()������
 * 
 */
public interface Paginable<T> {

    /**
     * �ܼ�¼��
     * 
     * @return int
     */
    public int getTotalCount();

    /**
     * ��ҳ��
     * 
     * @return int
     */
    public int getTotalPage();

    /**
     * ÿҳ��¼��
     * 
     * @return int
     */
    public int getPageSize();

    /**
     * ��ǰҳ��
     * 
     * @return int
     */
    public int getPageNo();

    /**
     * �Ƿ��һҳ
     * 
     * @return int
     */
    public boolean isFirstPage();

    /**
     * �Ƿ����һҳ
     * 
     * @return int
     */
    public boolean isLastPage();

    /**
     * ������ҳ��ҳ��
     * 
     * @return int
     */
    public int getNextPage();

    /**
     * ������ҳ��ҳ��
     * 
     * @return int
     */
    public int getPrePage();

    /**
     * ȡ�õ�ǰҳ��ʾ�������ʼ��� (1-based)��
     * 
     * @return int ��ʼ���
     */
    public int getBeginIndex();

    /**
     * ȡ�õ�ǰҳ��ʾ��ĩ����� (1-based)��
     * 
     * @return int ĩ�����
     */
    public int getEndIndex();

    /**
     * ȡ�÷�ҳ����
     * 
     * @return Collection<T> ��ҳ����
     */
    public Collection<T> getData();

}
