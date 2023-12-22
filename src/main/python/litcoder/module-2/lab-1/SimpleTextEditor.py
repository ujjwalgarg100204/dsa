import re
from collections import deque


class CustomStack:
    def __init__(self):
        self.__editor: deque[str] = deque()
        self.__temp: deque[str] = deque()

    def insert(self, val: str) -> None:
        self.__editor.append(val)

    def delete(self, count: int) -> None:
        while True:
            len_top_editor = len(self.__editor[-1])
            if count - len_top_editor <= 0:
                break

            count -= len_top_editor
            self.__temp.append(self.__editor.pop())

            # check for deleting entire string
            if len(self.__editor[-1]) == count:
                self.__editor.pop()
            else:
                self.__editor[-1] = self.__editor[-1][0 : count - 1]
            self.__cleanup()

    def get(self, index: int) -> str:
        for text in self.__editor:
            if index > len(text):
                index -= len(text)
                continue
            return text[index - 1]

        return ""

    def undo(self) -> None:
        self.__editor.pop()

    def __cleanup(self) -> None:
        while self.__temp:
            self.__editor.append(self.__temp.pop())


editor = CustomStack()
commands = re.split(r"[ ,]", input())
i = 0
while i < len(commands):
    increment = 2
    if commands[i] == "1":
        editor.insert(commands[i + 1])
    elif commands[i] == "2":
        editor.delete(int(commands[i + 1]))
    elif commands[i] == "3":
        print(editor.get(int(commands[i + 1])))
    else:
        editor.undo()
        increment = 1

    i += increment
