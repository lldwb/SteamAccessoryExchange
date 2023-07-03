package top.lldwb.sae.service.deal;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface OrderFormService {
    /**
     * 刷新订单信息(检测订单信息)
     * @param userId 用户id
     */
    void refresh(int userId);

    /**
     * 创建购买订单
     * @param userId 用户id
     * @param sellId 出售id
     */
    void purchase(int userId,int sellId);
}
