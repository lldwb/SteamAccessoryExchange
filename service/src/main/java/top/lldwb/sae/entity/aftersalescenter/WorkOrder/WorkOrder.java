package top.lldwb.sae.entity.aftersalescenter.WorkOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.sql.Timestamp;

/**
 * @version v1.0
 * @Date 2023/6/21 15:10
 * @Author xiao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkOrder<T> {
    /**
     * 工单ID
     */
    @Column("wo_id")
    private Integer woId;
    /**
     * 类型
     */
    @Column("wo_type")
    private Integer woType;
    /**
     * 内容(json格式)
     */
    @Column("wo_content")
    private T woContent;
    /**
     *
     */
    @Column("wo_result")
    private Integer woResult;
    /**
     * 创建时间
     */
    @Column("wo_time")
    private Timestamp woTime;
    /**
     * 更新时间
     */
    @Column("wo_renew_time")
    private Timestamp woRenewTime;

}
