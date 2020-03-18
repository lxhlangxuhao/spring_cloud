package com.lang.xu.hao.eurekauser.eurekaserver.aspect;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author langXuhao
 * 定义一个切面
 */
@Aspect
@Configuration
public class LogRecordAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);
    private final static String POST = "POST";
    private final static String GET = "GET";

    /**
     * 切点
     */
    @Pointcut("execution(* com.lang.xu.hao.eurekauser.eurekaserver.controller.*..*(..))")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        logger.info("请求开始===地址:" + request.getRequestURL().toString());
        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        logger.info(uri);
        String queryString = request.getQueryString();
        Object[] args = pjp.getArgs();
        try {
            //获取请求参数集合并进行遍历拼接
            if (args.length > 0) {
                if (POST.equals(method)) {
                    for (Object arg : args) {
                        logger.info("请求开始===参数:" + JSON.toJSONString(arg, SerializerFeature.IgnoreNonFieldGetter));
                    }
                } else if (GET.equals(method)) {
                    //restful 风格无需打印参数
                    logger.info("请求开始===参数:" + queryString);
                }
            }
        }catch (Exception e){
            logger.error("对象转换参数错误",e);
        }
        Object result = pjp.proceed();
        try {
            logger.info("请求结束===返回值:" + JSON.toJSONString(result,SerializerFeature.IgnoreNonFieldGetter));
        }catch (Exception e){
            logger.error("对象转换返回值错误",e);
        }
        return result;
    }

}
