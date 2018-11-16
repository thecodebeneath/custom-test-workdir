# custom-test-workdir
Example of how legacy project with assumptions about resource file locations can be tested with Maven.

# Scenario
Assuming a legacy project that had a custom ant build, and classes that load files from relative directories.
When we convert that to a Maven build, this is a technique to mimic the test setup with no changes to the code under test
and minimal changes to the Maven default directories layout.

The application runtime assumption is that this directory structure is used:
```
- application.jar
|---- msgs/proj-a.messages
|-----msgs/proj-b.messages
```

Testing Approach:
- Approach #1 (first git commit) works, but has side effect of proj-a resource files include in the proj-b jar
- Approach #2 (second git commit) will fix the side effect of Approach #1
        
# Dependency Plugin
Instead of using the resources plugin to reach across the file system, just unzip the proj-a jar 
and filter include/exclude which files we need for testing proj-b.
            
# Surefire Plugin
Run tests in a custom directory because of MessageManager relative path expectations. Don't use an
existing maven directory (like target/classes, because those files get included in the proj-b jar.
