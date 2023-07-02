package top.lldwb.sae.api.controller.paymentcenter;

import org.nf.web.annotation.Model;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.utils.vo.ResultVO;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.paymentcenter.RechargeWithdrawalService;
import top.lldwb.sae.service.paymentcenter.impl.RechargeWithdrawalServiceImpl;

import java.util.List;

/**
 * 充值、提现
 * Author: tianyuan
 * Date: 2023/6/20
 */
public class RechargeWithdrawalController extends BaseController {

    @RequestMapping("/Recharge")
    public View recharge(@Model RechargeWithdrawal rw){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        ResultVO<Integer> vo = success(service.insertRecharge(rw));
        return new JsonView(vo);
    }

    @RequestMapping("/getBalance")
    public View getBalance(@RequestParam("rwId") int rwId){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        ResultVO<RechargeWithdrawal> vo = success(service.getBalance(rwId));
        return new JsonView(vo);
    }

    @RequestMapping("/getRechargeWithdrawal")
    public View getRechargeWithdrawal(){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        ResultVO<List<RechargeWithdrawal>> vo = success(service.getRechargeWithdrawal());
        return new JsonView(vo);
    }
}
