#!/bin/sh

javac -d build -cp "./jars/*" SendEmail.java
java -cp ./build:./jars/javax.mail.jar:./jars/activation-1.1-rev-1.jar SendEmail 
