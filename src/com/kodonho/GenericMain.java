package com.kodonho;

import java.util.ArrayList;
import java.util.List;

public class GenericMain {

	public static void main(String[] args) {    
        Integer[] intArray = {10, 20, 30, 40};  
        String[] stringArray = {"가", "나", "다", "라"};    
        printArray(intArray);  
        printArray(stringArray); 
        
        // 와일드 카드로 사용하는 제네릭
        Triangle tri = new Triangle();
        Triangle tri2 = new Triangle();
        Triangle tri3 = new Triangle();
        
        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle();
        Rectangle rect3 = new Rectangle();
        
        ArrayList<Triangle> shapeList = new ArrayList<>();
        shapeList.add(tri);
        shapeList.add(tri2);
        shapeList.add(tri3);
        
        draw(shapeList);
        
        CR3F cr3f = new CR3F();
        
        // HeaterInterface 를 구현한 구현체
        CR1F cr1f = new CR1F();
        
        // HeaterInterface 를 받을 수 있는 객체
        HeaterRun hr = new HeaterRun();
        
        // HeaterInterface 를 구현한 모든 객체를 받을 수 있다.
        hr.run(cr1f);
        
        // 애너테이션 사용
        ForAnno anno = new ForAnno();
        // 클래스에서 애너테이션 정보 가져오기
        String anno_val = anno.getClass().getAnnotation(Annotation.class).val();
        String anno_key = anno.getClass().getAnnotation(Annotation.class).key();

        System.out.println("anno_key="+anno_key+", anno_val="+anno_val);
        
    }
	
	// 함수에서 와일드 카드 사용하기
	public static void draw(List<? extends Shape> list){
		for(Shape s:list){
			s.drawShape();
		}
	}
 
    // 함수에서 사용되는 형태
    public static <E> void printArray(E[] elements) {  
        for (E element : elements) {   
            System.out.println(element);  
        } 
    }
}

@Annotation(key="이것이애너테이션이다!")
class ForAnno {
	
}

//클래스 생성시 제너릭을 적용하면 클래스 내부멤버의 타입을 동적으로 변경할 수 있다.
class Person<T> {
	public T who;
}