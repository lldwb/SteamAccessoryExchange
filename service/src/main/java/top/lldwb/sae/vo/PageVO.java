package top.lldwb.sae.vo;

import lombok.Data;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class PageVO<T> extends ResultVO<T> {
    /**
     * 总记录数
     */
    private Long count;
}
