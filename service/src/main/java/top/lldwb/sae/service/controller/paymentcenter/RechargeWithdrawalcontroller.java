package top.lldwb.sae.service.controller.paymentcenter;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.service.paymentcenter.RechargeWithdrawalService;
import top.lldwb.sae.service.service.paymentcenter.impl.RechargeWithdrawalServiceImpl;

/**
 * Author: tianyuan
 * Date: 2023/6/20
 */
public class RechargeWithdrawalcontroller {
    private static final  RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();

    @RequestMapping("/Recharge")
    public void recharge(@RequestParam("rwId")int rwId,@RequestParam("rwBalance") double rwBalance){
        service.recharge(rwId,rwBalance);
    }

    @RequestMapping("/getBalance")
    public View getBalance(@RequestParam("rwId") int rwId){
        RechargeWithdrawal balance = service.getBalance(rwId);
        return new JsonView(balance);
    }

    @RequestMapping("/getRechargeWithdrawal")
    public void getRechargeWithdrawal(){
        service.getRechargeWithdrawal();
    }
}
