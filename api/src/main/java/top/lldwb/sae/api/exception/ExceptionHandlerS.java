package top.lldwb.sae.api.exception;

import org.nf.web.annotation.ExceptionHandler;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.service.exception.AllException;

/**
 * 异常处理
 *
 * @author 安然的尾巴
 * @version 1.0
 */
public class ExceptionHandlerS extends BaseController{
    // 全局异常处理
    @ExceptionHandler(Exception.class)
    public JsonView exception(Exception e) {
        System.out.println(e);
        System.out.println(e.getMessage());
        System.out.println(e.getLocalizedMessage());
//        return new JsonView(error(500, e.toString()));
        return new JsonView(error(500, e.getLocalizedMessage()));
    }
}
