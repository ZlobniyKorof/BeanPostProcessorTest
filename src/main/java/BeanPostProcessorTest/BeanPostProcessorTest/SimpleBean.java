package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * SomeBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class SimpleBean implements TestBeans {

    public SimpleBean() {
        System.out.println("SimpleBean constructor. message: " + message);
    }

    private String message;

    public String getMessage() {
        return "Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println("SimpleBean init(). message: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SimpleBean destroy(). message: " + message);
    }
}
