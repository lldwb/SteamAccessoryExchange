package top.lldwb.sae.service.controller.paymentcenter;

import org.nf.web.annotation.Model;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.service.paymentcenter.RechargeWithdrawalService;
import top.lldwb.sae.service.service.paymentcenter.impl.RechargeWithdrawalServiceImpl;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/20
 */
public class RechargeWithdrawalcontroller {
    private static final  RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();

    @RequestMapping("/Recharge")
    public View recharge(@Model RechargeWithdrawal rw){
        int recharge = service.recharge(rw);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(recharge);
        vo.setMessage("充值/提现成功");
        return new JsonView(vo);
    }

    @RequestMapping("/getBalance")
    public View getBalance(@RequestParam("rwId") int rwId){
        RechargeWithdrawal balance = service.getBalance(rwId);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(balance);
        vo.setMessage("查询余额成功");
        return new JsonView(vo);
    }

    @RequestMapping("/getRechargeWithdrawal")
    public View getRechargeWithdrawal(){
        List<RechargeWithdrawal> list = service.getRechargeWithdrawal();
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(list);
        vo.setMessage("查询成功");
        return new JsonView(vo);
    }
}
