package top.lldwb.sae.dao.Aftersalescenter.impl;

import top.lldwb.sae.dao.Aftersalescenter.DAO.WorkOrderDao;
import top.lldwb.sae.entity.Aftersalescenter.WorkOrder.WorkOrder;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:21
 * @Author xiao
 */
public class WorkOrderDaoImpl implements WorkOrderDao {
    @Override
    public Integer insert(WorkOrder workOrder) {
        MySqlUtil mySqlUtil = null;
        Object[] obj = {
                workOrder.getWoType(),
                workOrder.getWoContent(),
                workOrder.getWoResult(),
                workOrder.getWoTime(),
                workOrder.getWoRenewTime()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="INSERT into work_order(wo_type,wo_content,wo_result,wo_time,wo_renew_time) " +
                    "VALUES(?,?,?,?,?);" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer delete(int workId) {
        MySqlUtil mySqlUtil = null;

        try {
            mySqlUtil = new MySqlUtil();
            String sql =" delete FROM work_order\n" +
                    "where wo_id = ?\n" ;
            int update = mySqlUtil.update(sql, workId);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer update(WorkOrder workOrder) {
        MySqlUtil mySqlUtil = null;
        Object[] obj = {
                workOrder.getWoType(),
                workOrder.getWoContent(),
                workOrder.getWoResult(),
                workOrder.getWoTime(),
                workOrder.getWoRenewTime(),
                workOrder.getWoId()
        };
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="UPDATE work_order\n" +
                    "SET \n" +
                    " wo_type =?\n" +
                    ",wo_content =?\n" +
                    ",wo_result =?\n" +
                    ",wo_time =?\n" +
                    ",wo_renew_time = ?\n" +
                    "WHERE wo_id = ?" ;
            int update = mySqlUtil.update(sql, obj);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WorkOrder select(int workId) {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select wo_id,wo_type,wo_content,wo_result,wo_time,wo_renew_time from work_order\n" +
                    "WHERE wo_id = ?;" ;
            return mySqlUtil.queryT(WorkOrder.class, sql, workId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<WorkOrder> select() {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="select wo_id,wo_type,wo_content,wo_result,wo_time,wo_renew_time from work_order;" ;
            return mySqlUtil.queryList(WorkOrder.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
