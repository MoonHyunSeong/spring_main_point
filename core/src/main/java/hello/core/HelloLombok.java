package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter // lombok 덕이다~~
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asd");

        String name = helloLombok.getName();
        System.out.println("helloLombok = " + helloLombok);
    }
}
