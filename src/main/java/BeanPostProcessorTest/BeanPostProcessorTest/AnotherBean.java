package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * AnotherBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class AnotherBean implements TestBeans{

    public AnotherBean(SomeBean someBean){
        System.out.println("AnotherBean constructor. with someBean");
        someBean.setMessage("Message setted to SomeBean from Another bean Constructor");
        setMessage("Message from AnotherBean constructor");
    }

    private String message;

    public String getMessage() {
        return "AnotherBean Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println("AnotherBean is in init phase. message: "+ message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AnotherBean will be destroyed now message: "+ message);
    }
}
