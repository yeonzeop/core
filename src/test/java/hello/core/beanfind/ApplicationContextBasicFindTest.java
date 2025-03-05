package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);
//        System.out.println("discountPolicy = " + discountPolicy);
//        System.out.println("discountPolicy.getClass() = " + discountPolicy.getClass());

        Assertions.assertThat(discountPolicy).isInstanceOf(FixDiscountPolicy.class);
    }
}
