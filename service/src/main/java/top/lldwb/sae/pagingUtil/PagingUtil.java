package top.lldwb.sae.pagingUtil;

import java.util.List;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 分页工具类
 */
public class PagingUtil {

    /***
     * 计算出从几页开始
     * @param page
     * @param limit
     * @return
     */
    public static int toNumbers(int page , int limit) {
        return page <= 1 ? 0 : (page-1) * limit ;
    }


    /***
     *封装PageVO对象
     * @param list 存放的list集合数据
     * @param count 总记录数
     * @return 返回
     * @param <T> 泛型，数据参数化
     */
    public static <T> PageVO<List<T>> toPageVO(List<T> list,Long count){
        //调用PageVo泛型类
        PageVO<List<T>> pageVO = new PageVO<>() ;
        //引用填充数据
        pageVO.setCount(count);
        pageVO.setData(list);
        pageVO.setCode(0);

        //返回
        return pageVO ;
    }

}
