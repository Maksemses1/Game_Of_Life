#!/bin/bash

rm -rf bin
mkdir bin

javac -d bin -sourcepath src src/GameOfLife/*.java
java -cp bin GameOfLife.Main
