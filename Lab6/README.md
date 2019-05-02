![](https://www.medicalcenter.virginia.edu/mobile-device-setup/colorsAndroidlogo.jpg/?s=50)

# Lab 6
Goal of this lab is to introduce Gradle and Permissions.

## 1. Glide library
Goal of this task is to implement the Glide library.</br>
The max point value for this task is **2 point**.

### Lecture
* [Gradle](https://drive.google.com/file/d/1hPivQ6oml_M3N15WaX21iMzht67FIzzZ/view)
* [Permissions](https://drive.google.com/file/d/17-nT-uGNBkXlTOpmwbIC-metlTNfFSnE/view)

### Documentation
* https://developer.android.com/guide/topics/permissions/overview

### Requirements
* Extend the Book model regarding the following UML diagram: https://drive.google.com/file/d/1_Bh0xYxwjIBzYgB9c5GszN5E_B0FksGB/view?usp=sharing
* Update the **BookRepository** constructor accordingly, feel free to use any image urls.
* Add the **internet** permission to the **AndroidManifest.xml**
* Add the Glide library to the project https://github.com/bumptech/glide
* Extend the **BookRecyclerViewAdapter** and load the book model **imageUrl** into the imageView with the help of the Glide library.

## 2. Write permission
Goal of this task is to request a runtime write permission (WRITE_EXTERNAL_STORAGE).</br>
The max point value for this task is **2 points**.

### Lecture
* [Permissions](https://drive.google.com/file/d/17-nT-uGNBkXlTOpmwbIC-metlTNfFSnE/view)

### Requirements
* Request a runtime write permission **WRITE_EXTERNAL_STORAGE** within the **onCreate()** method of HomeActivity
* Given that the user has already granted the write permission show a **Snackbar** message
* Given that the user has denied or the permission is not known, explicitly ask the user for the **WRITE_EXTERNAL_STORAGE** permission.

## 3. Gradle config implementation
Goal of this task is to implement Gradle constants within the root **build.gradle** file</br>
The max point value for this task is **1 points**.

### Lecture
* [Gradle](https://drive.google.com/file/d/1hPivQ6oml_M3N15WaX21iMzht67FIzzZ/view)

### Requirements
* Open the project **build.gradle** file
* Take a look at the **defaultConfig {}** and **dependencies {}** blocks
* It is a good practice to have configuration parameters and dependency versions stored in one place, therefore open the root  **build.gradle** file and take a look at the **ext{}** block. This block should be used to store all the configuration and dependency versions in one place.
* Complete the **ext{}** with the following configurations and dependency versions
    * applicationId
    * targetSdkVersion
    * constraintLayoutVersion
    * materialVersion
    * cardViewVersion
    * recyclerview
    * junitVersion
    * runnerVersion
    * espressoCoreVersion
* Use the configuration and dependency versions defined in the **ext{}** block in the project **build.gradle** file

## License
* Copyright 2019 © Dominik Košćica.
