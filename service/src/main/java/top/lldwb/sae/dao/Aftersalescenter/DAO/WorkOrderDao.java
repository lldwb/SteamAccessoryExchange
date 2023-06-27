package top.lldwb.sae.dao.Aftersalescenter.DAO;

import top.lldwb.sae.entity.Aftersalescenter.WorkOrder.WorkOrder;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:19
 * @Author xiao
 */
public interface WorkOrderDao {
    Integer insert(WorkOrder workOrder);

    Integer delete(int workId);

    Integer update(WorkOrder workOrder);

    WorkOrder select(int workId);

    List<WorkOrder> select();
}
