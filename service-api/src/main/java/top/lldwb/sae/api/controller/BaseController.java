package top.lldwb.sae.api.controller;

import top.lldwb.sae.utils.vo.PageVO;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

/***
 * @Date(时间)2023-06-30
 * @Author 家辉
 */
public class BaseController {
    /**
     * 成功响应(比如在查询、第三方api等，需要返回数据的时候使用)
     *
     * @param data 数据
     * @param <T>
     * @return
     */
    public <T> ResultVO<T> success(T data) {
        ResultVO<T> vo = new ResultVO<>();
        vo.setCode(200);
        vo.setData(data);
        return vo;
    }

    /**
     * 成功响应(比如在添加、修改、删除等，不需要返回数据的时候使用)
     *
     * @return 空
     */
    public ResultVO success() {
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        return vo;
    }


    /**
     * 分页响应(比如在分页查询等，需要返回多条数据的时候使用)
     *
     * @param total
     * @param list
     * @param <T>
     * @return
     */
    public <T> ResultVO<List<T>> pageResult(long total, List<T> list) {
        PageVO vo = new PageVO();
        vo.setCode(0);
        vo.setCount(total);
        vo.setData(list);
        return vo;
    }

    /**
     * 错误响应
     *
     * @param code
     * @param message
     * @return
     */
    public ResultVO error(int code, String message) {
        ResultVO vo = new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
