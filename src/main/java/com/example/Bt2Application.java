package com.example;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//打开SpringBootApplication注解可以发现，
//它是由其他几个类组合而成的：@Configuration（等同于spring中的xml配置文件，使用Java文件做配置可以检查类型安全）、
//@EnableAutoConfiguration（自动配置）、@ComponentScan（组件扫描，大家非常熟悉的，可以自动发现和装配一些Bean）
@SpringBootApplication
public class Bt2Application {
  /*  @Autowired
	private Service service;*/
	private static Scanner sc;
	public static void main(String[] args) {
		
		SpringApplication.run(Bt2Application.class, args);
		
		selStream();
		
	
	}
	@Bean
	//：这个方法会在应用程序启动后首先被调用。
	public CommandLineRunner runner() {
		return args -> {
		
		};
    }
	public static int selStream(){
		  Map<Integer,String> map=new HashMap<Integer, String>();
			map.put(1, "coco");
			map.put(2, "apple");
			map.put(3, "demo");
			//遍历
			Set<java.util.Map.Entry<Integer, String>> entrySet = map.entrySet();
			for(java.util.Map.Entry<Integer, String> en:entrySet){
				 
			sc = new Scanner(System.in);
			  //友好提示
			  System.out.println("请您输入您的编号进行签到第一步");
			  Integer id =sc.nextInt();
						
	            //进行判断
				if(id.equals(en.getKey())){
		       //根据key得到value	  
				  System.out.println(map.get(id)+"签到成功");						   
				}	
				  
			}
			   int sum = 0;
			   sum=sum+1;
			   System.out.println("目前签到的人数为"+sum);
			   return sum;
		}

}

