<<<<<<< HEAD
# stream-java8
=======
# 11.25-1-2


7.4之前学习掌握文档内容
使用基于xml的配置元数据，您可以指定您的bean类:
  With XML-based configuration metadata you can specify your bean class as follows:
      <bean id="exampleBean" class="examples.ExampleBean"/>
       <bean name="anotherExample" class="examples.ExampleBeanTwo"/>


使用静态工厂方法实例化
       在定义用静态工厂方法创建的bean时，使用class属性来指定
   包含静态工厂方法的类和一个名为factory - method的属性指定
   工厂方法本身的名称。
   下面的bean定义指定将通过调用factory方法来创建bean。在
   定义没有指定返回对象的类型(类)，只指定包含工厂的类
   方法。在这个示例中，createInstance()方法必须是一个静态方法。

             <bean id="clientService"
        class="examples.ClientService"
        factory-method="createInstance"/>


      public class ClientService {
      private static ClientService clientService = new ClientService();
         private ClientService() {}
        public static ClientService createInstance() {
         return clientService;
           }
	}

7.4文档内容
     依赖注入
    依赖注入(DI)是一个对象定义其依赖关系的过程，即，另一个
它们使用的对象仅通过构造函数参数、参数到工厂方法或属性
在从工厂方法构造或返回的对象实例之后设置该对象。容器
然后在创建bean时注入这些依赖项。这个过程从根本上说是逆的，
因此，控制bean本身的名称反转(IoC)

Constructor-based依赖注入
         基于构造的DI由调用构造函数的容器完成
    参数，每个参数表示一个依赖项。用特定参数调用静态工厂方法
    构建bean几乎是等价的，并且这个讨论将参数处理给构造函数和
    类似于静态工厂方法。下面的示例显示了一个只能依赖于注入的类
    构造函数注入。注意，这个类没有什么特别之处，它是一个POJO
    不依赖于容器的特定接口、基类或注解。


    public class SimpleMovieLister {
    
    private MovieFinder movieFinder;
          / /一个构造器，这样Spring容器就可以注入MovieFinder
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

     }
...发现这些都学过...
 

  7.5 Bean范围
       当您创建一个bean定义时，您将创建一个用于创建类定义的实际实例的方法
   的bean定义。
      单例的范围
      仅对单例bean的一个共享实例进行管理，并使用id或id请求bean
  匹配该bean定义的ids将导致Spring返回一个特定的bean实例
  容器。
    

   原型范围

    将bean注入到另一个bean中,您可以通过容器上的getBean()方法来请求它。
   作用域bean作为依赖项.如果您想要注入(例如)一个HTTP请求范围bean
在更长的范围内的另一个bean中，您可以选择在作用域的位置注入AOP代理
bean。也就是说，您需要注入一个代理对象，它公开与作用域相同的公共接口
对象，但也可以从相关的范围(比如HTTP请求)检索实际的目标对象
委托方法调用真实对象。


 <?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop.xsd">
	    <!-- 作为代理的HTTP会话作用域的bean -->
	<bean id="userPreferences" class="com.foo.UserPreferences" scope="session">
	    <!-- 指示容器代理周围的bean-->
	    <aop:scoped-proxy/>
	</bean>
	    <!--一个单作用域的bean，注入了一个代理到上面的bean -->
		<bean id="userService" class="com.foo.SimpleUserService">
	    <!-- 对 userPreferences bean的引用 -->
   		 <property name="userPreferences" ref="userPreferences"/>
        </bean>
   </beans>

  7.12
     @ bean注释用于表示方法实例化、配置和初始化a

       XML配置@ bean注释扮演的角色与< bean/ >元素相同。您可以使用
   然而，使用任何Spring @ component的@ bean注释方法通常都是使用的
   @ configuration bean。
     用@ configuration注释类表示其主要目的是作为bean的源
  定义。此外，@ configuration类允许定义bean之间的依赖关系
  简单地调用同一类中的其他@ bean方法。最简单的@ configuration类
    @Configuration
	public class AppConfig {
    @Bean
	public MyService myService() {
	   return new MyServiceImpl();
	}
		}

     上面的AppConfig类将相当于以下Spring <bean /> XML:

      <beans>
	   <bean id="myService" class="com.acme.services.MyServiceImpl"/>
     </beans>

     Bean的依赖关系
           一个@ bean注释的方法可以有一个描述依赖项的任意数量的参数
      需要构建该bean。例如，如果我们的转移服务需要一个AccountRepository
      我们可以通过一个方法参数来实现这种依赖:




            使用具有公共关闭或关闭方法的Java配置定义的bean
	自动加入销毁回调。如果你有公共关闭或关闭
	方法和您不希望在容器关闭时调用它，只需添加
	对您的bean定义，禁用默认(推断)模式

	 @Bean(destroyMethod="")
	public DataSource dataSource() throws NamingException {
	return (DataSource) jndiTemplate.lookup("MyDS");
		}

         指定bean范围
	 使用@ scope注释
		您可以指定使用@ bean注释定义的bean应该具有特定的范围。你
		可以使用Bean作用域中指定的任何标准范围。
		默认的范围是singleton，但是您可以用@ scope注释覆盖它:

    @Configuration
	public class MyConfiguration {
    @Bean
    @Scope("prototype")
	public Encryptor encryptor() {
	// ...
		}
	}

       编写基于java的配置
     使用@ import注释
     就像在Spring XML文件中使用< import/ >元素来帮助模块化配置一样，
     @ import注释允许从另一个配置类加载@ bean定义:
         @Configuration
	   public class ConfigA {
	@Bean
	   public A a() {
		return new A();
		  }
		}
	@Configuration
	@Import(ConfigA.class)
		public class ConfigB {
	@Bean
	   public B b() {
		return new B();
		}
	}


   	    现在，而不是需要指定两个ConfigA。类和ConfigB。类实例化时
 	上下文，只需要显式提供ConfigB:

        public static void main(String[] args) {
 	   ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);
	// 现在，A和B都可用了……
		A a = ctx.getBean(A.class);
		B b = ctx.getBean(B.class);
	    }

    
          有另一种方法可以达到同样的效果。请记住@ configuration类是
     最终，容器中的另一个bean:这意味着他们可以利用@ autowired和@ value注入等等.

          @Configuration
		public class ServiceConfig {
	@Autowired
		private AccountRepository accountRepository;
	@Bean
		public TransferService transferService() {
		return new TransferServiceImpl(accountRepository);
           }
	}
	@Configuration
		public class RepositoryConfig {
		private final DataSource dataSource;
	@Autowired
	public RepositoryConfig(DataSource dataSource) {
	this.dataSource = dataSource;
	}
	@Bean
	public AccountRepository accountRepository() {
	return new JdbcAccountRepository(dataSource);
		}
	}
	@Configuration
	@Import({ServiceConfig.class, RepositoryConfig.class})
		public class SystemTestConfig {
	@Bean
		public DataSource dataSource() {
		
	}
   }
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);

	TransferService transferService = ctx.getBean(TransferService.class);
	transferService.transfer(100.00, "A123", "C456");
 	 }

springboot - Runner


 开发中可能会遇到这样的需求，需要在容器启动的时候执行一些内容，比如读取配置文件，数据库操作等等。
SpringBoot给我们提供了两个接口来帮助我们定制这种需求，这两个接口分别为CommandLineRunner和ApplicationRunner，
他们会在容器启动完成后执行。这两个接口中有一个run方法，我们只需要实现这个方法即可。这两个接口的不同之处在于：
ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。










>>>>>>> branch 'master' of https://github.com/TJLYT/11.25-1-2.git
