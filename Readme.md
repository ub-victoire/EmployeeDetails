# Session 1: Your first Java OOP exercise

## Goal

Build a small Java program, understand how it works, and submit its source code in a Git repository.

We will use **Ubuntu + VS Code + your installed JDK**, without Maven. Maven is useful later for dependencies, testing, and repeatable builds, but this exercise does not need it.

**Working assumptions:** each question needs its own repository; the six methods may print fictional employee details; no keyboard input, database, or separate launcher class is required. These are reasonable interpretations of the assignment, not extra requirements from your instructor.

Type the code yourself if possible. The aim is to understand it, not just obtain the output.

## 1. Understand the question before coding

Your assignment specifies:

| Requirement | What you need to create |
|---|---|
| Project: `EmployeeDetails` | A folder named `EmployeeDetails` |
| Package: `org.emp` | A package declaration and matching folders under the source folder |
| Class: `Employee` | A file named `Employee.java` containing `public class Employee` |
| Six named methods | `empId()`, `empName()`, `empDob()`, `empPhone()`, `empEmail()`, `empAddress()` |
| Create an object | Use `new Employee()` |
| Call the methods | Call each method through the object reference |
| Follow coding standards | Correct naming, indentation, file organization, and readable code |

In plain English:

> Define what an employee can do, create one employee object, and ask it to display six details.

The question does **not** ask you to implement all four OOP pillars. Its main focus is **classes, objects, and methods**.

## How to run the project in terminal 
`javac -d . src/org/emp/Employee.java && java src/org/emp/Employee.java`

1. `javac` stands for **Java Compiler**

it converts Java code (.java) into bytecode (.class) that the Java Virtual Machine(JVM) can execute.

`javac Employee.java` This comples that  file and generate `Employee.class` the the JVM can be able to execute them.

so 

- `Employee.java` = source code you write
- `javac`= Compiler that  translates your code.
- `Employee.class` = compiled Java bytecode

2. What is `-d`

- `-d` is a compiler option that tells `javac` where the put the generated `class` files.

eg: `javac -d output Employee.java`

This tells java to put the compiled class files inside the `output` directory 

### A simple mental model

- **Class:** a blueprint defining fields and behavior.
- **Object:** a particular instance created from that class.
- **Method:** an action defined by the class.
- **Object reference:** a variable through which you can access an object.

In this exercise, `Employee` is the class, `new Employee()` creates an object, and `employee` will be the variable referring to that object.

## 2. Check your environment

Your pasted output shows that Java, VS Code, Git, and Maven are installed. It does not independently confirm that the Java compiler is available in your shell.

Run these commands in your Ubuntu terminal:

```bash
java -version
javac -version
git --version
```

`java` launches programs. `javac` compiles Java source files.

If both Java commands report version 25, keep that JDK for this exercise. There is no reason to downgrade just because the course notes mention Java 8. The code below uses long-established Java syntax; if your instructor requires an older submission target, confirm that separately.

If `javac` is missing, stop here and share the error before installing or changing anything.

### Configure VS Code

