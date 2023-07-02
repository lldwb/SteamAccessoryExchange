package top.lldwb.sae.api.controller.ai;

import com.yupi.yucongming.dev.model.DevChatResponse;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.utils.ai.AiAssistant;
import top.lldwb.sae.utils.vo.ResultVO;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Dialogue  extends BaseController{
    @RequestMapping("/ai/dialogue")
    public View dialogue(@RequestParam("questions") String questions) {
        ResultVO<DevChatResponse> resultVO = success(AiAssistant.dialogue(questions).getData());
        return new JsonView(resultVO);
    }
}
