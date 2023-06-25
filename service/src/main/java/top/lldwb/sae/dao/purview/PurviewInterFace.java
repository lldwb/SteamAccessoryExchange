package top.lldwb.sae.dao.purview;

import top.lldwb.sae.entity.purview.Purview;

import java.util.List;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 权限接口抽象类
 */
public interface PurviewInterFace {

    /***
     * 添加数据
     * @param purview
     * @return
     */
    int purviewADD(Purview purview) ;

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
     * @param purview
     * @return
     */
    int purviewUpdate(Purview purview) ;

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
