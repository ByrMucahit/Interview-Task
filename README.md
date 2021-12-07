# Interview-Task

### Description
This is a retail website. The main goal of this app is to receive payments from customers. This market provides discounts to customers based on their status, each customer is limited to a single discount. This application examines the status of every customer and provides discounts based on them. The only downside of this campaign is that discounts aren't applicable to phone purchases.

### Install

This directory has been written assuming that the following programs are installed java jdk 16.0.2,maven apache 3.8.4 and git 2.33.0. 
If they are not installed, visit the links below:
1. https://www.youtube.com/watch?v=IJ-PJbvJBGs
2. https://www.youtube.com/watch?v=Hff-1uDH1Ts<br />
--

1. First Step (Git)
You need to clone this repository into your local computer. 
For cloning:
* First, open a command prompt, then write the following code.<br />
```
git clone https://github.com/ByrMucahit/Interview-Task.git
```

![Adsız](https://user-images.githubusercontent.com/62469567/144896054-983f1d01-05e9-451d-8e7b-75abb5b31556.png)


2. Second Step (Maven)
* In this step, we're going to open the command prompt that exists in the maven project folder.
Following image is the project folder.

![maven](https://user-images.githubusercontent.com/62469567/144897303-fad472bd-7e98-444c-8aa4-a527f32c925b.png)

* Open the command prompt in this folder then, write the following code.
```
mvn test
```

!!! Warning, Don't forget that these steps must all be performed within this folder.


* After seeing "build success", we write the following code line.
```
mvn clean
```

* After "build success",so everything is going right,then write the code snippet below.
```
mvn install
```
* Last step of maven stage is the following code
```
mvn clean install
```
After all, Some files will have been created on a folder named "target".

* Now, we're going inside target.

3. Third Step (Java)
* In this step, we're running  project built on "target". java's needed in this section.
* If all these steps have been successful, we can see the folders  below.


![maven7](https://user-images.githubusercontent.com/62469567/144900709-1325ef90-d99e-4486-a691-46d3f7c10086.png)

* Now, we copy retailWebSite-0.0.1-SNAPSHOT, then we open the command prompt again on the folder "target".
* Write the code line below..
```
java -jar retailWebSite-0.0.1-SNAPSHOT.jar
```
* The following image is what we want, this means that the project is finally running.

![maven8](https://user-images.githubusercontent.com/62469567/144901839-814495a1-ab05-45be-9879-1348aeffce35.png)


### Analyzing

* You need to sequentially  enter the following to analyze:
```
mvn clean verify sonar:sonar -Dsonar.login=myAuthenticationToken
```

```
mvn clean install
```
```
mvn sonar:sonar -Dsonar.login=myAuthenticationToken
```
```
mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar
```
