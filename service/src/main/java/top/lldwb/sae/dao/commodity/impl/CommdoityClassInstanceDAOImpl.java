package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommdoityClassInstanceDAO;
import top.lldwb.sae.utils.mySql.MySqlUtil;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommdoityClassInstanceDAOImpl implements CommdoityClassInstanceDAO {
    @Override
    public Boolean judgeExist(String classId, int instanceId) {
        return MySqlUtil.<Long>queryColumn(1, "SELECT count(*) FROM commdoity_class_instance WHERE class_id = ? and instance_id = ?", classId, instanceId) == 0;
    }

    @Override
    public void add(String classId, int instanceId) {
        MySqlUtil.update("insert into commdoity_class_instance(class_id,instance_id) value(?,?);", classId, instanceId);
    }
}
