package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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

    @Test
    @DisplayName("타입으로 빈 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class); // 같은 타입이 여러 개일 경우 xx

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); // 변경 시 유연성 xx

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("존재하지 않는 빈 이름(메소드 이름) 조회")
    void findBeanByNameX(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx", MemberServiceImpl.class));
    }
}
