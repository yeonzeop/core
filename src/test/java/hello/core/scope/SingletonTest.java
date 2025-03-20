package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singleton1 = ac.getBean(SingletonBean.class);
        SingletonBean singleton2 = ac.getBean(SingletonBean.class);

        System.out.println("singleton1 = " + singleton1);
        System.out.println("singleton2 = " + singleton2);

        Assertions.assertThat(singleton1).isSameAs(singleton2);

        ac.close();

    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void close(){
            System.out.println("SingletonBean.close");
        }
    }
}
