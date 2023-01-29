### Prerequisite
1. sbt 

### How to run

```bash
sbt "run <file_path>"
```
file_path - should be without spaces and special characters

Examples
```bash
sbt "run incorrect_path" #incorrect path
# Can't load data from file(incorrect_path): incorrect_path (No such file or directory)

sbt "run data_small.txt" #correct path
#Minimal path is: 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 50
```

### Run tests

```bash
 sbt test
```