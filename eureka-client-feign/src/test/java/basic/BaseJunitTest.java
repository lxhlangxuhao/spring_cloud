package basic;

import com.lang.xu.hao.EurekaClient_feignApplication;
import com.lang.xu.hao.eurekaserver.controller.FeignService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:50 2019/12/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaClient_feignApplication.class)
@WebAppConfiguration
public class BaseJunitTest {


}
