package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ThirdBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class ThirdBean implements TestBeans {

    @Autowired
    private SomeBean someBean;

    public ThirdBean() {
        System.out.println("ThirdBean constructor. message: " + message);
        System.out.println("ThirdBean constructor." + getSomeBeanText());
    }

    private String message;

    public String getMessage() {
        return "Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getSomeBeanText() {
        return (someBean == null)
                ? "someBean not setted"
                : "someBean setted. SomeBean message: " + someBean.getMessage();
    }

    @PostConstruct
    public void init() {
        System.out.println("ThirdBean is in init phase. message: " + message);
        System.out.println("ThirdBean init()." + getSomeBeanText());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ThirdBean will be destroyed now. message: " + message);
        System.out.println("ThirdBean destroy()." + getSomeBeanText());
    }
}
