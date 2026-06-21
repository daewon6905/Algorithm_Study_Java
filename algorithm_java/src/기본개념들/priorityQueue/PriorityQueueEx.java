package 기본개념들.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    우선순위 큐에 단일 정수, 문자열이 아닌 복합 데이터(ex:좌표)를 저장해야 한다면 커스텀
    클래스를 구현하여 사용해야함. Comparable<T> 인터페이스를 구현해야함.
    이 인터페이스는 두 객체간 비교를 해주는 compareTo() 메서드를 가지고 있음.
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
        음수: this.age < o.age 자바는 음수가 나오면 this가 앞으로(우선순위)가 높음(오름차순 유지)
        0: 두 객체의 나이가 같다는 의미. 순서를 바꾸지 않음
        양수: this.age > o.age 자바는 양수가 나오면 this가 뒤로(우선순위)가 낮다고 판단하여 위치를 바꿈
     */
    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
        //오버플로우,언더플로우 고려해서 큰 숫자라면 Integer.compare(o.age, this.age) 고려
    }
}

/*
    들어온 순서에 상관없이, 일정한 기준(우선순위)에 따라 요소들이 나오도록 할 수 있음.
    이를 일반적인 queue와 구분 지어, priority queue라고 함.
 */
public class PriorityQueueEx {

    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(1);
        pq.add(2);
        //queue와 다르게 삽입된 순서대로 출력되지않고 오름차순(기본)으로 출력됨
        while (!pq.isEmpty()) {
            Integer remove = pq.remove();
            System.out.println(remove);
        }
        //내림차순
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    }

}
