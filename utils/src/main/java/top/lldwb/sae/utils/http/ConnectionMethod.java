package top.lldwb.sae.utils.http;

import lombok.AllArgsConstructor;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@AllArgsConstructor
public enum ConnectionMethod {
    GET("GET"),POST("POST");
    final String value;
}
