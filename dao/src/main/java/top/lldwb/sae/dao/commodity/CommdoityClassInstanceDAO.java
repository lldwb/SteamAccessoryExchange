package top.lldwb.sae.dao.commodity;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface CommdoityClassInstanceDAO {
    /**
     * 判断是否存在
     * @param classId
     * @param instanceId
     * @return
     */
    Boolean judgeExist(String classId,int instanceId);
    void add(String classId,int instanceId);
}
