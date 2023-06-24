package top.lldwb.sae.dao.Aftersalescenter.DAO;

import top.lldwb.sae.entity.Aftersalescenter.Help.Help;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:05
 * @Author xiao
 */
public interface HelpDao {

    Integer insert(Help help);

    Integer delete(int helpId);

    Integer update(Help help);

    Help select(int helpId);

    List<Help> select();
}
