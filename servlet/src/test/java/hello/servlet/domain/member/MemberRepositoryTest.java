package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
        // 다음 테스트에 영향을 주지 않도록 저장소 초기화
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void findAll() {

        //given
        Member memberA = new Member("memberA", 20);
        Member memberB = new Member("memberB", 30);

        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when

        List<Member> members = memberRepository.findAll();
        System.out.println(members.get(0).getUsername());
        System.out.println(members.get(1).getUsername());

        //then

        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(memberA, memberB);
    }
}
