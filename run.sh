
# build
# gocode/build.sh

# run
#javac -cp jna.jar Client.java
#java -cp .:jna.jar Client
#javac -cp . jna.jar src/main/java/com/example/App.java 
#java -cp .:jna.jar com.example.App

#javac -cp jna-4.4.0.jar src/main/java/com/example/App.java 
# javac -cp jna.jar src/main/java/com/example/App.java -Xlint:deprecation
javac -cp jna-3.0.9.jar src/main/java/com/example/App.java -Xlint:deprecation

# make jar
echo "Manifest-Version: 1.2" > manifest.txt
echo "Main-Class: com.example.App" >> manifest.txt

# mkdir com
# mkdir com/example
# cp src/main/java/com/example/App.class ./com/example/App.class

# jar cvfm Tester.jar manifest.txt src/main/java/com/example/App.class
jar cvfm Tester.jar manifest.txt App.class
# jar cvfm Tester.jar manifest.txt com/exmaple/App.class

# try this
# https://stackoverflow.com/questions/9689793/cant-execute-jar-file-no-main-manifest-attribute