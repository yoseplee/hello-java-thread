#!/bin/bash

# user input
which=$1

if [ ${which} == "cy" ]; then
	echo "compile and execute: cyclicBarrier"
	javac -d bin/cyclicBarrier/ src/cyclicBarrier/*.java
	echo "compile done"
	echo "---------------java execute---------------"
	java -cp bin/cyclicBarrier CyclicBarrierTest
	echo "------------------------------------------"
elif [ ${which} == "co" ]; then
	echo "compile and execute: countDownLatch"
	javac -d bin/countDownLatch/ src/countDownLatch/*.java
	echo "---------------java execute---------------"
	java -cp bin/countDownLatch/ CountDownLatchTest
	echo "------------------------------------------"
elif [ ${which} == "ex" ]; then
	echo "compile and execute: executor"
	javac -d bin/executor/ src/executor/*.java
	echo "---------------java execute---------------"
	java -cp bin/executor/ ExecutorTest
	echo "------------------------------------------"
fi
