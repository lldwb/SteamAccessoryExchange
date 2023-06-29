package top.lldwb.sae.utils.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;

/**
 * 没有历史会话功能
 * @author 安然的尾巴
 * @version 1.0
 */
public class AiAssistant {
    private static final String accessKey = "6s79fihwbqimxso8865fevxsndood42g";
    private static final String secretKey = "owiqfxbwd43m1dnvqfjq2wku69zl198f";

    /**
     * AI对话
     *
     * @param questions 对话
     * @return
     */
    public static String dialogue(String questions) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1674217456220057601L);
        devChatRequest.setMessage(questions);
        return doChat(devChatRequest);
    }

    /**
     * 发起对话
     *
     * @param devChatRequest
     * @return
     */
    private static String doChat(DevChatRequest devChatRequest) {
        YuCongMingClient client = new YuCongMingClient(accessKey, secretKey);

        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        System.out.println(response.getData());
        try {
            return new ObjectMapper().writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
