package idusw.springboot.boradthymleaf.service;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.entity.MemberEntity;
import idusw.springboot.boradthymleaf.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="MemberImpl") // @Service : stereo type, Spring Framework에게 컴포넌트임을 알려줌
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public int create(Member m) {
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        if(memberRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }

    @Override
    public Member read(Member m) {
        return null;
    }

    @Override
    public List<Member> readList() {
        return null;
    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    }
}
