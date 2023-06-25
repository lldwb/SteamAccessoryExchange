package top.lldwb.sae.pagingUtil;

import lombok.Data;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *分页视图类继承统一视图泛型类
 *
 */
@Data
public class PageVO<T> extends ResultVO<T> {

    /***
     * 存放总记录数量
     */
    private Long count ;
}
