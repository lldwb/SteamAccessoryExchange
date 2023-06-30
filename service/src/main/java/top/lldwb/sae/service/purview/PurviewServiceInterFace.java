package top.lldwb.sae.service.purview;

import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.utils.vo.PageVO;

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
     * @param roleID FK用户userid
     * @return
     */
    int purviewADD(String purviewLimitation ,String purviewDescribe,int roleID) ;
    /***
     * 根据id删除数据
     * @param id
     * @return
     */
    int purviewDelete(int id) ;

    /***
     * 根据id和根据用户id删除
     * @param purvoewId id
     * @param roleID 角色id
     * @return
     */
    int purviewDelete(int purvoewId ,int roleID) ;

    /***
     * 修改数据
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param roleID FK用户roleID
     * @param purviewId id
     * @return
     */
    int purviewUpdate(String purviewLimitation ,String purviewDescribe,int roleID,int purviewId) ;

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
    Purview purviewRoleIDQuery(int id);


    /***
     * 分页查询
     * @param purviewLimitation
     * @param purviewDescribe
     * @param page
     * @param limit
     * @return
     */
    PageVO<List<Purview>> queryLimitPurview(String  purviewLimitation, String purviewDescribe, int page, int limit) ;
}
