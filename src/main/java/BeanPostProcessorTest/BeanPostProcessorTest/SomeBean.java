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
public class SomeBean implements TestBeans{

    public SomeBean(){
        System.out.println("SomeBean constructor. message: "+ message);
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
        System.out.println("SomeBean is in init phase. message: "+ message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SomeBean will be destroyed now. message: "+ message);
    }
}
