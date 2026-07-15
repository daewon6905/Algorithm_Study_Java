난이도 : Hard

단순해보이는데 상당히 어렵다. 이런 유형에 약한거같다.

**풀이 1.**

스택에 height 배열의 인덱스를 저장해두는데, 물이 고이는 조건을 고려하여 현재 stack.peek()이 그 다음 i 인덱스의 높이보다 작으면, 넓이를 계산하는 방식으로 해결한다. (단조스택의 연장선)

스택을 활용해서 저 예시로 시작해보면, while(!stack.isEmpty() && height[i] > height[stack.peek()]) 이 조건 만족하는 동안 넓이를 계산한다. 반복문의 현재 i 가 오른쪽 벽을, stack에서 pop을 하면 bottom (바닥)을, stack에 pop을 하고 다음 요소를 peek()하면 그게 왼쪽 벽을 담당한다.

가로는 **int w =  right - left - 1** , 높이는 좌우 벽 중 낮은걸 기준으로 bottom(바닥) 높이를 빼면 된다.

**int h = Math.min(height[i],height[stack.peek()] - height[bottom]**

넓이는 w * h