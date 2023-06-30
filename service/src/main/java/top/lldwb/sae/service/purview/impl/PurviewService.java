package top.lldwb.sae.service.purview.impl;

import top.lldwb.sae.dao.purview.PurviewInterFace;
import top.lldwb.sae.dao.purview.impl.PurviewDAO;
import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.purview.PurviewServiceInterFace;
import top.lldwb.sae.utils.vo.PageUtils;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.ArrayList;
import java.util.List;

/***
 * @Date(时间)2023-06-26
 * @Author 家辉
 *
 * 权限业务逻辑类
 */
public class PurviewService implements PurviewServiceInterFace {
    /***
     *
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param userId FK用户userid
     * @return
     */
    @Override
    public int purviewADD(String purviewLimitation, String purviewDescribe, int userId) {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //调用实体类
        Purview entity = new Purview() ;
        entity.setPurviewLimitation(purviewLimitation);
        entity.setPurviewDescribe(purviewDescribe);
        entity.setRoleId(userId);

        //引用dao方法
        int row = dao.purviewADD(entity) ;

        //判断
        if(row<1){
            throw  new AllException(500,"添加失败") ;
        }

        //返回结果集
        return row;
    }

    /***
     *
     * @param id 根据id删除
     * @return
     */
    @Override
    public int purviewDelete(int id) {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //引用dao方法
        int row = dao.purviewDelete(id) ;

        //判断
        if(row<1){
            throw new AllException(500,"删除失败") ;
        }

        //返回结果集
        return row;
    }

    /***
     *
     * @param purvoewId id
     * @param roleId 用户id
     * @return
     */
    @Override
    public int purviewDelete(int purvoewId, int roleId) {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //引用dao方法
        int row = dao.purviewDelete(purvoewId,roleId) ;

        //判断
        if(row<1){
            throw new AllException(500,"删除失败") ;
        }

        //返回结果集
        return row;
    }

    /***
     *
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param roleId FK用户roleId
     * @param purviewId id
     * @return
     */
    @Override
    public int purviewUpdate(String purviewLimitation, String purviewDescribe, int roleId, int purviewId) {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //调用实体类
        Purview entity = new Purview() ;
        entity.setPurviewLimitation(purviewLimitation);
        entity.setPurviewDescribe(purviewDescribe);
        entity.setRoleId(roleId);
        entity.setPurviewId(purviewId);

        //引用dao方法
        int row = dao.purviewUpdate(entity) ;

        //判断
        if(row<1){
            throw new AllException(500,"修改失败") ;
        }

        //返回结果集
        return row;
    }

    /***
     * 查询所有数据
     * @return
     */
    @Override
    public List<Purview> purviewList() {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //创建List集合，存放查询到的数据
        List<Purview> list = new ArrayList<>() ;

        //引用dao方法
        list = dao.purviewList() ;

        //判断
        if(list == null){
            throw new AllException(500,"查询不到信息") ;
        }

        //返回结果集
        return list;
    }

    /***
     * 根据条件查询
     * @param id
     * @return
     */
    @Override
    public Purview purviewRoleIDQuery(int id) {
        //调用数据访问类
        PurviewInterFace dao = new PurviewDAO() ;

        //调用实体类 引用dao方法
        Purview entity = dao.purviewUserIDQuery(id) ;

        if(entity == null){
            throw new AllException(500,"查询不到信息") ;
        }
        //返回结果集
        return entity;
    }

    @Override
    public PageVO<List<Purview>> queryLimitPurview(String purviewLimitation, String purviewDescribe, int page, int limit) {
        //先计算出page从几页开始
        int numberOf = PageUtils.toNumberOf(page,limit) ;

        //调用实体类
        Purview entity = new Purview() ;
        entity.setPurviewLimitation(purviewLimitation);
        entity.setPurviewDescribe(purviewDescribe);

        //调用数访问类
        PurviewInterFace dao = new PurviewDAO() ;
        //引用dao方法
        List<Purview> list = dao.QueryLimitPurview(entity,numberOf,limit) ;

        Long count = dao.count();

        return PageUtils.toPageVO(list,count) ;
    }
}
