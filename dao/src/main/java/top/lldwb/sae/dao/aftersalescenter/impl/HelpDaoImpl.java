package top.lldwb.sae.dao.aftersalescenter.impl;

import top.lldwb.sae.dao.aftersalescenter.HelpDao;
import top.lldwb.sae.entity.aftersalescenter.Help;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:07
 * @Author xiao
 */
public class HelpDaoImpl implements HelpDao {
    @Override
    public int insert(Help help) {
        MySqlUtil mySqlUtil;
        Object[] obj = {
                help.getHelpType(),
                help.getHelpContent(),
                help.getHelpState(),
                help.getHelpTime()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="INSERT into help(help_type,help_content,help_state,help_time)" +
                    " VALUES(?,?,?,?);" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int helpId) {
        MySqlUtil mySqlUtil;

        try {
            mySqlUtil = new MySqlUtil();
            String sql =" delete FROM help\n" +
                    " where help_id = ?" ;
            int update = mySqlUtil.update(sql, helpId);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Help help) {
        MySqlUtil mySqlUtil;
        Object[] obj = {
                help.getHelpType(),
                help.getHelpContent(),
                help.getHelpState(),
                help.getHelpTime(),
                help.getHelpId()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="UPDATE help\n" +
                    "SET help_type =?\n" +
                    ",help_content =?\n" +
                    ",help_state =?\n" +
                    ",help_time =?\n" +
                    "WHERE help_id = ?" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Help select(int helpId) {
        MySqlUtil mySqlUtil;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select help_id,help_type,help_content,help_state,help_time from help\n" +
                    "WHERE help_id = ?;" ;
            return mySqlUtil.queryT(Help.class, sql, helpId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Help> select() {
        MySqlUtil mySqlUtil;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select help_id,help_type,help_content,help_state,help_time from help;" ;
            return mySqlUtil.queryList(Help.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
