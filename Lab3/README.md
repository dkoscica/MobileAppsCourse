![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 3
Goal of this lab is to introduce Snackbars, Activity Lifecycles, Intents and CardView.

## 1. Update LoginActivity
Goal of this task is to replace the Toast message with a Snackbar. Open a webpage with an Intent object and store the form values during rotation changes.</br>
The max point value for this task is **2 point**.

### Documentation
* https://developer.android.com/training/snackbar
* https://developer.android.com/guide/components/activities/activity-lifecycle

### Requirements
* Given that the user has entered invalid credentials a **Snackbar** should be shown instead of the **Toast** message. Credentials are considered invalid if the email & password format is invalid.
* Given that the user clicks on the vvg.hr open the VVG website with an **Intent**. The website link and **TextView** text must be accessed through **strings.xml** and the values must be stored in both localizations.
* Given that the user has rotated his device the email & password values should be stored in the Activity state with the help of **onSaveInstanceState/onRestoreInstanceState** methods. In case of a rotation change the EditText field should persist the entered value.

## 2. HomeActivity
Goal of this task is to create a new HomeActivity and open the HomeActivity on successful login.</br>
The max point value for this task is **1 point**.

### Requirements
* Add a new Activity with the name **HomeActivity** within the screen package.
* Check if the HomeActivity is listed in the **AndroidManifest.xml**, if it's not you have to add it manualy.
* Given that the user has clicked on the Login button and entered valid credentials the user should be redirected to the **HomeActivity**. Credentials are considered valid if the email & password format is valid.

## 3. BookRepository
Goal of this task is to add the Book model to the project and implement the BookRepository.</br>
The max point value for this task is **1 points**.

### Requirements
* Create a new package with the name **model** and create a new Java class with the name **Book** within the **model** package.</br> Getters & Setters must be used.
 For the implementation details refer to the UML diagram: https://drive.google.com/file/d/1_Bh0xYxwjIBzYgB9c5GszN5E_B0FksGB/view?usp=sharing
* Create a new package with the name **repository** and create a new Java class with the name **BookRepository** within the **repository** package.
* Add the following code snippet to the **BookRepository** class
    ```java
    public class BookRepository {

        private List<Book> books;

        public BookRepository() {
            books = new ArrayList<>();
            books.add(new Book("Head First Android Development", "Dawn Griffiths ", 2017, 45.0));
            books.add(new Book("Android Studio 3.0 Development Essentials - Android 8 Edition", "Neil Smyth", 2017, 50.0));
            books.add(new Book("Android Programming: The Big Nerd Ranch Guide (3rd Edition)", "Bill Phillips, Chris Stewart, and Kristin Marsicano", 2017, 55.0));
        }

        public List<Book> getBooks() {
            return books;
        }
    }
    ```

## 3. Implement HomeActivity design
Goal of this task is to add the Book model to the project and implement the HomeScreen design.</br>
The max point value for this task is **1 points**.

<img src="HomeScreenDesign.png">

### Documentation
* https://developer.android.com/guide/topics/ui/layout/cardview

### Requirements
* Implement the required design, **CardView** must be used!
* Use the first item of the BookRepository items list to setup the view
* Extract the **CardView** layout to a separate **rv_item_book.xml** layout and put it in the **res/layout** folder
* Include the **rv_item_book.xml** layout into the **activity_home.xml** layout

## License
* Copyright 2019 © Dominik Košćica.