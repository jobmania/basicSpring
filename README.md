# basicToJavaAndSpring

## Spring boot 없이 SPRING Framework으로 게시판 만들기
- Tomcat Local Server,
- Mybatis
- JAVA 11
- Oracle DB 


![image](https://github.com/jobmania/basicToJavaAndSpring/assets/108961843/3f9a00af-afa1-4250-92bc-8cb20c761198)


# Config
## ServletAppConfig
- 스캔할 컴포넌트 설정 , 데이터베이스 접속관리, 쿼리접속객체 관리
- 인터셉터 기능 사용시 인터셉터 추가 설정
- 이미지 업로드 관련 설정
- ViewResolver 설정, 정적파일 경로 매핑

## SpringConfigClass
- 파라미터 인코딩 설정
- 이미지 파일 크기 및 기타 설정

# beans 
- 데이터베이스의 값을 주입 받는 bean의 필드 네임은 db의 컬럼명과 동일 해야한다 (만약 다르다면 https://hayden-archive.tistory.com/326 방법의 예시로 AS 를 사용하거나 <resultMap> 사용해서 Mapping)
- @Vaild를 활용해서 유효성 검사하기 위한 설정 및 Error 메세지 설정.
  
## UserBean
  - 회원 정보를 담을 BEAN
  - 회원 가입 및 회원 정보 수정시 사용

## LoginUserBean
  - 해당 빈의 범위는 세션 범위(브라우저 켜진동안)로 로그인 여부를 담당
  - 로그인시 사용
  
## PageBean
  - 페이지 네이션에 사용
  
## BoardInfoBean
  - 게시판 목록 정보를 담을 bean

## ContentBean
  - 게시판 글 정보를 담을 bean
