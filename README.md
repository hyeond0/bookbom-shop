# BookBom


### 개발 기간
- 2024-03-11 ~ 2024-05-17
## 팀 구성

| <a href="https://github.com/bodol4748"><img src="https://github.com/bodol4748.png" width="100px"><br>박지원</a> | <a href="https://github.com/jinyesong"><img src="https://github.com/jinyesong.png" width="100px"><br>송예진</a> | <a href="https://github.com/boyunee"><img src="https://github.com/boyunee.png" width="100px"><br>정보윤</a> |<a href="https://github.com/hyeond0"><img src="https://github.com/hyeond0.png" width="100px"><br>정현도</a> |<a href ="https://github.com/youaresogay22"> <img src ="https://github.com/youaresogay22.png" width ="100px"><br>전석준</a>|<a href ="https://github.com/dudxor4587"> <img src ="https://github.com/dudxor4587.png" width ="100px"><br>김영택</a>
|-----|-----|-----|----|-----|-----|

-----

# Organization 저장소
https://github.com/nhnacademy-be5-bom

---
## 맡은 역할
## [정현도](https://github.com/hyeond0)

### 검색
- `Elasticsearch`를 이용한 검색 속도 개선
- 검색 우선순위에 따른 가중치 설정
- 필드의 특성을 고려한 인덱스 구성 및 형태소 분석기 적용을 통한 검색 품질 개선
- 인기순, 가격순, 출판일순 등 정렬조건 추가 및 페이지네이션 적용
- `Logstash`를 이용해 DB 저장 데이터 Elasticsearch와 연동

### 장바구니
- 회원/비회원 장바구니 기능 구현
- `Redis`를 이용한 성능 개선
- 주문할 도서 담기, 수량 조절 및 삭제 처리

### 캐시
- Spring Cache를 이용한 페이지 헤더 카테고리 목록 캐싱
- 분산 서버 구조에서 캐시 데이터 공유를 위해 Redis를 이용한 Global Cache 구현
- 메인 페이지 테스트 기준 271ms -> 74ms로 약 2배 이상 응답속도 개선

100개의 스레드로 2000번의 메인 페이지 요청 테스트

