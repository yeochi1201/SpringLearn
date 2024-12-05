package SpringLearning.SpringLearning;

import SpringLearning.SpringLearning.repository.MemberRepository;
import SpringLearning.SpringLearning.repository.MemoryMemberRepository;
import SpringLearning.SpringLearning.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
