package com.liang.service;

import com.liang.dao.EssayDao;
import com.liang.daoimpl.EssayaDaoImpl;
import com.liang.po.Essay;
import com.liang.po.Page;

import java.sql.SQLException;
import java.util.*;

/**
 * essay 数据库的service
 * @author 梁思禹
 */
public class EssayService {

    public List<Essay> findAll() {
        EssayDao ed = new EssayaDaoImpl();
        return ed.findAll();
    }

    public boolean insertEssay(Essay essay){
        EssayDao ed = new EssayaDaoImpl();
        return ed.insertEssay(essay);
    }

    public List<Essay> findUserAllEssay(String uName){
        EssayDao ed = new EssayaDaoImpl();
        return ed.findUserAllEssay(uName);
    }

    public void deleteEssay(int eId){
        EssayDao ed = new EssayaDaoImpl();
        ed.deleteEssay(eId);
    }

    public List<Essay> findUsersAllEssay(String uName){
        EssayDao ed = new EssayaDaoImpl();
        return ed.findUsersAllEssay(uName);
    }

    private int findAllCount(){
        EssayDao ed = new EssayaDaoImpl();
        return ed.findAllCount();
    }

    /**
     * 返回所需Page
     * @param currentPage
     * @return
     */
    public Page getPage(int currentPage){
        Page page = new Page();
        int allCount = findAllCount();
        int pageSize = page.getPAGE_SIZE();
        int countPage = allCount/pageSize;
        page.setCurrentPage(currentPage);
        page.setAllCount(allCount);
        page.setCountPage(allCount%pageSize==0?countPage:countPage+1);
        page.setEssays(findSomeEssay(page));
        return page;
    }

    public List<Essay> findUserSomeEssay(Page page, String uName) {
        EssayDao ed = new EssayaDaoImpl();
        return ed.findUserSomeEssay(page, uName);
    }

    public int findUserCount(String uName){
        EssayDao ed = new EssayaDaoImpl();
        return ed.findUserCount(uName);
    }

    public Page getPage(int currentPage, String uName){
        Page page = new Page();
        int allCount = findUserCount(uName);
        int pageSize = page.getPAGE_SIZE();
        int countPage = allCount/pageSize;
        page.setCurrentPage(currentPage);
        page.setAllCount(allCount);
        page.setCountPage(allCount%pageSize==0?countPage:countPage+1);
        page.setEssays(findUserSomeEssay(page, uName));
        return page;
    }

    public boolean updatePower(int eId, int ePower){
        EssayDao ed = new EssayaDaoImpl();
        return ed.updatePower(eId, ePower);
    }

    private List<Essay> findSomeEssay(Page page){
        EssayDao ed = new EssayaDaoImpl();
        return ed.findSomeEssay(page);
    }

}