**캐시 적용 전**
![image](https://github.com/hyeond0/bookbom-shop/assets/95916780/1e9ff1db-be41-40f7-9e2c-c8b066d277c7)
**캐시 적용 후**
![image](https://github.com/hyeond0/bookbom-shop/assets/95916780/7e5546a7-7a2a-4d2a-95ca-e8ed5e59b56e)

### 회원 
- 회원가입
  - 이메일, 닉네임 중복체크 기능 구현
  - 카카오 우편번호 API를 이용한 주소 입력
  - 비밀번호, 전화번호 등 유효성 검사
  - 회원가입 후 포인트 적립 및 주소록 등록 구현 

- 포인트 적립/사용 내역 조회
  - 회원 포인트 적립/사용 내역 조회 기능 구현
  - 적립 / 사용에 따른 필터링된 결과 출력 구현
  - 기간에 따른 필터링된 결과 출력 구현

- 마이페이지
  - 최근 주문이 5개까지 나오도록 구현
  - 현재 회원의 등급 출력
  - 회원 정보, 보유 포인트, 쿠폰 갯수 등 출력 구현

### 주문
- 주문 내역 조회
  - 회원의 주문 내역 조회 기능 구현
  - 기간을 설정해 필터링된 결과 출력 구현
  - 페이지네이션을 통한 주문 내역 페이지 구현
    
- 주문 상세 조회
  - 주문에 대한 상세 내역 조회 기능 구현
  - 배송이 되기 전인 대기 상태의 경우 주문 취소가 가능하도록 구현
    
- 관리자 주문 관리
  - 관리자 페이지에서 주문 상태별, 기간 별 주문 내역 및 상세 조회 기능 구현
  - 주문 취소, 반품 등 주문 상태 변경 기능 구현

### 포인트 정책
- 관리자 페이지에서 포인트 정책 조회 기능 구현
- 적립 정책 변경 기능 구현(비율/금액, 적립률 등)

## 아키텍쳐 구조
![2024-05-10 15_02_46 959](https://github.com/nhnacademy-be5-bom/.github/assets/132794328/05f51e5f-3373-4e02-b421-e29422e7ef57)

## CI/CD
![2024-05-10 15_24_38 004](https://github.com/nhnacademy-be5-bom/.github/assets/67140032/9aa9a11d-52c0-4c8f-a873-ea4f124846f4)

## ERD
![book-bom-erd](https://github.com/nhnacademy-be5-bom/.github/assets/132794328/ce94f6dc-8a01-4b75-8b7c-3aa5c5c63ff2)

## 개발 환경
- 개발도구: Intellij IDEA - Ultimate
- 언어: Java 11<br>
- 빌드도구: Maven
- 개발
  - Spring Framework 5
  - Spring Boot 2.7
  - Spring Cloud
    - Spring Cloud Gateway
    - Spring Cloud Netflex(Eureka)
    - Spring Cloud Config
  - Spring Data
    - Spring Data JPA
    - Spring Data Elasticsearch
    - Spring Data Redis
  - Spring Batch
  - Spring Security
  - JPA
    - QueryDSL
- 테스트
  - Junit5
  - SonarQube
- 데이터베이스
  - MySQL 8.0.25
  - Redis
- 검색
  - Elastic Search 7.11
  - Logstash
  - Kibana
- Front
  - HTML, CSS, Javascript
  - Bootstrap5
- NHN Cloud
  - Secure Key Manager
  - Object Storage
- CI/CD
  - Github Actions
  - Jenkins
---

## 사용 기술

### 언어
![Java](https://img.shields.io/badge/Java-E34F26?style=for-the-badge&logo=Java&logoColor=white)

### Framework
![Spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring%20boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring RestDocs](https://img.shields.io/badge/spring%20RESTdocs-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![SpringDataJPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=Spring&logoColor=white)
</br>
![Spring Cloud Gateway](https://img.shields.io/badge/Spring_Cloud_Gateway-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Batch](https://img.shields.io/badge/Spring_Batch-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Eureka](https://img.shields.io/badge/Spring_Eureka-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F.svg?style=for-the-badge&logo=springsecurity&logoColor=white)
</br>
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?style=for-the-badge&logo=hibernate&logoColor=white)
</br>
![MyBatis](https://img.shields.io/badge/MyBatis-ED1C24?style=for-the-badge&logo=bitdefender&logoColor=white)
![QueryDSL](http://img.shields.io/badge/QueryDSL-4479A1?style=for-the-badge&logo=Hibernate&logoColor=white)

### Build Tool
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)


### DataBase
![MySQL](http://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white)

### CI/CD
![Github Action](https://img.shields.io/badge/Github%20Action-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Jenkins](http://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white)

### DevOps
![NHN Cloud](https://img.shields.io/badge/-NHN%20Cloud-blue?style=for-the-badge&logo=iCloud&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![SonarQube](https://img.shields.io/badge/SonarQube-4E98CD?style=for-the-badge&logo=SonarQube&logoColor=white)
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)

### ETC
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)
![Junit5](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=Junit5&logoColor=white)
</br>
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![SonarLint](https://img.shields.io/badge/SonarLint-CB2029.svg?style=for-the-badge&logo=sonarlint&logoColor=white)
</br>
![Elasticsearch](https://img.shields.io/badge/Elasticsearch-005571.svg?style=for-the-badge&logo=elasticsearch&logoColor=white)

### Front
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F.svg?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Bootstrap5](https://img.shields.io/badge/Bootstrap5-7952B3.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=for-the-badge&logo=javascript&logoColor=black)



## 프로젝트 관리
### wbs
![image](https://github.com/nhnacademy-be5-bom/.github/assets/132794328/ef238b33-1233-4dc5-9b54-2555f15bac43)

### 칸반 보드
- 칸반 보드로 전체 개발 진행상황을 확인
![image](https://github.com/nhnacademy-be5-bom/.github/assets/132794328/a4744698-014d-4258-a8dd-1f49d9ec6a07)


### 데일리 스크럼
- 매일 10시 진행
- 각자 어제 진행상황과 논의사항을 공유

  
![image](https://github.com/nhnacademy-be5-bom/.github/assets/132794328/e026375a-f451-4bf7-8eaf-89baebf89f49)



---
## 팀원 역할

## [정보윤](https://github.com/boyunee)
### 주문
- 주문하기
  - 비회원/ 회원 주문 로직을 나눠서 구현
  - 주문하는 도서 포장지 선택 가능
  - 배송예정일 선택 가능(토,일을 제외한 하루 뒤 ~ 5일 뒤)
  - 카카오 주소 API 이용한 주소 입력
  - 주문서 작성 시 유효성 체크
  - 비회원 주문 경우
    - 이메일, 비밀번호를 받아 비회원 가입 기능 구현
    - 이메일 중복체크 기능 구현
  - 회원 주문 경우
    - 회원이 가진 쿠폰 중 해당 주문에서 사용가능 쿠폰과 사용불가능 쿠폰을 구분해서 출력
    - 쿠폰의 정책을 조회 후 정책에서 최대 할인 금액을 고려하여 쿠폰 사용 기능 구현
    - 포인트는 보유 포인트 이하로 쓸수 있도록 구현
    - 쿠폰, 포인트 선택 시 각자 할인 금액 출력 후 최종 결제 금액에 반영
    - 최종 결제 금액에 따른 실시간 배송비 책정 가능
      
- 주문 완료 페이지
  - 주문 번호, 주문 정보, 결제 정보, 배송 정보 등을 조회해서 출력
    
### 결제
- 토스페이먼츠 API 사용
- 결제 수단 선택 가능

### 포인트
- 주문 시 도서 적립률 만큼 적립
- 주문 시 회원의 등급에 따른 포인트 적립

### 쿠폰
- 주문 시 쿠폰 상태를 사용으로 전환함으로써 쿠폰 사용 기능 구현

## [전석준](https://github.com/youaresogay22)

### 인프라
- 유레카 기반의 MSA 구성
- 각 인스턴스는 Spring cloud 기반으로 동작하도록 설정
- 게이트웨이 Service-name discovery 기반 라우팅 설정
- Front, Shop 서버 이중화 구성
- Nginx 이용한 프론트 서버 SSL 적용 및 로드밸런싱 적용
- Shop 서버 무중단 배포 적용

### 상품(도서)
- 도서 상세정보 조회 기능 구현
- 도서 목록 조회 기능 구현
  - 페이지네이션이 적용된 도서 목록 구현
  - 가격별, 출판일별 등 정렬방식을 변경할 수 있도록 구현
- 도서 등록 및 수정 기능 구현
  - TOAST UI 위지윅 에디터를 적용하여 도서 설명을 적을 수 있도록 구현
  - NHN Cloud Object Storage 를 통한 도서 썸네일 관리 기능

### 출판사
- 도서 관리에 포함된 출판사 수정 기능 구현

### 저자
- 도서 관리에 포함된 저자 수정 기능 구현
- 저자와 역할을 분리하여 옮긴이, 삽화 그린이 등 여러 역할을 가질 수 있도록 구성
- 한 책에 여러 인물이 연관 가능하도록 구현

### 카테고리
- 카테고리별 도서 목록 페이지 구현
- 카테고리 수정 페이지 구현
- Soft delete 적용


## [송예진](https://github.com/jinyesong)

### 쿠폰
- 관리자 쿠폰 관리
    - 관리자 쿠폰 관리 페이지 구현
    - 쿠폰 정책 조회 및 등록, 수정, 삭제 기능 구현
    - 금액 쿠폰, %쿠폰, 도서 쿠폰, 카테고리 쿠폰 발급
    - 쿠폰 종류에 따른 조회 가능
    - 관리자가 직접 특정 회원에게 쿠폰 발급할 수 있도록 구현
    - 쿠폰 정책 및 쿠폰 등록, 쿠폰 발급할 회원 조회시 유효성 체크
 
- 생일 쿠폰 발급
    - spring scheduler로 일정 주기마다 쿠폰 발급
    - spring batch로 대용량 데이터 처리
    - JDBCPagingItemReader 사용
 
- 회원가입시 웰컴 쿠폰 발급
- 회원 내 쿠폰함 페이지 구현

### 상품좋아요
- 좋아요 페이지 구현

## [김영택](https://github.com/dudxor4587)

### 태그
- 태그의 등록, 삭제 구현
- 도서 태그의 등록, 삭제, 조회 구현

### 회원
- 회원가입
  - 회원가입 시 카카오 주소 api를 통해 주소 입력
  - 회원가입 완료 시 회원가입 정보를 등록
  
- 회원 탈퇴
  - 회원 탈퇴 페이지 구현
  - 필수 항목 미동의시 탈퇴완료되지 않게 처리
  - 탈퇴 사유를 하나라도 선택하지 않으면 탈퇴완료되지 않게 처리
  - 탈퇴 완료시 사용자의 상태 변경(ACTIVE -> DELETED)
  - 탈퇴 사유를 사용자의ID와 함께 저장

- 회원 등급 조회
  - 회원 등급 조회 페이지 구현
  - 회원 등급 조회 시 자신의 등급과 전체 등급별 헤택 출력
  - 자신의 등급은 표시해서 출력함


## [박지원](https://github.com/bodol4748)
### 회원
- 회원 정보 조회 구현
  - EMAIL 중복조회
  - ID PASSWORD 일치 여부 조회
  - EMAIL PASSWORD 일치 여부 조회

- 비밀번호 변경 페이지 구현
  - 현재 비밀번호를 검증
  - 신규 비밀번호 유효성 검사
  - 검증 및 유효성 검사 성공시 비밀번호 변경 기능 구현
    
### 인증/인가 
- AUTH SERVER
  - JWT 토큰을 활용하여 구현
  - SECURE MANGER로 JWT SECRET KEY관리
  - SHOP SERVER에 EMAIL PW로 사용자 검증
  - ACCESS TOKEN, REFRESH TOKEN을 발급
  - ACCESS TOKEN의 PAYLOAD는 ID, ROLE로 구성
  - REFRESH TOKEN은 REDIS를 사용하여 관리
  - 유효기간을 설정하여 일정 시간 이후에는 재발급 또는 재로그인하도록 구현
    
- FRONT SERVER
  - SPRING SECURITY를 활용
  - ROLE별로 페이지 접근 제어가 되도록 구현
  - FILTER로 로그인 구현
      - AUTH SERVER의 JWT TOKEN 발급
      - COOKIE에 JWT 저장
      - SECURITY CONTEXT에 PAYLOAD로 만든 ATHENTICATION TOKEN저장
      
  - INTERCEPTOR로 백엔드와 통신 수정
      - 매 요청시마다 INTERCEPTOR가 요청 가로채도록 구현
      - 인증이 필요한 요청일경우 JWT ACCESS TOKEN을 HEADER에 추가
      - 만료되었을 경우 REFRESH TOEKN을 통한 재발급 후 HEADER에 추가
      - REFRESH TOKEN 또한 만료되었을 경우 SPRING CONTEXT 초기화
      
- SHOP SERVER
    - SPRING SECURITY를 활용
    - ROLE별로 요청 접근 제어가 되도록 구현
    - FILTER로 TOKEN 처리 구현
    - SECURITY CONTEXT에 PAYLOAD로 만든 ATHENTICATION TOKEN저장

