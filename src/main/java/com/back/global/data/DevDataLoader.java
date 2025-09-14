package com.back.global.data;

import com.back.user.entity.User;
import com.back.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@Profile("dev")
public class DevDataLoader {

    @Bean
    public CommandLineRunner loadDevData(UserRepository userRepository) {
        return args -> {
            // 개발용 사용자 100명 생성
            for (int i = 1; i <= 100; i++) {
                User user = new User();
                user.setName("DevUser" + i);
                user.setEmail("devuser" + i + "@example.com");
                userRepository.save(user);
            }
            log.info("DEV data loaded successfully.");
        };
    }
}