package top.lldwb.sae.dao.code;

import top.lldwb.sae.entity.code.CodeTable;

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
    int deleteCOde(Timestamp times ) ;

    /***
     * 修改
     * @param id
     * @return
     */
    int  updateCode(int id) ;

    /**
     * 添加
     * @param entity
     * @return
     */
    int addCode(CodeTable entity) ;


    /***
     * 根据用户ID删除
     * @param id
     * @return
     */
    int deleteCodesID(int id) ;

    /***
     * 根据邮箱号
     * @param name
     * @return
     */
    CodeTable query (String name);

}
