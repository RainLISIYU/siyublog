package com.liang.dao;

import com.liang.po.Essay;
import com.liang.po.Page;

import java.sql.SQLException;
import java.util.*;

public interface EssayDao {
    /**
     * 查询所有的博客
     * @return 博客列表
     */
    List<Essay> findAll();

    /**
     * 添加文章
     * @param essay
     * @return
     */
    boolean insertEssay(Essay essay);

    /**
     * 找到对应用户的文章
     * @param uName
     * @return
     */
    List<Essay> findUserAllEssay(String uName);

    /**
     * 删除对应的文章
     * @param eId
     */
    void deleteEssay(int eId);

    /**
     * 模糊查询
     * @param uName
     * @return
     */
    List<Essay> findUsersAllEssay(String uName);

    /**
     * 分页查询某一页
     * @param page
     * @return
     */
    List<Essay> findSomeEssay(Page page);

    /**
     * 总记录数
     * @return count
     */
    int findAllCount();

    /**
     * 对应用户的分页查询
     * @param page
     * @param uName
     * @return
     */
    List<Essay> findUserSomeEssay(Page page, String uName);

    /**
     * 输出对应用户的文章数
     * @param uName
     * @return
     */
    int findUserCount(String uName);

    /**
     * 更新权限
     * @param eId
     * @param ePower
     * @return
     */
    boolean updatePower(int eId, int ePower);
}
