package top.lldwb.sae.entity.Aftersalescenter.Help;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.sql.Timestamp;

/**
 * @version v1.0
 * @Date 2023/6/21 14:58
 * @Author xiao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Help {
    /**
     * 帮助ID
     */
    @Column("help_id")
    private Integer helpId;
    /**
     * 类型
     */
    @Column("help_type")
    private int  helpType;
    /**
     * 内容
     */
    @Column("help_content")
    private String helpContent;
    /**
     * 状态
     */
    @Column("help_state")
    private Integer helpState;
    /**
     * 时间
     */
    @Column("help_time")
    private Timestamp helpTime;

}
