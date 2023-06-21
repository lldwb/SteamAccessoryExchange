package top.lldwb.sae.service.service.code;

import top.lldwb.sae.service.entity.code.CodeTable;

/***
 * @Date(时间)2023-06-21
 * @Author 家辉
 *
 * 验证码接口
 */
public interface CodeTableInterFace {

    /***
     * 登录添加验证码业务类
     * @param emailCode 随机验证码
     * @param userEmail 邮箱地址
     * @return
     */
     int loginaddCode(String emailCode,String userEmail) ;




    /***
     * 注册添加验证码业务类
     * @param emailCode
     * @return
     */
    int loginUpdateaddCode(String emailCode) ;
}
