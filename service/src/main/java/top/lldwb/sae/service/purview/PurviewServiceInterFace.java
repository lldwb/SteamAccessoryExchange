package top.lldwb.sae.service.purview;

import top.lldwb.sae.entity.purview.Purview;

import java.util.List;

/***
 * @Date(时间)2023-06-26
 * @Author 家辉
 *
 * 权限业务抽象接口
 */
public interface PurviewServiceInterFace {
    /***
     * 添加权限
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param userId FK用户userid
     * @return
     */
    int purviewADD(String purviewLimitation ,String purviewDescribe,int userId) ;
    /***
     * 根据id修改数据
     * @param id
     * @return
     */
    int purviewDelete(int id) ;

    /***
     * 根据id和根据用户id删除
     * @param purvoewId id
     * @param userId 用户id
     * @return
     */
    int purviewDelete(int purvoewId ,int userId) ;

    /***
     * 修改数据
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param userId FK用户UserId
     * @param purviewId id
     * @return
     */
    int purviewUpdate(String purviewLimitation ,String purviewDescribe,int userId,int purviewId) ;

    /***
     * 查询所有
     * @return
     */
    List<Purview> purviewList() ;


    /***
     * 根据条件ID查询权限数据
     * @param id
     * @return
     */
    Purview purviewUserIDQuery(int id);


}