Install **Extension Pack for Java**, published by Microsoft. It provides the recommended core Java editing, project, and debugging support. [VS Code: Java extensions](https://code.visualstudio.com/docs/java/extensions)

You can install it from your terminal:

```bash
code --install-extension vscjava.vscode-java-pack
```

Or open Extensions with **Ctrl+Shift+X**, search for the exact name, and install it.

If VS Code cannot find your JDK:

1. Press **Ctrl+Shift+P**.
2. Run **Java: Configure Java Runtime**.
3. Select your installed JDK for this project without a build tool. VS Code calls this an *unmanaged folder*. [VS Code: Managing Java Projects](https://code.visualstudio.com/docs/java/java-project)

You do not need to set `JAVA_HOME` manually unless a tool reports a problem.

## 3. Create the project structure

Run these commands **from the `Introduction` directory shown in your terminal**:

```bash
pwd
mkdir -p EmployeeDetails/src/org/emp
mkdir -p EmployeeDetails/.vscode
cd EmployeeDetails
code .
```

`pwd` lets you verify your location before creating anything. `mkdir -p` creates the requested folders and any missing parent folders. `code .` opens the current project folder in VS Code.

Your project will eventually look like this:

```text
EmployeeDetails/
├── .gitignore
├── README.md
├── .vscode/
│   └── settings.json
└── src/
    └── org/
        └── emp/
            └── Employee.java
```

After compiling, a generated `out/` folder will also appear. Do not submit that generated folder.

### Why `org/emp`?

The package name is `org.emp`. Its two components map to two directories under the source root:

```text
Package:       org.emp
Source root:   src/
Source file:   src/org/emp/Employee.java
```

Use dots in the Java package declaration and slashes in the filesystem path. `src` is the source root, not part of the package name.

### Add project settings

Create `.vscode/settings.json` in VS Code:

```json
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "out"
}
```

This tells the Java extension where your source files are and where compiled files should go. It deliberately avoids an absolute JDK path, which would be specific to your machine.

### Add a Git ignore file

Create `.gitignore`:

```gitignore
# Generated Java bytecode and build output
*.class
out/
bin/
target/

# Local logs
*.log
```

We will commit the small, portable VS Code settings file, but not compiled output.

**Checkpoint:** you should have opened `EmployeeDetails`, not its parent directory, as your VS Code workspace.

## 4. Implement the assignment

Create `src/org/emp/Employee.java` and type:

```java
package org.emp;

public class Employee {

    public void empId() {
        System.out.println("Employee ID: EMP001");
    }

    public void empName() {
        System.out.println("Employee Name: Alex Morgan");
    }

    public void empDob() {
        System.out.println("Employee Date of Birth: 2000-05-15");
    }

    public void empPhone() {
        System.out.println("Employee Phone: 000-000-0000");
    }

    public void empEmail() {
        System.out.println("Employee Email: alex.morgan@example.com");
    }

    public void empAddress() {
        System.out.println("Employee Address: 123 Example Street, Example City");
    }

    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.empId();
        employee.empName();
        employee.empDob();
        employee.empPhone();
        employee.empEmail();
        employee.empAddress();
    }
}
```

All employee details above are **fictional demonstration data**. Do not publish your real phone number, date of birth, or home address in a public learning repository.

For this introductory assignment, printing fixed values is enough. In a later lesson, you can store employee data in instance fields and initialize it with a constructor. We are deliberately not adding those concepts yet.

## 5. Understand the code

### The package declaration

```java
package org.emp;
```

This places the class in the `org.emp` package. Its fully qualified class name is `org.emp.Employee`.

### The class declaration

```java
public class Employee {
```

- `public`: an access modifier that makes the class accessible from other packages.
- `class`: declares a class.
- `Employee`: the class name, written in UpperCamelCase, also called PascalCase.
- Braces enclose the class body.

Because this is a public top-level class named `Employee`, the file must be named **`Employee.java`**. Ubuntu filenames are case-sensitive.

### An instance method

```java
public void empId() {
    System.out.println("Employee ID: EMP001");
}
```

- `public`: other code can access the method.
- `void`: the method does not return a value to its caller.
- `empId`: the method name, written in lowerCamelCase.
- `()`: this method accepts no arguments.
- `System.out.println(...)`: prints the supplied text and then a newline.

**Printing is not returning.** This method produces console output, but it returns no value.

The six employee methods are **instance methods** because they are not declared `static`. We call them on an employee object.

### The entry point

```java
public static void main(String[] args) {
```

For this exercise, use this conventional entry-point signature exactly:

| Part | Meaning |
|---|---|
| `public` | Accessible to the Java launcher |
| `static` | Belongs to the class; no `Employee` object is needed to invoke this method |
| `void` | Returns no value |
| `main` | Conventional entry-point method name |
| `String[] args` | An array receiving command-line arguments |

`static` is a **non-access modifier**, not an access modifier. Also, Java 25 supports additional beginner-friendly entry-point forms; using this traditional form keeps your code aligned with your course and older Java versions.

### Creating an object

```java
Employee employee = new Employee();
```

Read this as:

> Create an `Employee` object and store a reference to it in a variable named `employee`.

| Part | Meaning |
|---|---|
| First `Employee` | The variable's declared type |
| `employee` | The reference variable's name |
| `=` | Assigns the reference produced on the right |
| `new` | Creates an instance |
| `Employee()` | Invokes the constructor |
| `;` | Ends the statement |

We did not write a constructor. Because the class declares no constructors, Java supplies a default no-argument constructor.

**A constructor is not a regular method.** Do not add a return type to a constructor.

### Calling a method

```java
employee.empId();
```

The dot accesses the method through the object reference. Parentheses invoke it.

The execution order is:

```text
Start main
    -> Create one Employee object
    -> Call empId
    -> Call empName
    -> Call empDob
    -> Call empPhone
    -> Call empEmail
    -> Call empAddress
End main
```

Only one object is needed to call all six methods.

## 6. Compile and run from the terminal

Save your files. Open a terminal in VS Code and confirm that its current directory is `EmployeeDetails`.

Compile:

```bash
javac -d out src/org/emp/Employee.java
```

- `javac`: the compiler.
- `-d out`: writes generated class files under `out`, creating the required package folders.
- The final argument identifies the source file.

A successful compilation usually prints nothing. It creates:

```text
out/org/emp/Employee.class
```

Run:

```bash
java -cp out org.emp.Employee
```

- `java`: launches the program.
- `-cp out`: sets the classpath root to `out`.
- `org.emp.Employee`: names the class to launch.

Do **not** add `.java` or `.class` to the class name in this command.

Expected output:

```text
Employee ID: EMP001
Employee Name: Alex Morgan
Employee Date of Birth: 2000-05-15
Employee Phone: 000-000-0000
Employee Email: alex.morgan@example.com
Employee Address: 123 Example Street, Example City
```

The source-to-execution flow is:

```text
Employee.java -> javac -> Employee.class -> JVM -> console output
```

After modifying the source, compile again before running from the terminal. Otherwise, you may execute the previous compiled version.

### Run in VS Code too

With the Java extensions ready, use **Run** above `main`, or use **Run Java** from the editor. VS Code's Java debugger supports launching detected main classes without requiring you to create a launch configuration for a simple project. [VS Code: Running and debugging Java](https://code.visualstudio.com/docs/java/java-debugging)

Learn the terminal commands first: they explain what the editor does for you.

## 7. Apply the coding standards relevant today

| Item | Use here | Rule |
|---|---|---|
| Project | `EmployeeDetails` | Follow the assignment's exact name; project naming is not a Java language rule |
| Package | `org.emp` | Lowercase, dot-separated components |
| Class | `Employee` | UpperCamelCase |
| File | `Employee.java` | Match the public class name exactly |
| Methods | `empId()`, `empName()` | lowerCamelCase; preserve the required names |
| Variable | `employee` | Descriptive lowerCamelCase |
| Indentation | Four spaces | Consistent nesting |
| Statements | End with `;` where required | For example, assignments and method calls |

Do not change the required method names to supposedly better names: the instructor may check those exact names.

Avoid names such as `e`, `obj`, or `a` when `employee` communicates the meaning more clearly.

## 8. Prepare your repository

### Add a README

Create `README.md` with:

````markdown
# EmployeeDetails

Java OOP introduction — Question 01.

## Objective

Create an Employee class in the org.emp package, instantiate it, and call
empId(), empName(), empDob(), empPhone(), empEmail(), and empAddress().

## Requirements

A JDK providing java and javac. This project uses no external dependencies.

## Compile and run

Run from the project root:

```bash
javac -d out src/org/emp/Employee.java
java -cp out org.emp.Employee
```

## Concepts practiced

- Packages and classes
- Instance methods
- Object creation
- Method calls
- The conventional main method

All employee details are fictional demonstration data.
````

### Check for an existing parent repository

Before initializing a new repository, run:

```bash
git rev-parse --show-toplevel
```

- If it reports **not a git repository**, proceed below. That result is expected for a new, independent project.
- If it prints a parent directory such as `Introduction`, stop and decide how your coursework should be organized. Because you said each question needs its own repository, avoid accidentally creating nested repositories.
- If it prints this `EmployeeDetails` directory, the repository already exists; skip `git init`.

### Initialize and commit

For a new independent repository:

```bash
git init -b main
git status
```

If Git asks for your identity, configure it **for this repository** using your own name and email:

```bash
git config user.name "Your Name"
git config user.email "your-email@example.com"
```

Replace those example values. For a public hosting service, consider its private/no-reply commit email option rather than exposing your personal email.

Stage only the intended files:

```bash
git add src/org/emp/Employee.java .gitignore README.md .vscode/settings.json
git diff --cached
git commit -m "Complete EmployeeDetails OOP exercise"
git status
```

Review the staged diff before committing. Confirm that `out/` and `.class` files are absent. After the commit, `git status` should report a clean working tree.

### Publish if the assignment requires a hosted repository

Git and GitHub are not the same thing: Git tracks your changes locally; GitHub, GitLab, and similar services host remote repositories.

For GitHub, for example:

1. Create an empty repository named `EmployeeDetails` under your account.
2. Choose visibility according to your instructor's requirements.
3. Do not initialize the remote with a README, license, or ignore file; you already have a local commit.
4. Copy the repository's actual HTTPS or SSH URL.
5. Run `git remote add origin` followed by that URL on the same command line.
6. Push:

```bash
git push -u origin main
```

Authentication depends on your hosting service and setup. Do not paste access tokens into source files or commit them.

Open the remote repository in your browser and verify that the files are present. Submit the **repository URL**, unless your instructor requests a different format.

## 9. Important corrections to your lesson notes

Your notes are useful as an introduction, but some statements are inaccurate or outdated. Keep these distinctions:

| Topic | More accurate explanation |
|---|---|
| OOP | Usually means **Object-Oriented Programming**, not “Object Oriented Programming Structure.” |
| Class | Defines fields and behavior; it is not simply a collection of objects. |
| Object | An instance of a class, not merely “runtime memory allocation.” |
| JDK | Development tools, including the compiler, plus the components needed to run Java programs. You need a JDK to develop this exercise. |
| JRE | The runtime environment: the JVM and supporting libraries/components, not just predefined class files. A compatible runtime can run compiled programs without all development tools; modern distributions package runtimes in different ways. |
| JVM | Loads and executes bytecode and manages runtime concerns such as memory. `javac` compiles source to bytecode; a JVM may also use JIT compilation during execution. |
| Java versions | Java did not stop at “1.9.” Java 9 and later use version numbers such as 9, 17, 21, and 25. Java 8 is not an automatic best choice for a new learner. |
| Portability | Compatible bytecode can run on different operating systems with suitable Java runtimes. The JVM implementation itself is platform-specific, and libraries/native dependencies can affect portability. |
| Multithreading | Threads allow concurrent work; actual simultaneous execution depends on available processors and scheduling. |
| Security | Java has features such as type checking, bytecode verification, and memory management. It is not a “virtual firewall” and does not automatically prevent unauthorized access. |
| Open source | OpenJDK is an open-source implementation of Java. Open source concerns license rights, not merely whether something costs nothing. |
| Four main OOP pillars | Encapsulation, abstraction, inheritance, and polymorphism. Classes and objects are foundational building blocks. |
| Editor shortcuts | The shortcuts listed in your notes are editor-specific, not Java language features. Do not assume Eclipse shortcuts apply to VS Code. |

You do not need to master all these corrections before completing Question 01.

## 10. Troubleshooting

| Symptom | What to check |
|---|---|
| `javac: command not found` | The compiler is missing or not on `PATH`; verify JDK installation before proceeding. |
| `file not found: src/org/emp/Employee.java` | Run from `EmployeeDetails` and check the file path and capitalization. |
| Public class must be in `Employee.java` | The filename must exactly match the public class name. |
| `Could not find or load main class` | Compile first, run from the project root, and use `java -cp out org.emp.Employee`. |
| `non-static method ... cannot be referenced from a static context` | Use `employee.empId()` after constructing the object, rather than calling `empId()` directly inside `main`. |
| `cannot find symbol` | Check spelling, capitalization, and whether the variable or method exists. |
| `';' expected` | Check the reported line and the preceding line for a missing semicolon. |
| Output does not reflect your changes | Save the file, compile again, then run again. |
| VS Code does not recognize the project | Open the project root, check the extension pack and source-path settings, and allow Java initialization to finish. |
| `UnsupportedClassVersionError` | The execution runtime is older than the bytecode target; compare `java -version` and `javac -version`. |

## 11. Final submission checklist

- [ ] Project folder is named `EmployeeDetails`.
- [ ] Source file is `src/org/emp/Employee.java`.
- [ ] Package declaration is `package org.emp;`.
- [ ] Public class is named `Employee`.
- [ ] All six required methods exist with the exact names.
- [ ] `main` creates an `Employee` object.
- [ ] All six methods are called through that object reference.
- [ ] Compilation succeeds and the output has six detail lines.
- [ ] README explains how to compile and run.
- [ ] No generated bytecode or real personal details are committed.
- [ ] Remote repository contains the source and supporting files, if hosting is required.

## 12. Check your understanding

Before submitting, answer these in your own words:

1. What is the difference between `Employee` and `employee`?
2. What does `new Employee()` do?
3. Why do we create an object before calling `empName()`?
4. What is the difference between printing a value and returning a value?
5. Why do we run `org.emp.Employee`, rather than just `Employee`?
6. What happens if you change a method but never call it?

@ub-victoire , @ub-victor
