### 자바란?

#### 정의
1995년에 만들어진 객체 지향 프로그래밍 언어

#### 특징
플랫폼 독립적인 자유로운 개발

객체 지향 언어

잘 갖춰진 Java/Spring 생태계

WORA - Write Once, Run Anywhere

오래된 언어인가?

### 점유율

#### 여전히 높은 점유율

Java / Spring 스택은 여전히 널리 사용 많은 채용 건수

단순히 채용건수 뿐만 아니라 실질적인 상위권 기업에서 사용 타 언어/프레임워크-> Java/Spring 케이스도 존재

Kotlin/Spring과는 별도의 점유율

### 자바의 변수, 메서드 구조

# 3단 분석법

---

| 순서 | 분석 | 단어 | 내용 |
| --- | --- | --- | --- |
| 1 | 정의 | 메서드 구조 | 변수: 값을 저장하는 공간, 메서드: 특정 기능을 수행하는 코드 묶음 |
| 2 | 알아야하는 이유 | 메서드 구조 | 언어별 차이를 이해하고 혼동 없이 사용하기 위해 필요 |
| 3 | 동작방식 | 메서드 구조 | 변수는 타입과 함께 선언, 메서드는 접근제어자, 리턴 타입, 메서드명, 매개 변수 사용 |

---

## 1. 정의

| 개념 | 설명 |
| --- | --- |
| 변수 | 값을 저장하는 주소값을 가진 공간 |
| 메서드 | 클래스 내부에 정의된 특정 작업을 수행하는 코드 묶음 |

---

## 2. 알아야 하는 이유

프로그래밍 언어마다 변수와 메서드를 사용하는 방식이 다릅니다. 자바는 엄격한 규칙을 따르지만, 개념은 대부분의 언어와 유사합니다.

---

## 3. 동작 방식

| 개념 | 설명 |
| --- | --- |
| 변수 | 타입과 함께 선언 |
| 메서드 | 접근제어자, 리턴 타입, 메서드명, 매개 변수 포함 |

### **변수 선언 예제**
```java
int number = 6;
String name = "Yaro";
double weight = 10.1;
```

### **기본 자료형 (Primitive Types)**
| 타입 | 크기 | 값 범위 |
| --- | --- | --- |
| `int` | 4 byte | -2,147,483,648 ~ 2,147,483,647 |
| `double` | 8 byte | ±1.79769313486231570E+308 |
| `boolean` | 1 bit | true, false |

```java
int age = 25;
double height = 175.5;
boolean isStudent = false;
```

### **참조 자료형 (Reference Types)**
```java
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}
Person p = new Person("John");
```

---

## **메서드의 구조**
```java
public int add(int a, int b) {
    return a + b;
}
```
| 구성 요소 | 설명 |
| --- | --- |
| 접근제어자 | `public`, `private`, `protected` 등 |
| 리턴 타입 | 메서드가 반환하는 데이터 유형 |
| 메서드명 | `add` (동작을 나타내는 이름) |
| 매개변수 | `int a, int b` (입력값) |

### **메서드 호출**
```java
int sum = add(5, 10);
System.out.println(sum); // 15
```

---

