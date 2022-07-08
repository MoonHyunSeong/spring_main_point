package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " +  url);

    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call  = " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init(){
        connect();
        call("초가화 연결 메세지");
    }//의존관계가 주입이 되면 호출된다. -> 초기화

    @PreDestroy
    public void close(){
        disconnect();
    }
}
// 인터페이스를 사용하는 초기화, 종료 방법은 초기에 쓰던 방법이고 요즈에는 잘 사용하지 않는다.
