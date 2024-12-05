package SpringLearning.SpringLearning.service;

import SpringLearning.SpringLearning.domain.Member;
import SpringLearning.SpringLearning.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService memberService;


    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");

        Long result = memberService.join(member);

        Member findMember =  memberService.findOne(result).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void validateJoin(){
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("Already Exist Member");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}