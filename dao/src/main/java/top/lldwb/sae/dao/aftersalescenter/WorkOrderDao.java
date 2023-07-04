package top.lldwb.sae.dao.aftersalescenter;

import top.lldwb.sae.entity.aftersalescenter.WorkOrder;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:19
 * @Author xiao
 */
public interface WorkOrderDao {
    int insert(WorkOrder workOrder);

    int delete(int workId);

    int update(WorkOrder workOrder);

    WorkOrder select(int workId);

    List<WorkOrder> select();
}
