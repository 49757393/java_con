javac -cp ./postgresql-42.2.12.jar:./rt.jar ConDb.java 
java -cp ./postgresql-42.2.12.jar:./rt.jar:. ConDb

javac -cp ./rt.jar ReadCsv.java
java -cp . ReadCsv



javac -cp ./postgresql-42.2.12.jar:./rt.jar ReadCsv.java BrchQryDtl.java ConDb.java JavaToPg.java 
java -cp ./postgresql-42.2.12.jar:. JavaToPg 


gradle init
修改主函数和加入引用包，再把代码当道src里面
gradle build
gradle shadowJar
java -jar ./build/libs/con_db_java-all.jar 
主函数的类 一定要写package 不然会找不到这个主类