# Spring jdbc-practice – Memory ➜ Pure JDBC

이 저장소는 스프링 입문 프로젝트를 **메모리 기반 리포지터리에서 순수 JDBC 기반**으로 구현하였습니다. 스프링 핵심 기능을 익히면서 동시에 JDBC 접근 방법, 테스트 코드 작성을 연습한 레포지토리 입니다.

---

## 주요 스택

| 영역     | 사용 기술                              |
| ------ | ---------------------------------- |
| 언어     | Java 17                            |
| 프레임워크  | Spring Boot 3.x                    |
| 빌드     | Gradle                             |
| 데이터베이스 | H2 (개발용), MySQL‧PostgreSQL 등 교체 가능 |
| JDBC   | Spring JDBC, HikariCP (기본)         |
| 테스트    | JUnit 5, Spring Test               |

---

## 폴더 구조

```
└─ src
   ├─ main
   │  ├─ java/com/jungyeons/springintroductory
   │  │  ├─ controller      // 웹 계층
   │  │  ├─ domain          // 엔티티
   │  │  ├─ repository      // MemoryMemberRepository → JdbcMemberRepository
   │  │  ├─ service         // 비즈니스 로직
   │  │  └─ SpringConfig.java
   │  └─ resources
   │     ├─ application.properties
   │     ├─ schema.sql      // 테이블 정의
   │     └─ data.sql        // 초기 데이터 (선택)
   └─ test
      └─ java/.../MemberServiceIntegrationTest.java
```

---

## 빠른 시작

### 1. 프로젝트 클론 및 빌드

```bash
git clone https://github.com/your-id/spring-introductory.git
cd spring-introductory
./gradlew clean build
```

### 2. H2 데이터베이스로 실행

```bash
./gradlew bootRun
```

* 애플리케이션 기본 포트: **8080**
* H2 콘솔: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

    * JDBC URL: `jdbc:h2:~/test` (기본값)

### 3. 웹 기능 확인

| URL            | 설명    |
| -------------- | ----- |
| `/`            | 홈     |
| `/members/new` | 회원 가입 |
| `/members`     | 회원 목록 |

### 4. 테스트 실행

```bash
./gradlew test
```

`@Transactional` 덕분에 각 테스트가 끝난 뒤 DB 변경 사항이 롤백됩니다.

---

## 데이터베이스 설정 변경

`src/main/resources/application.properties` 파일에서 다음 네 가지 값을 교체하면 MySQL·PostgreSQL 등 다른 RDBMS로 손쉽게 전환할 수 있습니다.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springintro?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=비밀번호
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

> 드라이버 의존성(runtimeOnly)을 `mysql:mysql-connector-j`로 교체하는 것도 잊지 마세요.

---

## 스키마 관리 팁

* `schema.sql`, `data.sql`로 초기 스키마·데이터가 자동 실행됩니다.
* 실무형 워크플로우에는 **Flyway** 또는 **Liquibase**를 도입해 버전 관리를 권장합니다.

---

## Trouble Shooting

| 증상           | 해결 방법                                                  |
| ------------ | ------------------------------------------------------ |
| H2 콘솔 접속 불가  | `spring.h2.console.enabled=true` 확인                    |
| SQL 로그가 안 보임 | `logging.level.org.springframework.jdbc.core=DEBUG` 설정 |
| MySQL 연결 오류  | 드라이버 의존성·URL·포트·방화벽 확인                                 |

---

## 기여

* PR·이슈 환영합니다.
* 질문은 Discussions 또는 Issue 탭을 활용해 주세요.

---

## 라이선스

MIT License (파일 `LICENSE` 참고)
