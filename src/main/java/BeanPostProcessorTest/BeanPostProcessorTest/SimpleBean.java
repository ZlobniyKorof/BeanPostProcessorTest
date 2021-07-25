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

    private AnotherBean anotherBean;

    public SimpleBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
        System.out.println("SimpleBean constructor. message: " + message);
    }

    private String message;

    public String getMessage() {
        return "Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getSimpleBeanText() {
        return (anotherBean == null)
                ? ". SimpleBean. anotherBean not setted"
                : ". SimpleBean. anotherBean setted. anotherBean message: " + anotherBean.getMessage();
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
