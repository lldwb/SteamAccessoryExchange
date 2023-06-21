package top.lldwb.sae.service.service.code.impl;

import top.lldwb.sae.service.dao.code.CodeInterFace;
import top.lldwb.sae.service.dao.code.impl.CodeDAO;
import top.lldwb.sae.service.dao.user.UserFace;
import top.lldwb.sae.service.dao.user.impl.UserDAO;
import top.lldwb.sae.service.entity.code.CodeTable;
import top.lldwb.sae.service.entity.user.User;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.service.code.CodeTableInterFace;

/***
 * @Date(时间)2023-06-21
 * @Author 家辉
 *
 * 验证码业务类
 *
 * 代码测试已经通过，业务逻辑切勿乱修改
 */
public class CodeTableService implements CodeTableInterFace {
    /***
     * 用户登录添加验证码方法
     * @param emailCode 随机验证码
     * @param userEmail 邮箱地址
     * @return
     */
    @Override
    public int loginaddCode(String emailCode, String userEmail) {
        //调用用户数据业务类
        UserFace userface = new UserDAO() ;
        //实现方法
        User user = userface.loginEmail(userEmail);

        int row = 0;
        //判断一下user用户 id为空，如果为空则调用“注册专属添加验证码方法”反之调用“用户登录添加验证码方法”
        if(user==null){
            //调用注册专属添加验证码方法
            loginUpdateaddCode(emailCode) ;
        }else{
            CodeInterFace face = new CodeDAO();
            CodeTable entity = new CodeTable();
            entity.setCtCode(emailCode);
            entity.setCtValidOrNot(1);
            entity.setCtType(1);
            entity.setUserId(user.getUserId());

            //调用验证码数据访问类方法
            row = face.addCode(entity);
            if (row < 1) {
                throw new AllException(500, "验证码发送失败");
            }
        }
        return row;
    }


    /***
     * 注册专属添加邮箱发送
     * @param emailCode
     * @return
     */
    @Override
    public int loginUpdateaddCode(String emailCode) {
        //调用验证码数据访问类
        CodeInterFace face = new CodeDAO();

        //调用方法填充数据
        CodeTable entity = new CodeTable();
        entity.setCtCode(emailCode);
        entity.setCtValidOrNot(1);
        entity.setCtType(1);
        entity.setUserId(0);

        //调用验证码数据访问类方法
        int row = face.addCode(entity);
        if (row < 1) {
            throw new AllException(500, "验证码发送失败");
        }
        return row;
    }
}
