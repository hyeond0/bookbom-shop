package shop.bookbom.shop.domain.member.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.bookbom.shop.domain.address.entity.Address;
import shop.bookbom.shop.domain.address.repository.AddressRepository;
import shop.bookbom.shop.domain.member.dto.request.SignUpRequest;
import shop.bookbom.shop.domain.member.dto.response.MemberInfoResponse;
import shop.bookbom.shop.domain.member.entity.Member;
import shop.bookbom.shop.domain.member.entity.MemberStatus;
import shop.bookbom.shop.domain.member.repository.MemberRepository;
import shop.bookbom.shop.domain.member.service.MemberService;
import shop.bookbom.shop.domain.rank.entity.Rank;
import shop.bookbom.shop.domain.rank.repository.RankRepository;
import shop.bookbom.shop.domain.role.entity.Role;
import shop.bookbom.shop.domain.role.repository.RoleRepository;
import shop.bookbom.shop.domain.users.exception.RoleNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private static final String ROLE_USER = "ROLE_USER";
    private static final String STANDARD_RANK = "STANDARD";
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final RankRepository rankRepository;

    @Transactional(readOnly = true)
    public MemberInfoResponse getMemberInfo(Long id) {
        return memberRepository.findMemberInfo(id);
    }

    @Override
    @Transactional
    public Long save(SignUpRequest signUpRequest) {
        Role role = roleRepository.findByName(ROLE_USER)
                .orElseThrow(RoleNotFoundException::new);

        Rank rank = rankRepository.getRankByNameFetchPointRate(STANDARD_RANK);

        Member member = Member.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .name(signUpRequest.getName())
                .nickname(signUpRequest.getNickname())
                .birthDate(signUpRequest.getBirthDate())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .role(role)
                .rank(rank)
                .point(0)
                .status(MemberStatus.ACTIVE)
                .build();
        memberRepository.save(member);

        Address address = Address.builder()
                .zipCode(signUpRequest.getAddressNumber())
                .address(signUpRequest.getAddress())
                .addressDetail(signUpRequest.getAddressDetail())
                .defaultAddress(true)
                .member(member)
                .build();
        addressRepository.save(address);

        return member.getId();
    }
}
