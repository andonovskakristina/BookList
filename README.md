# BookList

## About

Kristina Andonovska, 161033 <br/>
Web Programming - Faculty of Computer Science and Engeneering, Skopje

## Description of the application

The application is used to display my home library. Authors are shown, as well as their books. 
You can add a new author with its features. You can also create a new book by an existing author in the database. 
Authors and books can be looked at in detail, they can be deleted or edited. 
A book can be added as read, and if a book has already been read - it can be added to the list of favorite books. 
To the left of the list of all books, as well as the list of read and favorite books, there are filters that can 
filter by the title of the book, genre, range of page number and author. 
At the top there is an option to sort the list by rating, page number and release date. 
You have the abillity to search the list of authors by author name. 
Also, in the lower part of the home page, a diagram shows the number of books entered in the home library by genre.

## Starting the application

### Back-end

You only need to run **BooklistApplication**, which is located in package mk.ukim.finki.wp.booklist.

### Front-end

You need to navigate to the folder **BookList\booklist\frontend\booklist-frontend** in the terminal and then run:

```javascript
npm install
npm start
```

Then you should open http://localhost:3000 to view it in the browser.
