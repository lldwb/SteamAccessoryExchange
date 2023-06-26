package top.lldwb.sae.pagingUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 统一视图，响应泛型类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultVO<T> {

    /***
     * 状态码
     */
    private Integer code ;

    /***
     * 响应回来的信息
     */
    private String massage ;

    /***
     *响应的数据
     */
    private T data ;


}
