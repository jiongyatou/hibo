package com.controller;（安装包控制器）

import java.util.ArrayList;（导入一个现成的类这样就可以使用那个类的方法了，ArrayList<>这个是很常用的泛型集合

import com.model.MAnalData;（导入MAnalData包）

public class CAnalData extends MAnalData{（CAnalData类继承MAnalData，CAnalData是MAnalData子类，MAnalData是CAnalData的父类。一般一个java文件里面可以有很多个类，但是其中只有一个能用public修饰，也就是你所谓的主类，而且这个主类的名字应该与你的java文件的文件名相同比如：Hello.java里面
public class Hello{}
class Hahaha{}
class Hahaha2{}，Hello就是你的主类。类名和文件名相同）
	private char[] 	  datas;
	private ArrayList<char[]> list;（私有变量用set get表示设置和获取）
	//	控制类的构造方法;
	public CAnalData(String iData) {
		setiData(iData);
		datas=getDatas();
		list=new ArrayList<char[]>();
	}
	
	public void computeData(){（计算机应有的计算功能）
		char FLAG=datas[0];（字段类型char是指:使用指定长度的固定长度表示的字符串；比如char（8），则数据库会使用固定的1个字节(八位）来存储数据，不足8位的字符串在其后补空字符。FLAG起一个辅助判断的作用）
		//	设置ID编号
		setFLAG(FLAG);
		String temp="";
		int    size=0;
		//	位数的选择;
		switch (FLAG) {
		//	标准位;
		case 't':
			for(int i=1;i<4;i++){
				temp+=""+datas[i];（定义一个临时变量）
			}
			setDLC(Integer.parseInt(datas[4]+""));（这是一个泛型的写法，表示 这个集合中只能保存 integer 类型的对象，其他对象无法保存。parseInt(String s) 是Integer类型的一个静态方法.该方法的用途是将字符串参数作为有符号的十进制整数进行解析。）
			size=getDLC();（获取长度）
			
			for(int i=0;i<size;i++){
				int index=0;（index只是自己设置的一个变量）
				char[] data=new char[2];
				for(int j=i*2+5;j<(i*2+5)+2;j++){
					data[index]=datas[j];
					index++;（计算其物理值）
				}
				list.add(data);（List集合里的add方法. 表示向集合里添加元素）
				setDATA(list);（应该是设置一个队列的数据）
			}
			break;
		//	扩展位;
		case 'T':
			for(int i=1;i<9;i++){//扩展位后面有8个位，i<9
				temp+=""+datas[i];
			}
			setDLC(Integer.parseInt(datas[9]+""));
			size=getDLC();
			for(int i=0;i<size;i++){
				int index=0;
				char[] data=new char[2];
				for(int j=i*2+9;j<(i*2+9)+2;j++){
					data[index]=datas[j];
					index++;
				}
				list.add(data);
				setDATA(list);
			}
			break;
		default:
			break;
		}
		setID(temp);
	}
}


