package bob.shopping_mall.product.exception;

import bob.shopping_mall.common.exception.BizCodeEnume;
import bob.shopping_mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ***
 * 2023-05-29 22:03
 */
@Slf4j
@RestControllerAdvice(basePackages = "bob.shopping_mall.product.controller")
public class ShoppingmallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验异常");
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(), BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data",errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error("ExceptionHandler", throwable);
        return R.error(BizCodeEnume.UNKNOWN_EXCEPTION.getCode(), BizCodeEnume.UNKNOWN_EXCEPTION.getMsg());
    }

}
