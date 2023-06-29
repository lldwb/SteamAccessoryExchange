package top.lldwb.sae.utils.ai;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;

/**
 * 没有历史会话功能
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class AiAssistant {
    private static final String accessKey = "6s79fihwbqimxso8865fevxsndood42g";
    private static final String secretKey = "owiqfxbwd43m1dnvqfjq2wku69zl198f";
    private static DevChatRequest devChatRequest = new DevChatRequest();
    static{
        devChatRequest.setModelId(1674320317113249793L);
    }

    /**
     * AI对话
     *
     * @param questions 对话
     * @return
     */
    public static BaseResponse<DevChatResponse> dialogue(String questions) {
        devChatRequest.setMessage(questions);
        return doChat(devChatRequest);
    }

    /**
     * 发起对话
     *
     * @param devChatRequest
     * @return
     */
    private static BaseResponse<DevChatResponse> doChat(DevChatRequest devChatRequest) {
        YuCongMingClient client = new YuCongMingClient(accessKey, secretKey);

        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        System.out.println(response.getData());
        return response;
    }
}
