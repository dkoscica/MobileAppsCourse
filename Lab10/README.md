![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 9
Goal of this lab is to introduce Networking in Android.

## Prerequisites
* Use the **git pull origin master** command to pull the latest changes
* Start using the Android Studio built in formatter. Each file that is modified or created **must** be formatted with the built in formatter: https://medium.com/mindorks/11-android-studio-shortcuts-every-android-developer-must-know-a153e736e611

## 1. Postman
Goal of this task is to try out Postman.</br>
The max point value for this task is **1 point**.

### Lecture
* [Networking](https://drive.google.com/file/d/1_mtTizhjt_JiSAxTxveosZFT-eKBTxLc/view)

### Documentation
* https://www.getpostman.com/
* https://www.guru99.com/postman-tutorial.html

### Requirements
* Download Postman https://www.getpostman.com/
* Download the following postman collection/configuration: https://drive.google.com/open?id=1xGhno2CXf9zXUj8mX-FMJ--3GTuYKcxL
* Import the **WkBooks.postman_collection** into Postman and try out all endpoints
* Add at least two additional endpoints from the API you will use for your project

## 2. Setup Retrofit instance
Goal of this task is to setup the Retrofit instance.</br>
The max point value for this task is **1 point**.

### Lecture
* [Networking](https://drive.google.com/file/d/1_mtTizhjt_JiSAxTxveosZFT-eKBTxLc/view)

### Documentation
* https://www.baeldung.com/retrofit

### Requirements
* Create an Retrofit object in the constructor of the **NetworkManager** class
* The Retrofit object must use the **OkHttpClient provideClient(SessionManager sessionManager)** method as a client.
* The Retrofit object must use the **GsonConverterFactory provideConverterFactory()** method as converter factory.
* Read the following article: https://medium.com/@son.rommer/fix-cleartext-traffic-error-in-android-9-pie-2f4e9e2235e6 and fix the Cleartext Traffic Error in Android 9 Pie. Use the **useCleartextTraffic** attribute method in the **AndroidManifest** to fix the issue.

## 3. Token validation - POST ValidateToken
Goal of this task is to implement the validateToken Retrofit call</br>
The max point value for this task is **1 point**.

* Open **Postman** and take a look at the **POST ValidateToken** method.
* Add the **Call<TokenResponse> validateToken();** method to the **AuthService** interface within **network/services** package.
* Add a corresponding Retrofit annotation to the **Call<TokenResponse> validateToken();** method.
* Replace the
    ```java
    private AuthInteractor authInteractor = new AuthInteractorMockImpl();
    ```
  with **AuthInteractorImpl** within the **SplashViewModel** class.
* Implement the **LiveData/<User> validateToken()** method within the **AuthInteractorImpl** class.
* Use the **AuthService** to create a Retrofit network call
* Given that your receive a valid response containing a User object, the app user should be redirected to the **HomeActivity**
* Given that your receive a invalid response, error or the response doesn't contain a User object, the app user should be redirected to the **LoginActivity**

## 4. Login request - POST Login
Goal of this task is to implement the login Retrofit call</br>
The max point value for this task is **1 point**.

* Open **Postman** and take a look at the **POST Login** method.
* Currently only the following credentials will return a valid token: **email: admin@app.com password: password**
* Add the **Call<LoginResponse> login(@Body LoginRequest loginRequest);** method to the **AuthService** interface within **network/services** package.
* Add a corresponding Retrofit annotation to the **Call<LoginResponse> login(@Body LoginRequest loginRequest);** method.
* Replace the
    ```java
    private AuthInteractor authInteractor = new AuthInteractorMockImpl();
    ```
  with **AuthInteractorImpl** within the **LoginViewModel** class.
* Implement the **LiveData<String> login(String email, String password)** method within the **AuthInteractorImpl** class.
* Use the **AuthService** to create a Retrofit network call
* Given that your receive a valid response containing a token, store the token with the help of the **SessionManager** class and redirect the user to the **HomeActivity**
    ```java
    SessionManager.getInstance().setToken(token);
    ```

## 5. GET Books
Goal of this task is to implement the GET Books Retrofit call</br>
The max point value for this task is **1 point**.

* Open **Postman** and take a look at the **GET BOOKS** method.
* Add the **Call<BookResponse> getBooks()** method to the **BookService** interface within **network/services** package.
* Add a corresponding Retrofit annotation to the **Call<BookResponse> getBooks()** method.
* Implement the **MutableLiveData<List<Book>> getBooks()** method within the **BookRepository** class.
* Use the **BookService** to create a Retrofit network call

## License
* Copyright 2019 © Dominik Košćica.
