package shop.bookbom.shop.domain.users.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.bookbom.shop.domain.order.dto.response.OrderInfoResponse;
import shop.bookbom.shop.domain.users.dto.OrderDateCondition;
import shop.bookbom.shop.domain.users.dto.request.ResetPasswordRequestDto;
import shop.bookbom.shop.domain.users.dto.request.UserRequestDto;

public interface UserService {

    Long save(UserRequestDto userRequestDto);

    void changeRegistered(Long id, boolean registered);

    void resetPassword(ResetPasswordRequestDto resetPasswordRequestDto);

    boolean isRegistered(Long id);

    boolean checkEmailCanUse(String email);

    /**
     * 회원의 주문 내역을 가져오는 메서드입니다.
     *
     * @param userId 회원 ID
     * @return Page<OrderInfoResponse> 주문 내역
     */
    Page<OrderInfoResponse> getOrderInfos(Long userId, Pageable pageable, OrderDateCondition condition);
}
