package 기본개념들.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> nameSet = new HashSet<>();

        // 1. 데이터 추가: add(element) - O(1)
        nameSet.add("노정호");
        nameSet.add("배준석");
        // 현재 set: {"노정호", "배준석"}

        // 2. 중복 데이터 추가 시도
        boolean isAdded = nameSet.add("노정호"); // "노정호"는 이미 존재하므로 추가되지 않음
        // isAdded 변수에는 false가 저장됨
        // 현재 set: {"노정호", "배준석"}

        // 3. 데이터 존재 여부 확인: contains(element) - O(1)
        boolean hasName = nameSet.contains("배준석"); // true

        // 4. 데이터 삭제: remove(element) - O(1)
        nameSet.remove("노정호");
        // 현재 set: {"배준석"}

        // 5. Set 크기 확인: size()
        int count = nameSet.size(); // count는 1

        //순회는 for each문으로 가능. 순서는 보장 x
        for (String name : nameSet) {
            System.out.println(name);
        }
    }
}
