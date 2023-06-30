package top.lldwb.sae.utils.vo;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BaseController {

    public <T> ResultVO<T> success(T data) {
        ResultVO<T> vo = new ResultVO<>();
        vo.setCode(200);
        vo.setData(data);
        return vo;
    }

    public ResultVO success() {
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        return vo;
    }

    public <T> ResultVO<List<T>> pageResult(long total, List<T> list) {
        PageVO vo = new PageVO();
        vo.setCode(0);
        vo.setCount(total);
        vo.setData(list);
        return vo;
    }

    public ResultVO fail(int code, String message) {
        ResultVO vo = new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
    
}
