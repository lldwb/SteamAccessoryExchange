package top.lldwb.sae.dao.aftersalescenter;

import top.lldwb.sae.entity.Aftersalescenter.Help.Help;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/24 20:05
 * @Author xiao
 */
public interface HelpDao {

    int insert(Help help);

    int delete(int helpId);

    int update(Help help);

    Help select(int helpId);

    List<Help> select();
}
