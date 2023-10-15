# BookingTable

The Booking Table App is designed to facilitate table reservations at a restaurant. Users can fill out an Angular form with the following fields:

- Booking ID (auto-generated)
- User Name
- User Mobile Number
- Email ID
- Table Preference
- Number of Persons
- Number of Children
- Restaurant Open Buffet Preference
- Arrival Date

Once a booking is made, the app allows users to view, edit, or delete their booking. After making a booking, users are routed to the listing page.

Key Features:

1. Table Booking: Users can fill out the Angular form to make a reservation for a table at the restaurant.

2. Edit and Delete Bookings: Users have the ability to edit or cancel their existing bookings.

3. Listing Page: The app provides a page where users can view their bookings and see all the relevant details.

4. Routing: After a successful booking, users are automatically directed to the listing page for a seamless user experience.

The Booking Table App simplifies the process of table reservations, making it convenient for users to book and manage their reservations.

# BookingTableAssumptions

The Booking Table App is developed with the aim of providing a user-friendly system for managing table reservations at a restaurant. The app allows users to make, edit, and delete their reservations without requiring user authentication or performing availability checks.

Assumptions:

1. Simplified Usage: The app assumes that user authentication is not necessary for the reservation process. Users can directly access the booking functionality without the need for registration or login.

2. Input Validation: The Angular form is expected to have built-in validation to ensure that users provide valid and complete information for each field. This helps maintain data integrity and prevents errors.

3. Database Integration: The app assumes the use of a MySQL database to store reservation data. The database schema includes fields such as booking ID, user details, table preferences, number of persons, etc.

4. Unrestricted Access: As user authentication is not implemented, users have access to view, edit, or delete any reservation. There are no restrictions on accessing or modifying bookings made by other users.

5. Basic Functionality: The app focuses on providing the essential features of making, editing, and deleting reservations. Advanced features like availability checks to prevent double bookings are not implemented.

6. Seamless Navigation: The app utilizes routing and navigation mechanisms in Angular to ensure a smooth transition between different pages. After completing a booking or making any changes, users are redirected to the appropriate sections.

The development of the Booking Table App emphasizes simplicity and ease of use, allowing users to manage their table reservations efficiently without the need for user authentication or availability checks.
