package com.aistar.util;

import java.util.List;

/**
 * 页码+数据
 */
public class PageUtil<T> {

      private final int pageSize = 3 ;//(1)每页显示记录数
      private int totalSize ; //(2)总记录数
      private int totalPages; // (3)总页码
      private int   currentPage;// (4)当前页码
      private int startRecode;//(5)从第几条记录开始
      private int endRecode;   //  (6)到第几条记录结束
      private List<T> data;

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartRecode() {
        return startRecode;
    }

    public void setStartRecode(int startRecode) {
        this.startRecode = startRecode;
    }

    public int getEndRecode() {
        return endRecode;
    }

    public void setEndRecode(int endRecode) {
        this.endRecode = endRecode;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", startRecode=" + startRecode +
                ", endRecode=" + endRecode +
                ", data=" + data +
                '}';
    }
}
