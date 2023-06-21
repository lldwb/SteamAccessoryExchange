package top.lldwb.sae.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应对象
 *
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {
    /**
     * 业务状态码
     */
    private Integer code;
    /**
     * 响应的消息
     */
    private String message;
    /**
     * 响应的数据
     */
    private T data;
}
