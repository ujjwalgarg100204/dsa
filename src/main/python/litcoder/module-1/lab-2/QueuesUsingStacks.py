import re
from typing import List


class Queue:
    def __init__(self):
        self.main_stack: List[int] = []
        self.temp_stack: List[int] = []

    def enqueue(self, num: int) -> None:
        self.main_stack.append(num)

    def dequeue(self) -> int:
        # empty main stack into temp stack to get
        # element which was enqueued first
        self.__switch_stack(self.main_stack, self.temp_stack)
        dequeued = self.temp_stack.pop()
        # set the stacks back to normal
        self.__switch_stack(self.temp_stack, self.main_stack)
        return dequeued

    def front(self) -> int:
        # empty main stack into temp stack to get
        # element which was enqueued first
        self.__switch_stack(self.main_stack, self.temp_stack)
        front_element = self.temp_stack[-1]
        # set the stacks back to normal
        self.__switch_stack(self.temp_stack, self.main_stack)
        return front_element

    @staticmethod
    def __switch_stack(from_stack: List[int], to_stack: List[int]) -> None:
        while from_stack:
            to_stack.append(from_stack.pop())


q = Queue()
inputs = list(map(int, re.split(r"[ ,]", input())))
i = 0
while i < len(inputs):
    if inputs[i] == 1:
        q.enqueue(inputs[i + 1])
        i += 2
    elif inputs[i] == 2:
        q.dequeue()
        i += 1
    else:
        print(q.front())
        i += 1
