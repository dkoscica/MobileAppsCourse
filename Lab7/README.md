![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 7
Goal of this lab is to introduce MVVM architecture and LiveData.

## 1. LoginViewModel
Goal of this task is to implement the LoginViewModel.</br>
The max point value for this task is **3 point**.

### Lecture
* [Android Architectures](https://drive.google.com/file/d/1Lk9U09fHvpyffWBKiu-vD-aQIRpmb9ai/view)
### Documentation
* https://developer.android.com/jetpack/docs/guide

### Requirements
* **Read carefully the following documentation till the Fetch data section:** https://developer.android.com/jetpack/docs/guide
* Create a new **config** package and add a java class with the name **Mock** within the config package.
* Add the following code snippet to the **Mock** class
    ```java
    public class Credentials {
        public static final String EMAIL = "student@gmail.com";
        public static final String PASSWORD = "password";
        public static final String TOKEN = "EvNElvTOZvi1fnczpuVR77dQT3GlKkjtaRSFZmEo";
    }
    ```
* Add a **User** class within the **model** package and implement the class regarding the following UML diagram: https://drive.google.com/file/d/1_Bh0xYxwjIBzYgB9c5GszN5E_B0FksGB/view
* Add a **public static final User USER** instance to the Mock class within the **config** package. Use the **Credentials.EMAIL** and **Credentials.TOKEN** to create the instance.
* Create a **AuthInteractorMockImpl** class within the **interactors** package.
* Implement the **AuthInteractor** interface within the **AuthInteractorMockImpl** class
* The **MutableLiveData<User> login(String email, String password)** method should check if the provided email and password match the **Mock.Credentials**. If they match return the **Mock user object**, if not return **null**
* Create a **LoginViewModel** class within the **login** package
* The **LoginViewModel** must implement the **MutableLiveData<User> login(String username, String password)** method
* The **MutableLiveData<User> login(String username, String password)** method must use an instance of the **AuthInteractorMockImpl** class to login the user
* Create an **LoginViewModel** instance within the **LoginActivity**
    * Given that the user has entered credentials that match the Mock credentials show a Toast message and redirect the user to the HomeActivity.
    * Given that the user has entered invalid credentials. Invalid credentials are all credentials that don't match the Mock credentials use the **showInvalidCredentialsMessage** to show an error message.

## 2. BookDetailsViewModel
Goal of this task is to implement the BookDetailsViewModel.</br>
The max point value for this task is **2 point**.

### Lecture
* [Android Architectures](https://drive.google.com/file/d/1Lk9U09fHvpyffWBKiu-vD-aQIRpmb9ai/view)
### Documentation
* https://developer.android.com/jetpack/docs/guide

### Requirements
* Create a **BookDetailsViewModel** class within the **screen/bookdetails** package
* The **BookDetailsViewModel** must implement **
<Book> getBookById(long id)** method
* The **MutableLiveData<Book> getBookById(long id)** method should use an instance of the **BookRepository** to find the book by id
* Create an **BookDetailsViewModel** instance within the **BookDetailsFragment**
* Use the **getBookById(long id)** method from the **BookDetailsViewModel** instance to **setupCardView(View view, Book book)**

## License
* Copyright 2019 © Dominik Košćica.
