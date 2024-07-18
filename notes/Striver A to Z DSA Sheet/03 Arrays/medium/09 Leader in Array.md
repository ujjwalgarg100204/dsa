---
id: 09 Leader in Array
aliases: []
tags:
  - medium
---

# Leader in Array

Problem Link: [GeekForGeeks](https://bit.ly/3bZqbGc)
Video Solution Link: [Striver](https://youtu.be/cHrH9CQ8pmY)

## Solutions

```java
public List<Integer> optimal(int arr[]) {
  var res = new ArrayList<Integer>();

  int max = arr[arr.length - 1];
  res.add(max);
  for (int i = arr.length - 2; i >= 0; i--) {
    if (arr[i] >= max) {
      res.add(arr[i]);
      max = arr[i];
    }
  }

  // reverse the result
  for (int i = 0; i < res.size() / 2; i++) {
    int temp = res.get(i);
    res.set(i, res.get(res.size() - i - 1));
    res.set(res.size() - i - 1, temp);
  }

  return res;
}
```
