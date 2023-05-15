# basicToJavaAndSpring

## Spring boot 없이 SPRING Framework으로 게시판 만들기
[전체 코드 ](https://github.com/jobmania/basicToJavaAndSpring/tree/master/springMVC-workspace/MiniPjt)
- Tomcat Local Server,
- Mybatis
- JAVA 11
- Oracle DB 


![image](https://github.com/jobmania/basicToJavaAndSpring/assets/108961843/3f9a00af-afa1-4250-92bc-8cb20c761198)


# Config
 ## 1. ServletAppConfig
- 스캔할 컴포넌트 설정 , 데이터베이스 접속관리, 쿼리접속객체 관리
- 인터셉터 기능 사용시 인터셉터 추가 설정
- 이미지 업로드 관련 설정
- ViewResolver 설정, 정적파일 경로 매핑

 ## 2. SpringConfigClass
- 파라미터 인코딩 설정
- 이미지 파일 크기 및 기타 설정

# beans 
- 데이터베이스의 값을 주입 받는 bean의 필드 네임은 db의 컬럼명과 동일 해야한다 (만약 다르다면 [방법](https://hayden-archive.tistory.com/326)의 예시로 AS 를 사용하거나 <resultMap> 사용해서 Mapping)
- @Vaild를 활용해서 유효성 검사하기 위한 설정 및 Error 메세지 설정.
  
 ## 1. UserBean
  - 회원 정보를 담을 BEAN
  - 회원 가입 및 회원 정보 수정시 사용

 ## 2. LoginUserBean
  - 해당 빈의 범위는 세션 범위(브라우저 켜진동안)로 로그인 여부를 담당
  - 로그인시 사용
  
 ## 3. PageBean
  - 페이지 네이션에 사용
  
 ## 4. BoardInfoBean
  - 게시판 목록 정보를 담을 bean

 ## 5. ContentBean
  - 게시판 글 정보를 담을 bean

 
# Interceptor
- Controller로 들어오는 모든 요청에 대해서 로직을 수행하지 않고 통과하는 url과 로직을 수행하는 url을 설정 가능.
- 해당 로직에 실패시 false를 return. 
 ## 1. CheckLoginInterceptor
 - 비 로그인 접근에 대해서 수행하는 로직
 
 ## 2. MenuInterceptor
 - 상단 메뉴바 정보 표시를 위해 수행되는 로직
 - 로그인 상태에 따라 표시 정보 변환 가능
 
 ## 3. CheckWriterInterceptor
 - 글 작성자인지 확인하는 로직



# mapper [Mybatis 정보](https://jung-story.tistory.com/128) 
 ![image](https://github.com/jobmania/basicToJavaAndSpring/assets/108961843/7af3565a-65f9-45d3-87ee-b7f650135f1f)
- jdbc로 처리하는 코드의 설정(Connection) 부분을 줄이고 실제 sql문에 연결함으로서 빠른 개발이 가능하게 한다.
## 1. BoardMapper
 - 게시글 CRUD
## 2. MenuMapper
 - 메뉴 항목 READ
## 3. UserMapper
 - 유저 정보 CRUD
