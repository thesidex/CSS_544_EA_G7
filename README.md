
# Spring Attendance Management

Backend for attendance management module by group 7.

## Steps to install:
1) First install mvn dependencies for `common-base-module`.
```
cd common-base-module
mvn install
```

2) Copy `.env.sample` to a new file called `.env` and change credentials if required.
```
cp cs544-202403-project/src/main/resources/.env.sample cs544-202403-project/src/main/resources/.env
```

3) Install mvn dependencies for `cs544-202403-project`.
```
cd cs544-202403-project
MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED" mvn install -e
```



