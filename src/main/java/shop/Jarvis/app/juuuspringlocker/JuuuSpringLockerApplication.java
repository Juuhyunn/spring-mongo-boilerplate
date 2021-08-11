package shop.Jarvis.app.juuuspringlocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import shop.Jarvis.app.juuuspringlocker.user.entity.User;
import shop.Jarvis.app.juuuspringlocker.user.repository.UserRepository;

import java.util.List;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class JuuuSpringLockerApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JuuuSpringLockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		userRepository.save(new User("a", "홍길동", "a@a", "1"));
		userRepository.save(new User("b", "홍길동", "b@b", "1"));
		userRepository.save(new User("c", "이순신", "c@c", "1"));
		List<User> users = userRepository.findAll();
		System.out.println(" 전체를 출력하시오 ");
		for (User u : users) {
			System.out.println(u.toString());
		}
		System.out.println(" 홍길동만 출력하시오 ");
		for (User u : userRepository.findAllByName("홍길동")) {
			System.out.println(u.toString());
		}
	}
}
