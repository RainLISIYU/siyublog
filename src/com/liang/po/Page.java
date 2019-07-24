package com.liang.po;

import java.util.*;

public class Page {

    private int currentPage;
    private int countPage;
    private final int PAGE_SIZE = 5;
    private int allCount;

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    private List<Essay> essays;

    public List<Essay> getEssays() {
        return essays;
    }

    public void setEssays(List<Essay> essays) {
        this.essays = essays;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPAGE_SIZE() {
        return PAGE_SIZE;
    }

    public int getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
