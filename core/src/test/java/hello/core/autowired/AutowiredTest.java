package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) // -> 의존관계가 없으면 아예 호출이 안된다. 즉, 자동주입 할 대상이 없으면 호출이 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            // 의존관계를 주입할 대상이 없더라도 호출은 된다. -> null 로 리턴
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            //의존관계를 주입할 대상이 없더라도 호출은 된다. -> Optional -> null 이면 비어있다고 Optional.empty 출력
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
