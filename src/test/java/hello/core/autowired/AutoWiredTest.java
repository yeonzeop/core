package hello.core.autowired;

import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Configuration
    static class TestConfig{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println(noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean1){
            System.out.println(noBean1);
        }
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean1){
            System.out.println(noBean1);
        }
    }
}
