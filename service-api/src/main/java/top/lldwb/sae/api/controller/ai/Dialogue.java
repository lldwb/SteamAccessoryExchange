package top.lldwb.sae.api.controller.ai;

import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.utils.ai.AiAssistant;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Dialogue {
    @RequestMapping("/ai/dialogue")
    public View dialogue(@RequestParam("questions") String questions){
        ResultVO<BaseResponse<DevChatResponse>> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMessage("ai对话");
        resultVO.setData(AiAssistant.dialogue(questions));
        return new JsonView(resultVO);
    }
}
