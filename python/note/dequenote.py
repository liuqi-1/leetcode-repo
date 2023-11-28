from collections import deque

d = deque()

# 在双端队列的右边添加元素
d.append(1)
d.append(2)
# 在双端队列的左边添加元素
d.appendleft(3)
# 在指定index位置添加元素
d.insert(2, 5)
print(d)

# 查找元素的index
idx = d.index(5, 0, 3)
print(idx)

# 将右边最后一个元素移动到左边第一个位置
d.rotate()
print(d)

# 查找指定元素的个数
print(d.count(1))
