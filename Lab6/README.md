![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 5
Goal of this lab is to introduce Fragment.

## 1. BookDetailsActivity & BookRepository refactoring
Goal of this task is to refactor the **BookDetailsActivity** and the **BookRepository**.</br>
The max point value for this task is **1 point**.

### Lecture
* [Intents](https://drive.google.com/file/d/1PnqYaTrP2rdr8m3DngencTxkG9P3Epes/view)

### Documentation
* https://www.vogella.com/tutorials/JavaSerialization/article.html

### Requirements
* Remove the **Serializable** interface from the **Book** model, **the Serializable interface was used only for demonstration purposes and should not be used in production code!** For more details read the following article: https://android.jlelse.eu/parcelable-vs-serializable-6a2556d51538
* Expend the Book model regarding the following UML diagram: https://drive.google.com/file/d/1_Bh0xYxwjIBzYgB9c5GszN5E_B0FksGB/view?usp=sharing
* Implement the **findBookById(long id)** method in the **BookRepository**. The method should return a Book object if the books list contains a book with the passed id, if not return **null**.
* The intent which is used to start the **BookDetailsActivity** should contain an instance of the **Book** object.
* Refactor the **openBookDetails(Book book)** method. The book **id** should be used instead of the book object.
* Refactor and adjust the **BookDetailsActivity** bundle retrival logic. The book **id** should be used instead of the book object.
* On the **BookDetailsActivity** use the **findBookById(long id)** from the **BookRepository** to retrive the book object.


## 2. HomeActivity and BookRVFragment
Goal of this task is to implement the BookRVFragment.</br>
The max point value for this task is **2 points**.

<img src="HomeScreenDesign.png" width="540" height="960">

### Lecture
* [Fragments](https://drive.google.com/file/d/1PnqYaTrP2rdr8m3DngencTxkG9P3Epes/view)

### Documentation
* https://developer.android.com/guide/components/fragments

### Requirements
* Create a new Java class with the name **BookRVFragment** within the **screen/home** package.
* Implement the **BookRVFragment**.
* Use the **attachFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to attach the **BookRVFragment** to the **HomeActivity**
* Given that the user clicks on the RecylcerView item the user should be redirected to the **BookDetailsActivity**. Use the **openBookDetails(long id)** method to redirect the user to the **BookDetailsActivity**

## 3. BookDetailsActivity and BookDetailsFragment
Goal of this task is to implement the BookDetailsFragment and tryout fragment replacing.</br>
The max point value for this task is **2 points**.

### Lecture
* [Fragments](https://drive.google.com/file/d/1PnqYaTrP2rdr8m3DngencTxkG9P3Epes/view)

### Documentation
* https://developer.android.com/guide/components/fragments

### Requirements
* Create a new Java class with the name **BookDetailsFragment** within the **screen/bookdetails** package.
* Implement the **BookDetailsFragment**.
* Use the **attachFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to attach the **BookDetailsFragment** to the **BookDetailsActivity**
* Given that the user clicks on the book item use the **replaceFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment)** method from the **FragmentUtil** class to replace the **BookDetailsFragment** with the **BookRVFragment**

## License
* Copyright 2019 © Dominik Košćica.