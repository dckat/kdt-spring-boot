package org.example.kdtspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class KdtSpringBootApplication implements CommandLineRunner {

    // 램에 만들어진 주소를 자동으로 찾아서 그 주소를 변수에 넣어줌
    // 스프링 시작 시 싱글톤으로 프리로딩 되어있는 객체
    // (preloading --> 쓰기 전에 메모리에 미리 올려두는 것)
    // 싱글톤으로 만들어서 램에 들어있는 객체의 주소를 찾음
    // 설정파일에 설정된 값을 가지고 올 수 있는 객체
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(KdtSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // application.properties에 있는 설정값을 가지고 와서 콘솔에 출력
        String port = environment.getProperty("server.port", "8080");
        System.out.println("================================");
        System.out.println("스프링 부트 프로젝트 시작");
        System.out.println("http://localhost:" + port);
        System.out.println("================================");
    }
}
