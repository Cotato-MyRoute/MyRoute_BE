package BE.MyRoute.member.service;

import BE.MyRoute.member.dto.MemberDto;
import BE.MyRoute.member.entity.Member;

public interface MemberService {

    public void memberRegister(MemberDto.SignUpRequest request);
}
