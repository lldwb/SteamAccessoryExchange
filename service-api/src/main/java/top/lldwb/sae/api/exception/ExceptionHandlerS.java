package top.lldwb.sae.api.exception;

import org.nf.web.annotation.ExceptionHandler;
import org.nf.web.servlet.view.JsonView;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ExceptionHandlerS {
    @ExceptionHandler(Exception.class)
    public JsonView exception(Exception e){
        return new JsonView(e);
    }
}
