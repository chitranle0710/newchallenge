# newchallenge
**MVVM, Singleton are 2 design patterns which are used here.** 
- Firstly, I tested API and then get the POJO that I wanted then I created a data class called Weahter Origin, inside it, there are some inner classes which is the object that would show on the screen. 
- Secondly, I built base architecture: Ktor is using to call API, which is a new technology instead of using Retrofit then Repository to contain the data source, usecase to seperate different cases to call something, the purpose of using usecase is when there are changes in repository, we can easily modify the usecase, instead of changing all the projects. I used MVVM for this project for the modernity and match with the NAB's projects. 
- I created the UI as the attachment and did the checklist according to the requirements. 
**This project is applied these architecture components and frameworks, including: **
- Lifecycle helps you create components that are aware of the current Android lifecycle state.
- ViewModel holds data and survives configuration changes.
- LiveData provides observable data to views.
- View binding allows you to more easily write code that interacts with views.
- Ktor is built from the ground up using Kotlin and Coroutines.
- Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Easy to learn and apply
**Clone this project and then run on your local computer**
**Checklist: 1,2,3,4,5. 6-only proguard**
