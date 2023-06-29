package top.lldwb.sae.api.controller.paymentcenter;

import org.nf.web.annotation.Model;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.paymentcenter.RechargeWithdrawalService;
import top.lldwb.sae.service.paymentcenter.impl.RechargeWithdrawalServiceImpl;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/20
 */
public class RechargeWithdrawalcontroller {

    @RequestMapping("/Recharge")
    public View recharge(@Model RechargeWithdrawal rw){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        int recharge = service.recharge(rw);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(recharge);
        vo.setMessage("充值/提现成功");
        return new JsonView(vo);
    }

    @RequestMapping("/getBalance")
    public View getBalance(@RequestParam("rwId") int rwId){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        RechargeWithdrawal balance = service.getBalance(rwId);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(balance);
        vo.setMessage("查询余额成功");
        return new JsonView(vo);
    }

    @RequestMapping("/getRechargeWithdrawal")
    public View getRechargeWithdrawal(){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        List<RechargeWithdrawal> list = service.getRechargeWithdrawal();
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(list);
        vo.setMessage("查询成功");
        return new JsonView(vo);
    }
}
