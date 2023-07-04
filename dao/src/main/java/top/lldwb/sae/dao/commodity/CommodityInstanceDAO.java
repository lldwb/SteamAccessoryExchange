package top.lldwb.sae.dao.commodity;

public interface CommodityInstanceDAO {
    /**
     * 判断是否存在
     *
     * @param name 分类名
     * @return 不存在返回true
     */
    Boolean judgeExist(String name);

    /**
     * 根据Name查询id
     * @param name
     * @return
     */
    Integer getIdByName(String name);

    /**
     * 添加分类
     *
     * @param name 分类名称
     */
    void add(String name);

    /**
     * 添加分类
     *
     * @param name       分类名称
     * @param parent_id 父分类名称
     */
    void add(String name, Integer parent_id);
}
