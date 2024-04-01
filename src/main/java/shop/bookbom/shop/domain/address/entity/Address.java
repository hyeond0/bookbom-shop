package shop.bookbom.shop.domain.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.bookbom.shop.domain.member.entity.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long id;

    @Column(length = 50)
    private String nickname;

    @Column(name = "address_number", nullable = false, length = 5)
    private String addressNumber;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(name = "default_address", nullable = false)
    private boolean defaultAddress;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    @Builder
    public Address(
            String nickname,
            String addressNumber,
            String location,
            boolean defaultAddress,
            Member member
    ) {
        this.nickname = nickname;
        this.addressNumber = addressNumber;
        this.location = location;
        this.defaultAddress = defaultAddress;
        this.member = member;
    }

    public void setDefaultAddress() {
        this.defaultAddress = true;
    }

    public void editNickName(String nickName) {
        this.nickname = nickName;
    }
}
