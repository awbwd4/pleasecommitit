# pleasecommitit
커밋좀돼주세요제바류ㅠㅠㅠㅠㅠ

1. 자바 공부 - 신용권, 이것이 자바다.
2. 스프링으로 게시판 2회 만들기 + 쇼핑몰 구현하기 : 최범균 - 스프링4 프로그래밍 입문, 구멍가게코딩단 - 코드로 배우는 스프링 웹 프로젝트
3. 우분투에서 C++로 알고리즘 공부 : 구종만 - 알고리즘 문제해결 전략, 윤성우 - 열혈 자료구조

*****<코드로 배우는 스프링 웹 프로젝트>로 책 바꿈.
달라진 점 : 이클립스->STS, 자바8, 스프링3->스프링5, MySqlDB-> OracleDB

****최초 환경 설정시 주의 사항
 1. java 와 spring 각각 8, 5 버전으로
 2. 서블릿 3
 3. log4j : 기본은 1.2.15버전으로 돼있음. ->문제가 있으므로 1.2.16으로 바꾸고 버전 아래에 있는 것들은 삭제
 4. junit : 기본은 4.7 -> 4.12로
 5. jackson : 기본 2.9.7 -> 2.9.8로 바꿀것, 깃에서 자꾸 뭐라구 함ㅜ
 6. 스프링의 테스트 기능 쓰려면 pom에 spring-test도 추가해줘야 함.
****Oracle DB
SYSTEM/1111, 포트넘버 9090






<레퍼런스 메모>




코드로 배우는 스프링 웹 프로젝트


p. 64
  1) 테스트 코드가 실행되기 위해서 스프링 프레임워크가 동작
  2) 동작하는 과정에서 필요한 객체들이 스프링에 등록됨
  3) 의존성 주입이 필요한 객체는 자동으로 주입이 이루어짐.

p. 66 - 스프링 컨테이너가 객체들을 bean으로 관리하는 과정
 1) root-context.xml에 <component-scan> 태그 추가 : 스캔하여 bean으로 관리할 패키지 설정
 2) 패키지 내부에 @component가 붙어있는 클래스를 객체로 만들어서 bean으로 관리함.
 
 3) @autowired : @autowired가 붙은 메소드나 클래스 - 스프링 내부에서/ 자신이 특정한 객체에 의존적이므로/ 자신에게 해당 타입의 빈을/ 주입하라는 것. 
 
p.93 - myBatis와 스프링의 연동 처리
 1) mybatis의 mapper : SQL과 그에 대한 처리를 지정. SQL을 어떻게 처리할 것인지를 별도의 설정으로 분리하여 자동으로 처리되는 방식을 이용.
 2) mybatis-spring을 이용하는 경우 : mapper를 XML과 인터페이스+어노테이션의 형태로 작성 가능, 여기서는 최소한의 코드를 작성하는 인터페이스 방식 사용.
 
p. 100
 3) XML과 인터페이스 둘다 사용 가능 : XML 매퍼의 mapper 태그의 namespace속성값이 실제로 존재한다면, 이를 병합하여 처리함.
 4) 예제의 경우 메서드 선언은 인터페이스에 존재, SQL에 대한 처리는 XML 사용.

 p.118
  1) 스프링 mvc 프로젝트의 구동은 web.xml 에서 시작함. web.xml의 상단에 있는 context listner가 제일 먼저 구동됨.
  2) root-context.xml에 정의된 bean들은 스프링의 영역(context) 안에 생성됨 -> 객체들 간의 의존성이 처리.
  3) root-context.xml이 처리된 후에는 스프링 mvc에서 사용하는 DispatcherServlet이라는 서블릿과 관련된 설정이 동작됨.
  4) DispatcherServlet클래스는 스프링 mvc의 구조에서 가장 핵심적인 역할을 수행. 내부적으로 웹 관련 처리의 준비작업을 진행, 이때 사용하는 파일이 servlet-context.xml
  
  p.122 mvc 구동 방식
  (요청 -> dispatcherServlet -> handlerMapping -> HandlerAdapter -> Controller -> ViewResolver -> DispatcherServlet -> 사용자는 처리결과를 받는다.)
   1) DispatcherServlet : 일단 사용자로부터의 모든 요청 request는 DispatcherServlet으로
   2) HandlerMapping : 요청을 처리할 컨트롤러를 찾아줌
   3) HadlerAdapter : 컨트롤러를 찾았으면, 이 컨트롤러를 구동함
   4) Controller : 요청을 처리할 로직. 요청 처리 결과는 Model에 담아 View로 전달한다.
   5) ViewResolver : Controller의 처리결과를 어떤 View를 통해 처리하면 좋을지 해석해줌
   6) DispatcherServlet : 이제 모든 요청 처리가 끝났음. DispatcherServlet은 모든 처리가 끝난 결과를 View로 전달함.
   
  p.128 스프링 mvc의 controller
   1) requestMapping에서는 method의 속성 설정 가능(get/post)
   2) 이는 속성값을 주는 대신 @getMapping @postMapping으로 쓸 수도 있다.
  
  p.139 model이라는 데이터 전달자
   1) Controller에서는 Model타입을 파라미터로 지정 가능
   2) Model 객체는 JSP와 같은 view에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할
   3) 주로 Controller에 전달된 데이터를 이용해서 추가적인 데이터를 가져와야 하는 상황에 쓰임
   4) 스프링 MVC의 Controller는 기본적으로 Java Beans 규칙에 맞는 객체는 다시 화면으로 객체를 전달
   5) JAVA Beans의 규칙 : 단순히 생성자가 없거나 빈 생성자를 가져야 하며 + getter/setter를 가진 클래스의 객체들을 의미함
   6) int와 같은 기본 자료형의 경우는 파라미터로 선언해도, 기본적으로는 화면까지 전달은 안됨
    ->이를 전달하기 위해서는 Model 객체가 필요함. 
  
  p.143 RedirectAttributes -> part3에서 자세히 설명
   1) Model객체와 같은 역할
   2) 하지만 일회성임. 
  
  p.143 Controller의 리턴 타입
   1) void 타입 : 메서드의 리턴 타입을 void로 지정하는 경우, 일반적인 경우 해당 URL의 경로를 그대로 jsp파일의 이름으로 사용
