# Java Lesson: Classes, Objects, and Methods

This guided lesson introduces object-oriented programming (OOP) through a small Java console application. It is written for learners who are new to Java and can also be used as a teaching guide.

## Learning goals

- Explain the difference between a class, an object, a method, and an object reference.
- Declare a Java package and organize source files to match it.
- Create an object and call its instance methods.
- Compile and run a packaged Java class from the terminal.
- Recognize the role of the JDK, compiler, bytecode, and JVM.

The lesson uses Ubuntu, VS Code, and a JDK. Maven is not required because the program has no external dependencies. Type the example yourself where possible, and use the explanations to understand each step rather than only copying the final output.

## 1. Understand the exercise

The exercise asks you to create:

| Requirement | What you need to create |
|---|---|
| Project folder | `EmployeeDetails` |
| Package | `org.emp`, with matching folders under the source folder |
| Class | A public class named `Employee` in `Employee.java` |
| Methods | `empId()`, `empName()`, `empDob()`, `empPhone()`, `empEmail()`, and `empAddress()` |
| Object creation | Create an object with `new Employee()` |
| Method calls | Call all six methods through the object reference |

In plain language, define an `Employee` class, create one employee object, and ask it to display six pieces of information. The focus is on **classes, objects, and methods**; the exercise does not require implementing every OOP concept.

For this example, the methods print fictional demonstration data. Keyboard input, a database, and a separate launcher class are outside the scope of this first lesson.

### A simple mental model

- **Class:** a blueprint defining fields and behavior.
- **Object:** a particular instance created from that class.
- **Method:** an action defined by the class.
- **Object reference:** a variable that refers to an object so you can access it.

In this exercise, `Employee` is the class, `new Employee()` creates an object, and `employee` is the variable that refers to it.

## 2. Check your development environment

Run these commands in a terminal:

```bash
java -version
javac -version
git --version
```

`java` launches Java programs. `javac` compiles Java source files. Both commands should be available from the JDK installation. Git is only needed if you plan to save or submit the project using version control.

This example uses long-established Java syntax and does not require a specific recent Java release. Follow your course requirements if they specify a JDK version. If `javac` is missing, install or configure a JDK before continuing.

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

## 3. Create or open the project

If you are starting from the parent `Introduction` directory, create and open the project with:

```bash
pwd
mkdir -p EmployeeDetails/src/org/emp
mkdir -p EmployeeDetails/.vscode
cd EmployeeDetails
code .
```

`pwd` lets you verify your location before creating anything. `mkdir -p` creates the requested folders and any missing parent folders. `code .` opens the current project folder in VS Code.

If this project folder already exists, open `EmployeeDetails` in VS Code instead of creating another copy. The remaining terminal commands in this lesson should be run from the project root (the directory that contains `src/`).

Your project will eventually look like this:

