package top.lldwb.sae.entity.commodityclass;

/**
 * @version v1.0
 * @Date 2023/6/28 19:46
 * @Author xiao
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

/**
 * 商品父类表 - commodity_class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityClass {


    @Column("class_id")
    private String classId; //道具分类id，代表一类基础属性相同的道具
    @Column("class_name")
    private String className;   //	非空	名称
    @Column("class_url")
    private String classUrl;    //	非空	图片url
    @Column("class_url_large")
    private String classUrlLarge;   //		大尺寸的图片url
    @Column("class_descriptions")
    private String classDescriptions;   //	非空	说明
    @Column("class_actions")
    private String classActions;    //	非空	打开游戏查看的链接

}
