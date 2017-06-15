package net.gentledot;

import net.gentledot.domain.Journal;
import net.gentledot.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootJournalApplication {

	@Bean
	InitializingBean saveData(JournalRepository repository){
		return () -> {
			repository.save(new Journal("테스트 타이틀", "데이터 기입 테스트", "2017/06/15"));
			repository.save(new Journal("간단한 스프링 부트 프로젝트", "실전 스프링 부트 워크북 참조", "2017/06/16"));
			repository.save(new Journal("스프링 부트 해부", "스프링 부트를 자세히 학습해보도록 하자", "2017/06/17"));
			repository.save(new Journal("스프링 부트 클라우드", "클라우드 파운드리를 응용한 스프링 부트 학습", "2017/06/25"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BootJournalApplication.class, args);
	}
}