## **자바 코드 예제**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(greet("Hello, World!"));
    }
    public static String greet(String message) {
        return message;
    }
}
```

---

## **접근 제어자 (Access Modifiers)**

| 접근제어자 | 클래스 내부 | 같은 패키지 | 하위 클래스 | 외부 접근 |
| --- | --- | --- | --- | --- |
| `public` | O | O | O | O |
| `protected` | O | O | O | X |
| `default` | O | O | X | X |
| `private` | O | X | X | X |

### **사용 원칙**
- **변수와 메서드는 기본적으로 `private` 사용**
- **필요한 경우 `getter/setter` 메서드를 `public`으로 제공**
- **공통적으로 사용될 메서드는 `public`으로 선언**

```java
public class Person {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

---

## **정리**
- 변수는 값을 저장하는 공간이며, 타입을 선언해야 함.
- 메서드는 특정 기능을 수행하는 코드 블록으로, 접근제어자, 리턴 타입, 매개변수를 포함.
- 접근제어자를 통해 클래스와 메서드의 접근 범위를 제한.
- 올바른 변수와 메서드 사용으로 코드의 가독성과 유지보수성을 높일 수 있음.


### 자바의 변수 유형

# 자바 변수 유형 및 메모리 구조

## 1. 변수 유형과 특징

| 변수 유형 | 선언 위치 | 특징 |
| --- | --- | --- |
| **지역 변수** | 메서드 내부 | 함수 내에서 선언, 메서드 종료 시 소멸 |
| **매개 변수** | 메서드 매개변수 | 함수 호출 시 전달, 종료 후 제거 |
| **인스턴스 변수** | 클래스 내부 (객체 속성) | 객체별 고유 값 저장, 힙 메모리 사용 |
| **클래스 변수** | 클래스 내부 (static) | 여러 객체가 공유, 메서드 영역에 저장 |

### **자바 변수 예제 코드**
```java
public class VariableTypes {
    double instanceVariable;  // 인스턴스 변수 (힙)
    static int classVariable; // 클래스 변수 (메서드 영역)

    public void method(int parameter) { // 매개변수 (스택)
        int localVariable; // 지역 변수 (스택)
    }
}
```

---

## 2. 왜 중요한가?

- **효율적인 메모리 관리**  
  변수 유형별 메모리 저장 방식 최적화 가능.

- **코드 가독성과 유지보수성 향상**  
  역할에 맞게 변수 사용 시 코드 이해가 쉬워짐.

- **성능 최적화**  
  클래스 변수는 공유, 지역 변수는 빠른 해제로 성능 향상.

---

## 3. 동작 방식 (메모리 할당)

| 변수 유형 | 저장 위치 |
| --- | --- |
| **지역 변수 & 매개 변수** | 스택(Stack) |
| **인스턴스 변수** | 힙(Heap) |
| **클래스 변수** | 메서드(Method) 영역 |

---

### **자바 변수 메모리 동작 예제**
```java
public class Main {
    static int num = 1; // 클래스 변수 (메서드 영역)

    public static void main(String[] args) {
        int a = 1;  // 지역 변수 (스택)
        int b = 2;  // 지역 변수 (스택)
        int c = a + b + Main.num; // 4 (지역 변수)

        Calculator cal = new Calculator(); // 힙에 객체 생성
        showLastResult(cal);
        cal.sum(a, b);
        showLastResult(cal);
    }

    public static void showLastResult(Calculator d) {
        d.getLastResult();
    }
}

class Calculator {
    int lastResult = 0; // 인스턴스 변수 (힙)

    public void getLastResult() {
        System.out.println(this.lastResult);
    }

    public int sum(int n, int m) { // 매개 변수 (스택)
        int sumValue = n + m; // 지역 변수 (스택)
        this.lastResult = sumValue; // 힙에 저장된 값 변경
        return sumValue;
    }
}
```

---

## 4. 실행 흐름

### **1. 클래스 변수 및 메서드는 메서드 영역으로 이동**
- `static int num` → 메서드 영역에 저장
- `Main.class` 및 `Calculator.class`의 메서드들도 메서드 영역에 로드됨

### **2. main 메서드 실행 (스택에 지역 변수 저장)**
- `a = 1`, `b = 2`, `c = 4` (스택 메모리에 저장)
- `num` 변수는 메서드 영역에서 참조됨

### **3. 객체 생성 (힙에 저장)**
- `Calculator cal = new Calculator();` 실행 시 힙에 객체 생성

### **4. 메서드 호출 및 스택 프레임 관리**
- `showLastResult(cal);` → `getLastResult()` 호출 (스택 프레임 생성 및 제거)
- `cal.sum(a, b);` → `sum()` 실행 후 결과 저장 (스택 프레임 생성 및 제거)

### **5. GC (가비지 컬렉션) 처리**
- `main()` 종료 후 `Calculator` 객체가 힙에서 제거됨.


### 클래스

# 클래스(class)의 정의

## 1. 클래스란?
클래스는 **관련된 속성과 메서드를 묶어 객체를 생성하기 위한 템플릿**입니다. 이를 쉽게 이해하기 위해 **자동차 설계도**에 비유할 수 있습니다.

## 2. 클래스와 객체의 관계
- 클래스 = 자동차 설계도 (기본 속성과 기능 정의)
- 객체 = 설계도를 바탕으로 만들어진 자동차 (실제 인스턴스)

## 3. 클래스 확장 (상속)
일반 자동차와 버스를 예로 들면, 버스는 더 많은 바퀴와 속도 제한이 필요합니다.
즉, 기존 자동차 설계도를 확장하여 새로운 기능을 추가하는 것을 **클래스 확장(상속)**이라고 합니다.

```java
class Vehicle {
    String brand;
    void move() {
        System.out.println("Moving...");
    }
}

class Bus extends Vehicle {
    int wheels = 6;
}
```

---

## 4. 클래스 사용 이유
| 클래스 | **코드를 직관적으로 쉽게 볼 수 있고, 재사용성과 유지보수성을 높이기 위해 사용** |
| --- | --- |

```java
public class Dog {
    String name;
    public Dog(String name) {
        this.name = name;
    }
    public void bark() {
        System.out.println(this.name + " says woof");
    }
}

Dog myDog = new Dog("Rex");
myDog.bark(); // Rex says woof
```

---

## 5. 클래스의 구조
```java
public class Dog {
    // 속성 (변수)
    String name;
    int age;

    // 생성자
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 메서드 (행동)
    public void bark() {
        System.out.println("Woof!");
    }
}
```

### 1) 속성 (Attributes)
객체의 상태를 나타내는 변수 (예: `name`, `age` 등)

### 2) 메서드 (Methods)
객체가 수행할 동작을 정의 (예: `bark()` 메서드)

### 3) 생성자 (Constructor)
객체를 생성할 때 호출되는 특별한 메서드 (예: `public Dog(...)`)

---

## 6. 객체 생성 및 사용
```java
Dog dog1 = new Dog("Buddy", 3);
Dog dog2 = new Dog("Charlie", 5);

dog1.bark(); // Buddy says woof!
dog2.bark(); // Charlie says woof!
```

---

## 7. 생성자와 this 키워드
```java
public class Dog {
    String name;
    public Dog(String name) {
        this.name = name; // this를 사용해 멤버 변수와 구분
    }
}
```
`this`는 **자기 자신의 객체**를 참조할 때 사용합니다.

---

## 8. 메서드 오버로딩 (Method Overloading)
같은 이름의 메서드를 여러 개 정의할 수 있습니다.
```java
public class Dog {
    public void bark() {
        System.out.println("Woof!");
    }
    public void bark(String name) {
        System.out.println(name + " says woof!");
    }
}
```

---

## 9. 정적 메서드 (Static Method)
정적 메서드는 객체 생성 없이 호출할 수 있습니다.
```java
public class Dog {
    public static void speak() {
        System.out.println("Dogs bark!");
    }
}
Dog.speak(); // Dogs bark!
```

---

## 10. 상속 (Inheritance)
클래스는 다른 클래스로부터 **속성과 메서드를 상속**받을 수 있습니다.
```java
class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}
class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof!");
    }
}
```

---

## 11. 메서드 오버라이딩 (Method Overriding)
상속받은 메서드를 **새롭게 정의**할 수 있습니다.
```java
class Dog {
    void bark() {
        System.out.println("Woof!");
    }
}
class Puppy extends Dog {
    void bark() {
        System.out.println("Squeaky woof!");
    }
}
```

---

## 12. 결론
- **클래스는 객체 생성을 위한 템플릿**이며, **코드 재사용성과 유지보수성을 높이는 핵심 개념**입니다.
- **상속, 오버로딩, 오버라이딩**을 활용하면 **더 효율적인 코드 작성**이 가능합니다.



### 자바의 변수, 메서드 구조


