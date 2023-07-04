package top.lldwb.sae.entity.activity;

import lombok.Data;
import org.nf.db.util.Column;
import java.time.LocalDateTime;

@Data
public class Activity {
             @Column("ac_id")
             private int ac_id;// 活动ID
             @Column("ac_theme")
             private String ac_theme;// 主题
             @Column("user_id")
             private int user_id;// 用户id
             @Column("ac_time")
             private LocalDateTime ac_time;// 发布时间
             @Column("ac_content")
             private String ac_content;//  内容
}
