# Movie Bluster 🎬

Movie Bluster is an Android movie browsing application developed as part of a university assignment. The app allows users to explore different movie categories, view movie details, and manage a personal wishlist after logging in.

The project demonstrates Android development concepts including RecyclerView usage, SQLite database integration, and user authentication.

---

## Project Description

The application provides a simple interface where users can browse movies across different categories such as Action, Comedy, Horror, Drama, Romance, and Sci-Fi.

Users can open movies to view details and add them to their personal wishlist. The application uses a local SQLite database to store user accounts and wishlist data. Each user can only view their own saved wishlist items.

---

## Features

- Browse movies by category  
- View movie posters and titles  
- User login and registration system  
- Add movies to a personal wishlist ⭐  
- Wishlist data stored using SQLite database  
- User-specific wishlist filtering  
- Clean Android UI design  
- RecyclerView based movie listing  

---

## Technologies Used

- Android Studio  
- Java  
- XML (Android UI layouts)  
- SQLite Database  
- RecyclerView  
- GitHub for version control  

---

## Database Structure

### Users Table

Stores user account information.

Fields:
- userId  
- username  
- email  
- password  

### Wishlist Table

Stores movies added by users.

Fields:
- wishlistId  
- userId (Foreign Key)  
- movieName  
- movieImage  

Each user can only access their own wishlist items.

---

## How to Run the Project

1. Clone the repository from GitHub  
2. Open the project in Android Studio  
3. Allow Gradle to sync dependencies  
4. Run the application on an emulator or Android device  

---

## Team Members

- Dilshan Liyanage  - ICT/2022/037  - 5643
- Kasuni Wedage     - ICT/2022/039  - 5645
- Praveen Mudalige  - ICT/2022/038  - 5644 

---

## Repository

The project is maintained using GitHub for version control and collaboration.
