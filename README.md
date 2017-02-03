# Abstract, Interface, Generic, Annotation
Java의 설계개념과 추가요소들을 이해합니다

## Interface
추상함수만갖고있는설계요소
```java
public interface City {
	// body{ } 가 없는 추상함수만 정의, 예약어인 abstract 가 생략된 형태
    public String name();
}

// 구현시 implements 사용
public class Seoul implements City {
	// 추상함수를 반드시 구현해야 한다.
	public String name(){

	}
}
```

## Abstract Class
추상함수와구현로직을갖는설계요소
```java
// abstract 예약어를 사용한다.
// class 이지만 new 로 instance 화 할 수 없다.
public abstract class Animal {
	// 구현로직 사용가능
	public void move(){
		System.out.println("움직인다");
	}
    public abstract String type();
}

// 구현시 extends 사용
public class Dog extends Animal {
	// 추상함수는 반드시 구현해야 한다.
	public String type(){

	}
}
```

## Generic
어떤속성에대한정의를하는설계요소
```java
// 1. 클래스에 generic 적용
class Person<T> { 
    public T info;
}

// 1.1. 타입을 동적으로 할당할 수 있다  
Person<String> p1 = new Person<>();  
p1.info = "이영후";  

Person<Integer> p1 = new Person<>();  
p1.info = 874632784;

// 2. 함수에 generic 적용
public static <E> void printArray(E[] elements) {
    for (E element : elements) {   
        System.out.println(element);  
    } 
}

// 3. wildcard 로 적용하는 generic
// ------------------------------------------------------------
// generic은 기본적으로 타입호환성(다형성)이 적용되지 않는다.
// 따라서, 인터페이스를 구현한 클래스를 인터페이스로 자동 캐스팅 해주지는 않는다.
// ------------------------------------------------------------

// 3.1 이 함수에서 Shape 을 상속한 어떤객체는 ? 와일드 카드에의해 형변환이 된다.
public static void drawShapes(List<? extends Shape> lists) {  
    for (Shape s : lists) {   
        s.draw();  
    } 
}

// 3.2 와일드카드를 사용하지 않고 부모객체 또는 인터페이스를 정의하면 하위 객체는 사용할 수 없다.
public static void drawShapes(List<Shape> lists) {  
	//...
}
```

## Annotation
Retention범위까지속성에대한정보를유지하는설계요소

| 속성 | 내용 |
| :--- | :--- |
| @Target | 적용할 대상 : CONSTRUCTOR, FIELD, ENUM, LOCAL VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE\(Class\)|
| @Retention | 어노테이션 정보의 유지단계 : SOURCE, CLASS, RUNTIME |
| @Documented | javadoc등에 문서화되어져야하는 엘리먼트일 경우 |
| @Inherited | 자동으로 상속받는 어노테이션 타입일 경우 |

```java
// 1. 애너테이션 만들기
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation {  
    public String val() default "값";
    public String key();
}

// 2. 애너테이션 적용
@Annotation(key = "키값추가1") 
public class Main {
    
}

// 3. 애너테이션 값 참조
Main main = new Main();
// Main 클래스에 적용된 Annotation의 val 와 key 값을 꺼낸다
String anno_a = main. getClass().getAnnotation(Annotation.class).val();
String anno_b = main. getClass().getAnnotation(Annotation.class).key();
```