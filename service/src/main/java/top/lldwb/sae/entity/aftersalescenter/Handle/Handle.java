package top.lldwb.sae.entity.aftersalescenter.Handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.sql.Timestamp;

/**
 * @version v1.0
 * @Date 2023/6/21 15:04
 * @Author xiao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Handle {
    /**
     * 处理ID
     */
    @Column("handle_id")
    private Integer handleId;
    /**
     * 工单id
     */
    @Column("wo_id")
    private	Integer woId;
    /**
     * 退款id
     */
    @Column("refund_id")
    private	Integer	refundId;
    /**
     * 处理结果
     */
    @Column("handle_result")
    private	String handleResult;
    /**
     * 时间
     */
    @Column("handle_time")
    private Timestamp 	handleTime;
    /**
     * 问题类型
     */
    @Column("handle_type")
    private	Integer	handleType;
}
