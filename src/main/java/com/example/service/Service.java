package com.example.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Service {


	private Scanner sc;

	public Map<Integer, String> selStream(){
	  Map<Integer,String> map=new HashMap<Integer, String>();
		map.put(1, "coco");
		map.put(2, "apple");
		map.put(3, "demo");
		Set<java.util.Map.Entry<Integer, String>> entrySet = map.entrySet();
		for(java.util.Map.Entry<Integer, String> en:entrySet){
			System.out.println(en.getKey()+"========"+en.getValue());
			sc = new Scanner(System.in);
					  //友好提示
					  System.out.println("请您输入您的编号进行签到第一步");
					  Integer id =sc.nextInt();
					  int sum = 0;
						//进行判断
					  if(id.equals(en.getKey())){
						//根据key得到value	  
						  System.out.println(map.get(id));
						    sum=sum+1;
								}	
					  System.out.println("目前签到的人数为"+sum);
				}
		       
		           return map;
		}
}
