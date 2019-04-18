![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 5
Goal of this lab is to introduce Fragments.

## 1. BookDetailsActivity & BookRepository refactoring
Goal of this task is to refactor the **BookDetailsActivity** and the **BookRepository**.</br>
The max point value for this task is **1 point**.

### Lecture
* [Intents](https://drive.google.com/file/d/1PnqYaTrP2rdr8m3DngencTxkG9P3Epes/view)
* [Fragments](https://drive.google.com/file/d/1dbock4krogYRd9kmfzTyiWqQl4uZCVBw/view)

### Requirements
* Remove the **Serializable** interface from the **Book** model, **the Serializable interface was used only for demonstration purposes and should not be used in production code!** For more details read the following article: https://android.jlelse.eu/parcelable-vs-serializable-6a2556d51538
* Expend the Book model regarding the following UML diagram: https://drive.google.com/file/d/1_Bh0xYxwjIBzYgB9c5GszN5E_B0FksGB/view?usp=sharing
* Implement the **findBookById(long id)** method in the **BookRepository**. The method should return a Book object if the books list contains a book with the passed id, if not return **null**.
* Refactor the **openBookDetails(Book book)** method. The book **id** should be used instead of the book object.
* Refactor and adjust the **BookDetailsActivity** bundle retrieval logic. The book **id** should be used instead of the book object.
* On the **BookDetailsActivity** use the **findBookById(long id)** method from the **BookRepository** to retrive the book object.


## 2. HomeActivity and BookRVFragment
Goal of this task is to implement the BookRVFragment.</br>
The max point value for this task is **2 points**.

### Lecture
* [Fragments](https://drive.google.com/file/d/1dbock4krogYRd9kmfzTyiWqQl4uZCVBw/view)

### Documentation
* https://developer.android.com/guide/components/fragments

### Requirements
* Create a **fragment_rv_book.xml** layout and put it in the **res/layout** folder
* Create a new Java class with the name **BookRVFragment** within the **screen/home** package.
* Implement the **BookRVFragment**
    * Override the **onCreate** method to create an instance of the **BookRepository**
    * Override the **onCreateView** method to inflate the **fragment_rv_book.xml**
    * Override the **onViewCreated** method to setup the **RecyclerView**
* Use the **attachFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to attach the **BookRVFragment** to the **HomeActivity**
* Given that the user clicks on the RecylcerView item the user should be redirected to the **BookDetailsActivity**. Use the **openBookDetails(long id)** method to redirect the user to the **BookDetailsActivity**

## 3. BookDetailsActivity and BookDetailsFragment
Goal of this task is to implement the BookDetailsFragment and tryout fragment replacing.</br>
The max point value for this task is **2 points**.

### Lecture
* [Fragments](https://drive.google.com/file/d/1dbock4krogYRd9kmfzTyiWqQl4uZCVBw/view)

### Documentation
* https://developer.android.com/guide/components/fragments

### Requirements
* Create a **fragment_book_details.xml** layout and put it in the **res/layout** folder
* Create a new Java class with the name **BookDetailsFragment** within the **screen/bookdetails** package.
* Implement the **BookDetailsFragment**
    * Add the following code snippet to the **BookDetailsFragment** and use the **newInstance(long bookId)** method to create a new instance of the **BookDetailsFragment**
      ```java
      public static BookDetailsFragment newInstance(long bookId) {
         BookDetailsFragment fragment = new BookDetailsFragment();
         Bundle bundle = new Bundle();
         bundle.putLong(BOOK_ID, bookId);
         fragment.setArguments(bundle);
         return fragment;
      }
      ```
    * Override the **onCreate** method to create an instance of the **BookRepository** and retrive the **bookId** from the Fragment arguments
    * Override the **onCreateView** method to inflate the **fragment_book_details.xml**
    * Override the **onViewCreated** method to setup the **CardView**
* Use the **attachFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to attach the **BookDetailsFragment** to the **BookDetailsActivity**
* Given that the user clicks on the book item use the **replaceFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to replace the **BookDetailsFragment** with the **BookRVFragment**

## License
* Copyright 2019 © Dominik Košćica.
