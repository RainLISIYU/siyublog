package com.liang.dao;

import com.liang.po.Reply;

import java.sql.SQLException;
import java.util.List;

public interface ReplyDao {
    /**
     * 返回对应文章的所有回复
     * @param eId
     * @return
     */
    List<Reply> findAllReply(int eId);

    /**
     * 将回复写入数据库
     * @param reply
     */
    void insertReply(Reply reply);

    /**
     * 删除对应的回复
     * @param rId
     */
    void deleteReply(int rId);
}
