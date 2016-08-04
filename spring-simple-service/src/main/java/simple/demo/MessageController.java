package simple.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sai on 16-8-4.
 */
@RefreshScope
@RestController
public class MessageController
{

    @Value("${message}")
    String message;

    @RequestMapping("/message")
    String getMessage()
    {
        return this.message;
    }

}
