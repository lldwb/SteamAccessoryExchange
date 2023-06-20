package top.lldwb.sae.service.dao.code;

import top.lldwb.sae.service.entity.code.CodeTable;

import java.sql.Timestamp;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
public interface CodeInterFace {
    /**
     * 删除
     * @param
     * @return
     * 根据时间来删除
     */
    public int deleteCOde(Timestamp times ) ;

    /***
     * 修改
     * @param id
     * @return
     */
    public int  updateCode(int id) ;

    /**
     * 添加
     * @param entity
     * @return
     */
    public int insertInto(CodeTable entity) ;


    /***
     * 根据用户ID删除
     * @param id
     * @return
     */
    public int deleteCodesID(int id) ;

    /***
     * 根据邮箱号
     * @param name
     * @return
     */
    public CodeTable query (String name);

}
