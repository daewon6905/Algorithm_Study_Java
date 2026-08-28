난이도: lvl1

처음에 Linked list 생각했으나 당연하게 시간 초과가 남. remove, add, indexOf 모두 O(n) 시간 복잡도 이기 때문.
그래서 map으로 인덱스를 기록해두고 업데이트해서 매번 인덱스를 O(1)로 찾아올 수 있게 풀이.