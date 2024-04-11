package shop.bookbom.shop.domain.users.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.bookbom.shop.domain.role.entity.Role;
import shop.bookbom.shop.domain.role.repository.RoleRepository;
import shop.bookbom.shop.domain.users.dto.request.UserRequestDto;
import shop.bookbom.shop.domain.users.entity.User;
import shop.bookbom.shop.domain.users.repository.UserRepository;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Long save(UserRequestDto userRequestDto) {
        Optional<Role> optionalRole = roleRepository.findByName(userRequestDto.getRoleName());
        if (optionalRole.isEmpty()) {
            throw new RoleNotFoundException();
        }
        if (checkEmailCanUse(userRequestDto.getEmail())) {
            // 오류로 인해 요청이 여러번 왔을 때를 대비, 아이디 중복 검증
            User user = userRepository.save(
                    User.builder()
                            .email(userRequestDto.getEmail())
                            .password(userRequestDto.getPassword())
                            .role(optionalRole.get())
                            .build()
            );
            return user.getId();
        } else {
            throw new UserAlreadyExistException();
        }
    }
}
