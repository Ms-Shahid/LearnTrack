## Why ArrayList Instead of Array?

ArrayList was used because the number of Students, Courses, and Enrollments is dynamic.

Advantages:

* Dynamic resizing
* Easy insertion and deletion
* Built-in utility methods
* Cleaner code than manual array management

Using arrays would require manually tracking size and creating larger arrays when capacity is exceeded.

---

## Where Static Members Were Used

The IdGenerator utility uses static fields and methods.

Example:

* getNextStudentId()
* getNextCourseId()
* getNextEnrollmentId()

Static methods are appropriate because ID generation belongs to the class itself and does not require creating objects.

---

## Where Inheritance Was Used

The Person class acts as a base class.

Student extends Person

Trainer extends Person

Benefits:

* Code reuse
* Shared properties such as:

    * firstName
    * lastName
    * email

This avoids duplication across multiple classes.

---

## Where Polymorphism Was Used

The getDisplayName() method is defined in Person and overridden in Student.

This demonstrates runtime polymorphism and method overriding.

---

## Separation of Concerns

Entity Classes

* Represent application data.

Service Classes

* Contain business logic.

Utility Classes

* Reusable helper functionality.

Main Class

* Handles user interaction and menu navigation.

This separation makes the code easier to maintain and extend.
