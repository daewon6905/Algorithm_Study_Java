package tree;

import java.util.ArrayList;
import java.util.List;

//N-ary 트리 클래스 구현
public class Node2 {
    public int value;
    public List<Node2> children;

    public Node2(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
