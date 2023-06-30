package top.lldwb.sae.api.controller.purview;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.PageVO;
import top.lldwb.sae.pagingUtil.ResultVO;
import top.lldwb.sae.service.purview.PurviewServiceInterFace;
import top.lldwb.sae.service.purview.impl.PurviewService;

import org.nf.web.servlet.View;

import javax.servlet.http.HttpSession;
import java.util.List;

/***
 * @Date(时间)2023-06-27
 * @Author 家辉
 *
 *
 * 权限服务器接口
 */
public class PurviewController {

    /***
     * 添加权限
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param userId FK用户userid
     * @return
     */
    @RequestMapping("/purview/getPurviewADD.do")
    public View getPurviewADD(@RequestParam("purviewLimitation") String purviewLimitation ,
                              @RequestParam("purviewDescribe")String purviewDescribe,
                              @RequestParam("userId")int userId) {

        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"成功",service.purviewADD(purviewLimitation,purviewDescribe,userId)) ;


        return new JsonView(resultVO);
    };
    /***
     * 根据id删除数据
     * @param userId
     * @return
     */
    @RequestMapping("/purview/getPurviewDelete.do")
    public View  getPurviewDelete(@RequestParam("userId")int userId) {
        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"删除成功",service.purviewDelete(userId)) ;
        return new JsonView(resultVO);
    };

    /***
     * 根据id和根据用户id删除
     * @param purvoewId id
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/purview/getPurviewDeleteTwo.do")
    public View  getPurviewDeleteTwo(@RequestParam("purvoewId")int purvoewId ,
                                     @RequestParam("userId")int userId) {
        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"删除成功",service.purviewDelete(purvoewId,userId)) ;
        return new JsonView(resultVO);
    };

    /***
     * 修改数据
     * @param purviewLimitation 限制
     * @param purviewDescribe 描述
     * @param userId FK用户UserId
     * @param purviewId id
     * @return
     */
    @RequestMapping("/purview/getPurviewUpdate.do")
    public View  getPurviewUpdate(@RequestParam("purviewLimitation")String purviewLimitation ,
                               @RequestParam("purviewDescribe")String purviewDescribe,
                               @RequestParam("userId")int userId,
                               @RequestParam("purviewId")int purviewId) {


        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"修改成功",service.purviewUpdate(purviewLimitation,purviewDescribe,userId,purviewId)) ;

        return new JsonView(resultVO);
    };

    /***
     * 查询所有
     * @return
     */
    @RequestMapping("/purview/getPurviewList.do")
    public View  getPurviewList() {

        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"成功",service.purviewList()) ;


        return new JsonView(resultVO);
    };


    /***
     * 根据条件ID查询权限数据
     * @param userId
     * @return
     */
    @RequestMapping("/purview/getPurviewUserIDQuery.do")
    public View getPurviewUserIDQuery(@RequestParam("userId")int userId){


        //调用业务类
        PurviewServiceInterFace service = new PurviewService() ;

        //调用响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"查询成功",service.purviewUserIDQuery(userId)) ;


        return new JsonView(resultVO);
    };
}
