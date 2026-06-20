package util;

import java.util.HashMap;
import java.util.Map;

//map의 value 값으로 커스텀 클래스 사용 가능
class Edge{
    public int destination;
    public int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class HashTable {
    Map<Integer, String> map = new HashMap<>();

    //커스텀 Edge 클래스 value로 사용
    Map<Integer, Edge> graph = new HashMap<>();

    //Map.of는 불변 (immutable) map을 생성
    Map<String, String> capitalMap = Map.of(
            "대한민국", "서울",
            "일본", "도쿄",
            "미국", "워싱턴DC"
    );

    public static void main(String[] args) {
        // Key: 학번(Integer), Value: 이름(String) 타입의 HashMap 선언
        Map<Integer, String> studentMap = new HashMap<>();

        // 1. 데이터 추가: put(key, value) - O(1)
        studentMap.put(2022390, "노정호");
        studentMap.put(2022392, "배준석");
        // 현재 map: {2022390=노정호, 2022392=배준석}

        // 2. 데이터 수정 (중복 Key 사용): put(key, value)
        studentMap.put(2022390, "이승규");
        // Key 2022390이 이미 존재하므로, Value가 "이승규"로 덮어씌워집니다.
        // 현재 map: {2022390=이승규, 2022392=배준석}

        // 3. 데이터 조회: get(key) - O(1)
        String name = studentMap.get(2022392); // name 변수에 "배준석"이 저장됨

        // 4. Key 존재 여부 확인: containsKey(key) - O(1)
        boolean hasStudent = studentMap.containsKey(2022390); // true

        // 5. 데이터 삭제: remove(key) - O(1)
        studentMap.remove(2022392); // Key 2022392에 해당하는 데이터 쌍을 삭제
        // 현재 map: {2022390=이승규}

        // 6. Map 크기 확인: size()
        int count = studentMap.size(); // count는 1


        //map 순회하기
        for (Integer key : studentMap.keySet()) {
            System.out.println("key : " + key + "value : " + studentMap.get(key));
        }

        for (String n : studentMap.values()) {
            System.out.println("value : " + n);
        }

        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("key : " + entry.getKey() + "value : " + entry.getValue());
        }
    }
}
