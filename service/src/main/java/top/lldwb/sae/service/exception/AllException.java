package top.lldwb.sae.service.exception;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 全局异常捕获
 */
public class AllException extends RuntimeException{

    /***
     * 异常捕获错误状态码
     */
    private Integer errorCode ;

    /***
     * 构造方法传入错误的异常码
     * @param errorCode 错误码
     * @param message 错误消息
     */
    public AllException(Integer errorCode,String message){
        super(message);
        this.errorCode = errorCode ;
    }

    /***
     * 构造方法传入错误的信息
     * @param message 错误消息
     */
    public AllException(String message){
        super(message);
    }


    /***
     * 获取errorCode的方法
     * @return
     */
    public Integer getErrorCode(){
        return errorCode ;
    }
}
