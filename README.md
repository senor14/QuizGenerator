# QuizGenerator

- OCR을 활용한 퀴즈 생성 및 풀이 서비스
- 학교 팀 프로젝트
- 개발 인원 총 3명 (웹 3), 웹 개발 담당

## 진행 기간: 2020.11 ~ 2020.11

## 사용 기술

- Java 8 - 개발 언어
- Spring Framework - 웹 프레임워크
- Maven - 의존성 관리 프로그램
- Tomcat - 웹 애플리케이션 서버
- MariaDB - 사용자 데이터베이스
- MongoDB - 퀴즈 데이터베이스
- Git - 형상관리
- AWS EC2, RDS, Route 53 - 서버 인프라

## 설명

---

![QuizGenerator1.png](https://user-images.githubusercontent.com/64997244/183339719-7d45d522-4c70-454d-b888-639588eeb30e.png)

![QuizGenerator2.png](https://user-images.githubusercontent.com/64997244/183339742-457b8180-f57d-4a4c-b352-e74cdc91ee88.png)

![QuizGenerator3.png](https://user-images.githubusercontent.com/64997244/183339746-712373ba-996d-46ff-8ff6-8cde5e50880e.png)

![QuizGenerator4.png](https://user-images.githubusercontent.com/64997244/183339747-12c3b900-7928-4fda-9672-55ef6f428584.png)

![QuizGenerator5.png](https://user-images.githubusercontent.com/64997244/183339749-7b7b97e1-95db-4f3e-8f68-3b752cc11daa.png)

- 사용자의 전자문서를 Jcrop과 Tesseract 를 이용해 퀴즈를 만드는 애플리케이션
- 생성한 퀴즈를 저장하고 나중에 다시 풀어볼 수 있음

## 담당 기능



---

- Tesseract를 활용하여 해당 문자를 인식하는 기능 구현
- Jcrop을 활용하여 문자 cropping 기능 구현
- Bootstrap Template을 활용해 Frontend 개발
- STOMP를 이용하여 pub/sub 구조로 채팅 기능 구현
- AWS EC2 + RDS + Route53 인프라 구성, 배포, 운영
- WBS, 테이블&프로그램 명세서 등 개발 산출물 작성
