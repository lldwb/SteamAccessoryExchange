package top.lldwb.sae.dao.aftersalescenter;

import top.lldwb.sae.entity.aftersalescenter.Handle;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 19:43
 * @Author xiao
 */
public interface HandleDao {

    int insert(Handle handle);

    int delete(int handleId);

    int update(Handle handle);

    Handle select(int handleId);

    List<Handle> select();

}
