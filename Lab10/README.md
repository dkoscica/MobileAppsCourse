![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 10
Goal of this lab is to introduce Persistance in Android.

## Prerequisites
* Use the **git pull origin master** command to pull the latest changes
* Start using the Android Studio built in formatter. Each file that is modified or created **must** be formatted with the built in formatter: https://medium.com/mindorks/11-android-studio-shortcuts-every-android-developer-must-know-a153e736e611

## 1. Token persistance with SharedPreferences
Goal of this task is to implement token persistance with SharedPreferences.</br>
The max point value for this task is **1 point**.

### Lecture
- [Persistence](https://drive.google.com/file/d/139XoJL-oRZTX-hB8CRiYKLltAESPWZNa/view)

### Documentation
* https://developer.android.com/training/data-storage/shared-preferences

### Requirements
* Refactor the **SessionManager** class. The **getToken** and **setToken** methods should use **SharedPreferences** to store and retrive the token String.
* Since **SharedPreferences** require an Android Context use the **getContext()** method from **App** class to retrive the Android Context.

## 2. Basic API error handling
Goal of this task is to implement basic Network error handling.</br>
The max point value for this task is **1 point**.

### Lecture
- [Networking](https://drive.google.com/file/d/1_mtTizhjt_JiSAxTxveosZFT-eKBTxLc/view)

### Documentation
* https://www.baeldung.com/retrofit

### Requirements
* The AuthInteractor interface should look like this
    ```java
    public interface AuthInteractor {
        LiveData<User> validateToken();
        LiveData<String> login(String email, String password);
        LiveData<String> getError();
    }
    ```
* Implement the **getError()** method in the **AuthInteractorImpl** and **AuthInteractorMockImpl** classes
* Given that the **response.body()** is null use the **errorLiveData** to postValue the **response.message()**
* Given that the Retrofit **onFailure** method is called use the **errorLiveData** to postValue the **throwable.getLocalizedMessage()**
* Implement the **LiveData\<String> error()** method within the **LoginViewModel**
* Observe changes on the **LiveData\<String> error()** method within the **onStart** method of the Activity
* Given that the error is not null use the **showSnackbar** method to display the error. The **loadingProgressBar** should also be invisible if some error occurred

## 3. Android Styles
Goal of this task is to use styles.xml to cleanup layout xml files.</br>
The max point value for this task is **1 point**.

### Documentation
https://developer.android.com/guide/topics/ui/look-and-feel/themes

### Requirements
* Open **activity_splash.xml**
    * **AppTheme.LogoImageView**
        * Take a look at the **ImageView** which is used to display the logo
        * Extract the following xml properties to a **AppTheme.LogoImageView** style within the **styles.xml**
            ```xml
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:scaleType="centerInside"
                android:src="@drawable/logo"
            ```
        * Use the  **AppTheme.LogoImageView** style for all ImageViews which are used to display the app logo within the app
    * **AppTheme.Progress**
        * Take a look at the **androidx.core.widget.ContentLoadingProgressBar** which is used to display the loading progress bar
        * Extract the following xml properties to a **AppTheme.Progressbar** style within the **styles.xml**
            ```xml
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
            ```
        * The **AppTheme.Progress** style must use the folowing parent **@style/Widget.AppCompat.ProgressBar**
        * Use the  **AppTheme.Progressbar** style for all **androidx.core.widget.ContentLoadingProgressBar** within the app
* Open **activity_login.xml**
    * **AppTheme.TextInputLayout**
        * Create a new **AppTheme.TextInputLayout** style within the **styles.xml**
        * Take a look at all the **com.google.android.material.textfield.TextInputLayout** within the **activity_login.xml**
        * Extract as much as possible to the **AppTheme.TextInputLayout** style within the **styles.xml**
        * Use the  **AppTheme.TextInputLayout** style for all **com.google.android.material.textfield.TextInputLayout** within the app
    * **AppTheme.EditText**
        * Create a new **AppTheme.EditText** style within the **styles.xml**
        * Take a look at the **EditText** fields within the **activity_login.xml**
        * Extract as much as possible to the **AppTheme.EditText** style within the **styles.xml**
        * Use the  **AppTheme.EditText** style for all EditText fields within the app
     * **AppTheme.PrimaryButton**
        * Create a new **AppTheme.PrimaryButton** style within the **styles.xml**
        * Take a look at the **Button** within the **activity_login.xml**
        * Extract as much as possible to the **AppTheme.PrimaryButton** style within the **styles.xml**
        * Use the  **AppTheme.PrimaryButton** style for all primary buttons within the app

## 4. Book database
Goal of this task is to implement the book database with the help of the Room library</br>
The max point value for this task is **2 points**.

### Lecture
- [Persistence](https://drive.google.com/file/d/139XoJL-oRZTX-hB8CRiYKLltAESPWZNa/view)

### Documentation
- https://developer.android.com/training/data-storage/room
- https://developer.android.com/training/data-storage/room/referencing-data.html#understand-no-object-references

### Requirements
* Create a new **AppDatabase** abstract class within the **database** package.
* The **AppDatabase** class must have an **public static AppDatabase getDatabase()** method which should return a **Room** database instance.
* The **AppDatabase** class must use the **@TypeConverters({PublisherConverter.class})** annotation. Take a look at the following article https://developer.android.com/training/data-storage/room/referencing-data.html#understand-no-object-references
* Create a new **BookDao** interface within the **database** package. Add all required Room annotations
    ```java
        public interface BookDao {
            List<Book> getAll();
            Book findById(long id);
            void insert(Book book);
        }
    ```
* Update the **Book** and **Publisher** class to meet all Room requirements
* All database operations must be run on a background Thread. Use an AsyncTask or Thread to handle background processing
* Implement the **void addBook(Book book)** within the **BookRepository**. The method should use the Room database to save the book model
* Refactor the **getBooks** methods within the **BookRepository**. Given that the book from the API response is found in the database set the **setInCollection** to true, otherwise set it to false
* Update the **BookRecyclerViewAdapter**, the basketImageView should only be displayed if the book is stored in the database
* Update the **BookDetailsFragment**, the basketImageView should only be displayed if the book is stored in the database


## License
* Copyright 2019 © Dominik Košćica.
