package SpringLearning.SpringLearning.repository;

import SpringLearning.SpringLearning.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void Save() {
        Member member= new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
