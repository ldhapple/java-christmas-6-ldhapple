# 🎄 크리스마스 프로모션

우테코 식당의 2023년 12월 이벤트 적용 정보를 보여준다.

방문 일자, 주문 내역에 맞게 적용되는 이벤트의 정보들을 계산해 소비자에게 보여주는 프로그램이다.

이용자는 12월중 식당 방문 예상 일자, 주문 메뉴를 입력하면 해당 방문일에 해당하는 할인 정책들을 보여주고, 그 할인 정책에 따른 예상 할인 금액, 증정 메뉴를 보여준다. 그리고 할인 후 예상되는 최종 결제 금액을
보여주게 된다.

그리고 혜택 금액에 예상되는 이벤트 배지를 부여하는데, 이 이벤트 배지는 새해 이벤트에 사용된다.

![결과화면](https://blog.kakaocdn.net/dn/lE1nj/btsAkmN4Bjr/syEdNYuspW5E1MfNfHeoR0/img.gif)

## 📃기능 목록

- [x] 입력 기능 구현
    - [x] 입력이 잘못되었을 경우 다시 입력받아야 함.
    - [x] <식당 예상 방문 일자 입력>
        - [x] [예외처리] 1~31 사이의 숫자여야 한다.
        - [x] [예외처리] 숫자만 입력해야 한다.
    - [x] 주문할 메뉴와 그 메뉴의 개수 입력
        - <주문 메뉴>
            - [x] [예외처리] 중복 메뉴인 경우 예외
            - [x] [예외처리] 메뉴 형식이 다른 경우 예외 (레드와인-1)
            - [x] [예외처리] 메뉴판에 없는 메뉴를 고를 시 예외
            - [x] [예외처리] 음료만 주문 시 예외
        - <주문 개수>
            - [x] [예외처리] 메뉴의 개수는 1 이상
            - [x] [예외처리] 메뉴의 개수는 숫자만 허용
            - [x] [예외처리] 메뉴 개수의 총 합은 20 이하로.
- [x] 출력 기능 구현
    - [x] <인사말 및 예상 방문 날짜 질문>
    - [x] <메뉴판 출력>
        - [x] 주문하실 메뉴와 개수를 알려주세요. 위에 출력.
    - [x] 이벤트 주의사항 출력
    - [x] 주문할 메뉴와 개수 질문
    - [x] <주문 메뉴 출력>
        - [x] 주문 메뉴의 출력 순서는 자유
    - [x] <할인 전 총 주문 금액 출력>
    - [x] <증정 메뉴 출력>
        - [x] 없다면 없음
    - [x] <혜택 내역 출력>
        - [x] 없다면 없음
        - [x] 고객에게 적용된 이벤트 내역만 출력. 출력 순서는 자유.
    - [x] <총 혜택 금액 출력>
    - [x] <할인 후 예상 결제 금액 출력>
    - [x] <12월 이벤트 배지 출력>
- [x] <메뉴 구현>
    - [x] 입력 값 검증에 사용
- [x] <12월 달력, 할인정책 구현>
    - [x] 주말, 평일, 별이 있는 날에 대한 할인정책이 정의되어 있어야 함.
- [x] <이벤트 기능 구현>
    - [x] [예외처리] 10,000원 이상부터 적용된다.
    - [x] 크리스마스 디데이 할인
        - [x] 이벤트 기간 12.1 ~ 12.25
        - [x] 1일 1,000원으로 시작해 100원씩 25일까지 증가.
    - [x] 일반 이벤트
        - [x] 이벤트 기간 12.1 ~ 12.31
        - [x] 평일 할인
            - [x] 평일에는 디저트 메뉴를 메뉴 1개당 2023원 할인
            - [x] 일요일 ~ 목요일이 해당된다.
        - [x] 주말 할인
            - [x] 주말에는 메인 메뉴를 메뉴 1개당 2023원 할인
            - [x] 금요일, 토요일이 해당된다.
        - [x] 특별 할인
            - [x] 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
        - [x] 증정 이벤트
            - [x] 할인 전 총 주문 금액이 12만원 이상일 시 샴페인 1개 증정
        - [x] 이벤트 배지 부여
            - [x] "혜택 금액"이 5천원 이상 별, 1만원 이상 트리, 2만원 이상 산타

## ❗주의 사항

- InputView, OutputView와 같이 입력과 출력을 담당하는 클래스를 별도 구현한다.
    - 해당 클래스 패키지, 클래스 명, 메서드 반환 타입과 시그니처는 자유롭게 구현 가능.
- 사용자의 입력이 잘못된 경우 IllegalArgumentException을 발생시키고 에러 메시지 출력 후 그 부분부터 다시 입력받는다.

## 🎁패키지 구조

<table>
    <tr>
        <th>패키지</th>
        <th>이름</th>
        <th>설명</th>
    </tr>
    <tr>
        <td width="110" rowspan="2">🖥️Controller</td>
        <td>WootecoRestaurantController</td>
        <td>고객과 식당간의 예약, 주문과 같은 상호 작용을 관리하는 컨트롤러 클래스.</td>
    </tr>
    <tr>
        <td>EventPlanerController</td>
        <td>고객의 방문일자, 주문정보에 따른 이벤트 적용을 관리하는 컨트롤러 클래스.</td>
    </tr>
    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td colspan="3" align="center">🌐Domain</td>
    </tr>
    <tr>
        <td >calendar</td>
        <td>DecemberCalendar</td>
        <td>12월의 평일, 주말, 각 할인의 적용 기간을 관리하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td rowspan="5">event</td>
        <td>Badge</td>
        <td>혜택 금액에 따른 각 배지를 관리하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td>BenefitFood</td>
        <td>구입 금액에 따른 증정 메뉴를 관리하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td>DiscountPolicy</td>
        <td>각 할인 정책의 이름, 적용 기간, 할인 금액을 관리하는 Enum 클래스. </td>
    </tr>
    <tr>
        <td>DiscountRequiredValueMapper</td>
        <td>각 할인 정책의 할인 금액을 계산하기 위한 값을 매핑해주는 클래스.</td>
    </tr>
    <tr>
        <td>EventConstants</td>
        <td>이벤트에 관련된 상수들을 모아 관리하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td rowspan="6">food</td>
        <td>Food</td>
        <td>Food 인터페이스</td>
    </tr>
    <tr>
        <td>Appetizer</td>
        <td>애피타이저에 해당하는 음식들의 이름과 가격을 관리하는 Enum클래스. </td>
    </tr>
    <tr>
        <td>Dessert</td>
        <td>디저트에 해당하는 음식들의 이름과 가격을 관리하는 Enum클래스. </td>
    </tr>
    <tr>
        <td>Drink</td>
        <td>음료에 해당하는 음식들의 이름과 가격을 관리하는 Enum클래스. </td>
    </tr>
    <tr>
        <td>MainFood</td>
        <td>메인메뉴에 해당하는 음식들의 이름과 가격을 관리하는 Enum클래스. </td>
    </tr>
    <tr>
        <td>MenuFormat</td>
        <td>각 음식들을 메뉴판의 출력 포맷으로 변환하기 위한 문자열을 관리하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td rowspan="3">restaurant</td>
        <td>Menu</td>
        <td>메뉴판을 담당하는 Enum 클래스. 주문받은 메뉴가 메뉴판에 있는 지, 메뉴의 종류가 음료인지 등의 판단을 담당한다.</td>
    </tr>
    <tr>
        <td>Orders</td>
        <td>이용자의 주문에 대한 클래스. 주문 정보에 대한 검증 및 주문 정보에 대한 일부 값을 추출해주는 역할을 담당한다.</td>
    </tr>
    <tr>
        <td>VisitDate</td>
        <td>이용자의 방문 일자에 대한 클래스. 방문 일자에 대한 검증을 담당한다.</td>
    </tr>
    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td>📃Dto</td>
        <td>BenefitDto</td>
        <td>각 할인정책과 각 할인 정책에 대한 최종 할인금액 및 증정 메뉴 정보를 가지고 있는 Dto 클래스.</td>
    </tr>
    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td rowspan="2">📊Service</td>
        <td>RestaurantCalculator</td>
        <td>이용자의 총 주문 금액 계산을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>EventCalculator</td>
        <td>이용자가 입력한 정보에 맞는 이벤트에 대한 계산을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td align="center" colspan="3">🧰Utils</td>
    </tr>
    <tr>
        <td rowspan="2">parser</td>
        <td>ParseConstants</td>
        <td>입력 문자열을 파싱하는데 필요한 regex 관리 Enum 클래스.</td>
    </tr>
    <tr>
        <td>Parser</td>
        <td>각 값에 필요한 파싱을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td rowspan="5">validator</td>
        <td>InputValueFormat</td>
        <td>입력값 검증에 필요한 regex 관리 Enum 클래스.</td>
    </tr>
    <tr>
        <td>MenuCountValidator</td>
        <td>각 메뉴 주문 수량에 대한 검증을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>MenuValidator</td>
        <td>각 메뉴 음식에 대한 검증을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>OrderValidator</td>
        <td>주문 입력값에 대한 포괄적인 검증을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>VisitDateValidator</td>
        <td>방문 일자에 대한 검증을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td colspan="3" align="center">👀View</td>
    </tr>
    <tr>
        <td rowspan="2">inputview</td>
        <td>InputView</td>
        <td>사용자 입력값을 받기 위한 출력과 입력의 공통처리를 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>InputValueType</td>
        <td>사용자 입력값을 받기위한 메시지와 입력값 객체 생성 메서드들의 관리를 담당하는 Enum 클래스.</td>
    </tr>
    <tr>
        <td rowspan="7">outputview</td>
        <td>OutputView</td>
        <td>전체적인 출력을 담당하는 클래스. </td>
    </tr>
    <tr>
        <td>BenefitFoodOutputView</td>
        <td>증정 메뉴의 출력을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>BenefitOutputView</td>
        <td>할인 혜택 적용 내역에 대한 출력을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>CautionOutputView</td>
        <td>이벤트 주의사항에 대한 출력을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>EventOutputView</td>
        <td>이벤트에 필요한 전반적인 출력과 이벤트 적용 결과에 대한 출력을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>MenuOutputView</td>
        <td>메뉴 출력을 담당하는 클래스.</td>
    </tr>
    <tr>
        <td>OrderOutputView</td>
        <td>주문 내역 등 주문에 관련한 출력을 담당하는 클래스.</td>
    </tr>
</table>