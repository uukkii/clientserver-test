## Домашнее задание к занятию 1.5 Клиент-серверное взаимодействие. Blocking и Non-Blocking IO.
### Задача 1. Тяжелые вычисления

Задание выполнено. Выбор пал в сторону blocking взаимодействия, поскольку
взаимодействие пользователя с сервером ограничиваемся одной задачей.

Вывод в консоль:

**Клиент (точка входа - User.java):**
```
Input N number: 
10
Your Fibonacci number: 34
```

**Сервер (точка входа - Application.java):**
```
The number 10 has gotten.
```

### Задача 2. Долой пробелы

Задание выполнено. Вывод в консоль:

**Клиент (точка входа - User.java):**
```
Type your line or 'end' to exit:
test line with spaces
Your line without spaces: testlinewithspaces
Type your line or 'end' to exit:
another test line with spaces
Your line without spaces: anothertestlinewithspaces
Type your line or 'end' to exit:
end

Process finished with exit code 0
```

**Сервер (точка входа - Application.java):**
```
The line has gotten: test line with spaces
The line has gotten: another test line with spaces
```