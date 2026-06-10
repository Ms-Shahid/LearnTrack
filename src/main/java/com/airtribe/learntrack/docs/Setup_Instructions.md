
# Setup Instructions 

## Java Development Kit 

JDK Version = Oracle OpenJDK-23

### How to run "Hello World" program 

#### Phase 1 : Setting up

1. Download the latest JDK version  
2. Create a file with any name followed by `.java` extension
3. open up the file in notepad or any IDE of choice, such as Vscode, Intellij
4. Write a simple program as follows 

```java
public class JavaProgram{
    
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
 ```

#### Phase 2 : Running up the program
1. open up the terminal & go to the path of the file. 
2. Run the program, by typing the cmd -> `javac <filename.java>` in our case `javac JavaProgram.java`
3. It create the `.class` file, which a byte code ( machine readable code), this byte code is also platform independent, meaning it can run on any machine. 
4. You can see both `.java` file( actual file ) & `.class` file byte code 
5. Now run the `.class` file, using cmd -> `java <filename>` in our case, `java JavaProgram`
6. Great, you can see the "Hello World" displayed on the console. 

