package com.liang.service;

import com.liang.dao.ReplyDao;
import com.liang.daoimpl.ReplyDaoImpl;
import com.liang.po.Reply;

import java.sql.SQLException;
import java.util.*;

public class ReplyService {
    public List<Reply> findAllReply(int eId) {
        ReplyDao rd = new ReplyDaoImpl();
        return rd.findAllReply(eId);
    }

    public void insertReply(Reply reply){
        ReplyDao rd = new ReplyDaoImpl();
        rd.insertReply(reply);
    }

    public void deleteReply(int rId){
        ReplyDao rd = new ReplyDaoImpl();
        rd.deleteReply(rId);
    }
}
