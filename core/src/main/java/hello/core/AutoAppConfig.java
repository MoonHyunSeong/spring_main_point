package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        컴포넌트 스캔을 진행할 때 원하는 패키지를 지정하는 방법이다.
//        만약에 이게 없을때는 어떻게 되는가? default는 컴포넌트스캔이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
//        그래서 관례상 설정 정보 클래스는 프로젝트 최상단에 두는 것이 좋다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Configuration 내부에 component가 포함되어있어 AppConfig가 자동으로 스캔된다.
        //하지만 AppConfig는 수동으로 조작해야 하는 내용이기에 이를 걸러주는 역할을 하기 위해 필터를 쓴 것이다.
        //예제 코드를 살리기 위해서 사용한 방법임을 알고 있자.
)
public class AutoAppConfig {
// bean , component (구현체) -> 차이?
}
