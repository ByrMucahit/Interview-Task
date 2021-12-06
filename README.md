# Interview-Task

### Description
It's a retail website. Main aim of this app is take pay from customer. This market give discount on some act of customer, those discounts is limited with one, so this app 
reviews customers of this market,then gives a discount based on individual person. Just one exist thing is not good is percentage based on discount is not applied on phone.

### Install
This Explanation had been done with accepted that is project have been  installed to PC by user which include java jdk 16.0.2,maven apache 3.8.4 and git 2.33.0. 
If Those're not installed, visit those links;
1. https://www.youtube.com/watch?v=IJ-PJbvJBGs
2. https://www.youtube.com/watch?v=Hff-1uDH1Ts

1. First Step (Git)
You need to clone this repository into your local computer. 
For cloning:
* Firstly, open a command prompt, then write code following code.<br />
```
git clone https://github.com/ByrMucahit/Interview-Task.git
```

![Adsız](https://user-images.githubusercontent.com/62469567/144896054-983f1d01-05e9-451d-8e7b-75abb5b31556.png)


2. Second Step (Maven)
* In this step, we're going to open command prompt on exist maven project folder.
Following image is project folder.

![maven](https://user-images.githubusercontent.com/62469567/144897303-fad472bd-7e98-444c-8aa4-a527f32c925b.png)

* We're opening command prompt on this project folder,then write following code.
```
mvn test
```
!!! Warning, You shouldn't forget that this step all is inside this project folder.


* After seing build success, we write following code line.
```
mvn clean
```

* After build success,so We're on right way, and then writing code snippet below.
```
mvn install
```
* Last step of maven stage is following code
```
mvn clean install
```
After all, Some files will have been created on folder named "target".

* Now, we're going to inside target.

3. Third Step (Java)
* In this step, we're runing  project built on folder named target. java's needed in this section.
* If all this steps have been successfull, we can those folder like belove.


![maven7](https://user-images.githubusercontent.com/62469567/144900709-1325ef90-d99e-4486-a691-46d3f7c10086.png)

* Now, We're copying retailWebSite-0.0.1-SNAPSHOT, then opening command prompt again on target folder.
* We're writing code line below.
```
java -jar retailWebSite-0.0.1-SNAPSHOT.jar
```
* then, It's what we want. Finally, Project is runing.

![maven8](https://user-images.githubusercontent.com/62469567/144901839-814495a1-ab05-45be-9879-1348aeffce35.png)


### Analyzing

* It's needed to be enter in sequential for analyzing.
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