```text
EmployeeDetails/
├── .gitignore
├── Readme.md
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

## 4. Write the program

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

The employee details in the example are **fictional demonstration data**. Before sharing this project, make sure the values in your own `Employee.java` are fictional too; do not publish personal phone numbers, dates of birth, email addresses, or home addresses.

For this introductory assignment, printing fixed values is enough. In a later lesson, you can store employee data in instance fields and initialize it with a constructor. We are deliberately not adding those concepts yet.

## 5. Understand the program, one part at a time

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

## 6. Compile and run the program

Save your files. Open a terminal in VS Code and confirm that its current directory is `EmployeeDetails`.

Create the output directory if it does not exist, then compile:

```bash
mkdir -p out
javac -d out src/org/emp/Employee.java
```

- `javac`: the compiler.
- `mkdir -p out`: creates the destination directory for compiled files.
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

The example source above prints:

```text
Employee ID: EMP001
Employee Name: Alex Morgan
Employee Date of Birth: 2000-05-15
Employee Phone: 000-000-0000
Employee Email: alex.morgan@example.com
Employee Address: 123 Example Street, Example City
```

The exact output depends on the text inside each method. Use fictional details, especially if the repository will be public.

The source-to-execution flow is:

```text
Employee.java -> javac -> Employee.class -> JVM -> console output
```

After modifying the source, compile again before running from the terminal. Otherwise, you may execute the previous compiled version.

### Run in VS Code too

With the Java extensions ready, use **Run** above `main`, or use **Run Java** from the editor. VS Code's Java debugger supports launching detected main classes without requiring you to create a launch configuration for a simple project. [VS Code: Running and debugging Java](https://code.visualstudio.com/docs/java/java-debugging)

Learn the terminal commands first: they explain what the editor does for you.

## 7. Apply the relevant Java naming and formatting conventions

| Item | Example | Convention |
|---|---|---|
| Project | `EmployeeDetails` | Follow the exercise's exact name; project naming is not a Java language rule |
| Package | `org.emp` | Lowercase, dot-separated components |
| Class | `Employee` | UpperCamelCase |
| File | `Employee.java` | Match the public class name exactly |
| Methods | `empId()`, `empName()` | lowerCamelCase; preserve the required names |
| Variable | `employee` | Descriptive lowerCamelCase |
| Indentation | Four spaces | Consistent nesting |
| Statements | End with `;` where required | For example, assignments and method calls |

Keep the required method names unchanged if the exercise specifies them; an instructor or automated checker may expect those exact names.

Avoid names such as `e`, `obj`, or `a` when `employee` communicates the meaning more clearly.

## 8. Save and submit your work (optional Git workflow)

### Review this lesson README

This document is the project README. Keep it in the project root and update it if you change the source code or run instructions.

### Check for an existing parent repository

Before initializing a new repository, run:

```bash
git rev-parse --show-toplevel
```

- If it reports **not a git repository**, proceed below if you want to create a repository for this project.
- If it prints a parent directory such as `Introduction`, decide whether coursework belongs in that existing repository. Avoid initializing a nested repository unless your course specifically requires it.
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
git add src/org/emp/Employee.java .gitignore Readme.md .vscode/settings.json
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
5. Add the remote using the URL you copied (replace the placeholder):

```bash
git remote add origin <repository-url>
```

6. Push your branch:

```bash
git push -u origin main
```

Authentication depends on your hosting service and setup. Do not paste access tokens into source files or commit them.

Open the remote repository in your browser and verify that the files are present. Submit its URL if your instructor requests a hosted repository.

## 9. Concepts to explore in a later lesson

This exercise provides a small introduction rather than a complete survey of Java or OOP. These related concepts are worth exploring next:

| Term | Explanation |
|---|---|
| JDK | The Java Development Kit includes tools such as `javac` and the components needed to run Java programs. Use a JDK to develop this exercise. |
| JVM | The Java Virtual Machine loads and executes Java bytecode and manages runtime tasks such as memory. A JVM may use just-in-time compilation while a program runs. |
| Bytecode | The compiler produces `.class` files containing bytecode, which a compatible Java runtime can execute. |
| Four OOP principles | Encapsulation, abstraction, inheritance, and polymorphism are often taught as core OOP principles. This program does not demonstrate all four. |
| Instance fields and constructors | These can store employee details in each object instead of printing fixed values directly in each method. |
| Input and validation | A later version could ask the user for details and validate the values before displaying them. |
| Unit testing | Tests can check behavior automatically without requiring a person to inspect each run. |
| Build tools | Maven or Gradle can manage dependencies, tests, and repeatable builds as a project grows. Neither is needed for this small example. |

Java's runtime, packaging, security, and concurrency are broader subjects. They are intentionally not treated as if this introductory exercise teaches them.

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
- [ ] Generated bytecode is not committed, and no real personal details are included before publishing.
- [ ] Remote repository contains the source and supporting files, if hosting is required.

## 12. Check your understanding

Before submitting, answer these in your own words:

1. What is the difference between `Employee` and `employee`?
2. What does `new Employee()` do?
3. Why do we create an object before calling `empName()`?
4. What is the difference between printing a value and returning a value?
5. Why do we run `org.emp.Employee`, rather than just `Employee`?
6. What happens if you change a method but never call it?

Done by **Ushindi B. Victoire** Software Q.A Engineer  | Requirement Specialist | @ub-victoire @ub-victor