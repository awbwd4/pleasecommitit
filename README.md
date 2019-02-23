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

Json 타입?
http://egloos.zum.com/killins/v/3013974



web.xml
 - DispatcherServlet이 설정되어 있음.
 - 스프링 컨텍스트의 설정으로 root-context.xml이 지정돼있음.

<Spring context config>
 
 
spring의 context설정은 크게 root-context와 servlet-context로 나뉠 수 있다. 

1. servlet-context.xml : controllers, viewResolver, HandlerMapping
 - 웹 애플리케이션의 client 요청을 받기 위한 entry point
 - 서블릿의 context 설정에 해당.
 - 여기에는 요청에 대한 처리를 해줄 controller의 매핑 설정(handler mapping)
   + 요청 처리 후 view 처리를 어떻게 할 것인가에 대한 설정(view resolver) 등이 존재함.


2. root-context.xml : 비즈니스 계층, 데이터 소스 관련 repositories관련
 - 스프링 레임워크에서 관리해야 하는 객체(bean)를 설정하는 설정 파일.
 - 스프링이 로딩되면서 읽어 들이는 문서, 주로 이미 만들어진 클래스들을 이용해서 스프링의 bean으로 등록할 때 사용.
 - connection pool, dataSource, SQLSessionFactory등은 여기에.
 - 비즈니스 계층 + database와 연결되는 repository layer를 구성하는 bean에 대한 설정을 함.
 - 작동 방식
   1) 스프링 프레임워크가 시작되면, 먼저 스프링이 사용하는 메모리영역(스프링 컨텍스트)를 만듦.
     -> 스프링에선 applicationContext라는 이름의 객체가 만들어짐.
   2) 스프링은 자신이 객체를 생성하고 관리해야하는 객체들에 대한 설정이 필요. 이 설정이 root-context.xml
   3) root-context.xml에 설정되어있는 <context:component-scan> 태그의 내용을 통해서 해당 패키지(eg : org.zerock.controller)패키지를 스캔함.
   4) 해당 패키지에 있는 클래스들 중에서, 스프링이 사용하는 @Component 어노테이션이 존재하는 클래스의, 인스턴스를 생성함.
   5) Restaurant객체는 chef 객체가 필요하다는 어노테이션 설정(@autowired) 설정이 있음.
      따라서 스프링은 chef객체의 레퍼런스를 restaurant 객체에 주입함. 

다수의 servlet-context.xml을 갖게 될 경우, 이 servlet-context.xml 들이 root-context.xml의 bean 정보를 참조하는 구조가 될 수도 있다.

 => 따라서 contect component scan을 통한 bean 등록 설정에 주의해야 함.
  : 양쪽 context 설정에서 component scan설정을 통해 bean 등록을 할 때 
  controller와 service, repository 각 bean들이 등록되어야 하는 context에 맞게 등록이 되도록 해주어야 함.
  중복 등록을 하면 불필요한 자원 낭비 발생.

https://nice2049.tistory.com/entry/spring-rootContext-%EA%B7%B8%EB%A6%AC%EA%B3%A0-servletContext-%EB%8C%80%ED%95%B4%EC%84%9C


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
   2) String 타입 : 상황에 따라 다른 화면을 보여줄 필요가 있을 경우에 유용.
   3) 객체 타입 : VO(Value Object)나 DTO(Data Transfer Object) 타입 등 복합적인 데이터가 들어간 객체타입 ->주로 json 데이터를 만드는데 쓰임.
   4) ResponseEntity : http 프로토콜의 헤더를 다루는 경우
   
   p. 164 스프링 mvc 프로젝트의 기본 구성
    1) 웹 프로젝트는 3-tier로 구성됨 : presentation - business - persistence
    2) presentation tier : 화면에 보여주는 기술
    3) business tire : 순수한 비즈니스 로직, 고객이 원하는 요구 사항을 반영하는 계층. 고객의 요구사항과 정확히 일치하도록 설계돼야 함. 
       xxxService
    4) persistence tier : 데이터를 어떤 방식으로 보관하고, 사용하는가에 대한 설계가 들어가는 계층. 
    
   p.165 Naming Convention
     1) 3-tier로 구성하는 이유 : 유지보수 때문.
   
   p. 167 프로젝트를 위한 요구사항
     1) 요구사항은 온전한 문장으로 정리하는 것이 좋다. 
       eg) 고객은 새로운 게시물을 등록 할 수 있어야 한다. 
     2) 
