package top.lldwb.sae.dao.aftersalescenter.impl;

import top.lldwb.sae.dao.aftersalescenter.HandleDao;
import top.lldwb.sae.entity.aftersalescenter.Handle.Handle;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 19:42
 * @Author xiao
 */
public class HandleDaoImpl implements HandleDao {
    @Override
    public int insert(Handle handle) {
        MySqlUtil mySqlUtil = null;
        Object[] obj = {
                handle.getWoId(),
                handle.getRefundId(),
                handle.getHandleResult(),
                handle.getHandleTime(),
                handle.getHandleType()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="INSERT into handle(wo_id,refund_id,handle_result,handle_time,handle_type) VALUES(?,?,?,?,?);" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int handleId) {
        MySqlUtil mySqlUtil = null;

        try {
            mySqlUtil = new MySqlUtil();
            String sql =" delete FROM handle\n" +
                    "        where handle_id = ?;" ;
            int update = mySqlUtil.update(sql, handleId);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int update(Handle handle) {
        MySqlUtil mySqlUtil = null;
        Object[] obj = {
                handle.getWoId(),
                handle.getRefundId(),
                handle.getHandleResult(),
                handle.getHandleTime(),
                handle.getHandleType(),
                handle.getHandleId()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="UPDATE handle\n" +
                    "SET wo_id =?\n" +
                    ",refund_id =?\n" +
                    ",handle_result =?\n" +
                    ",handle_time =?\n" +
                    ",handle_type =? \n" +
                    "WHERE handle_id = ?" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Handle select(int handleId) {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select " +
                    "handle_id" +
                    ",wo_id" +
                    ",refund_id" +
                    ",handle_result" +
                    ",handle_time" +
                    ",handle_type" +
                    " from handle\n" +
                    " WHERE handle_id = ?;" ;
            return mySqlUtil.queryT(Handle.class, sql, handleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Handle> select() {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select " +
                    "handle_id" +
                    ",wo_id" +
                    ",refund_id" +
                    ",handle_result" +
                    ",handle_time" +
                    ",handle_type" +
                    " from handle\n" +
                    " WHERE handle_id = ?;" ;
            return mySqlUtil.queryList(Handle.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
