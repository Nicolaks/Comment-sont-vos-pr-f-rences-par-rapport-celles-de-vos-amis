#!bin/sh

[ -d build ] || mkdir bin
javac -d build src/*.java 
java -cp build src.Main
