#!/bin/bash

# 1. Создаем папку bin, если её нет (или очищаем старую)
rm -rf bin
mkdir bin

# 2. Компилируем
# -d bin : указывает класть классы прямо в bin (пакеты создадутся сами)
# -sourcepath src : указывает, где искать исходники
javac -d bin -sourcepath src src/GameOfLife/*.java

# 3. (Опционально) Сразу запускаем для проверки
echo "Компиляция завершена. Запуск..."
java -cp bin GameOfLife.Main
