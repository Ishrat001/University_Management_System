# University Management System

.................................

### Description

The University Management System is a Java-based application developed using Eclipse IDE. It employs Swing and AWT libraries for the GUI. This system enables university administration to efficiently manage student and faculty details, apply and view leave requests, manage semester fees, and handle examination and result-related tasks.


### Key Features

- **Add New (Student or Faculty)**: Add new student or faculty members to the system.

- **View Details (Student or Faculty)**: View detailed information about students or faculty members and allow searching and printing.

- **Apply Leave (Student or Faculty)**: Allow admin to apply leave for students or faculty members.

- **View Leave Details (Student or Faculty)**: View how many student and faculty is now in leave and allow to cancel leave and print the leave shit.

- **Examination**: Manage examination schedules, allow admin to add new examination schedules and to add any student result and view any student results by searching.

- **Update(Student or Faculty)**: Can update any information about faculty or student.

- **Fee Details**: Manage and record semester fee payments and allow admin to update any semester fee and give semester fee of a student by semester fee form.


### Installation

Follow this to set up the project:
** before install , you need eclipse IDE, Java JDk, MySQL, MySQL connector library, some additional library (you will get in the src folder)

** Create a database using MySQL Command Line Client  "universitymanagementsystem" which contains following tables(column)

	*examdetails(course, department, examname, startdate, 			enddate)

	*fee(course, semester2, semester3, semester4, semester5, 		semester6, semester7, semester8)

	*login(username, password)

	*marks(rollno, semester, marks1, marks2, marks3, marks4, 		marks5)

	*student(name, fname, rollno, dob, address, phone, email, 		class_x, classxii, nid, course, department)

	*studentfee(rollno, course, department, semester, total)

	*studentleave(rollno, date, duration)

	*subject(rollno, semester, subject1, subject2, subject3, 		subject4, subject5)

	*teacher(name, fname, empId, dob, address, phone, email, 		class_x, classxii, nid, education, department)

	*teacherleave(empId, date, duration)
 
 ** Clone the Repository**:
   ```bash
   git clone https://github.com/Ishrat001/University_Management_System.git


## Usage

1. **Add New (Student or Faculty)**:
   - Navigate to the "Add New" section.
   - Choose "Student" or "Faculty".
   - Fill in the required details and submit.

2. **View Details (Student or Faculty)**:
   - Navigate to the "View Details" section.
   - Choose "Student" or "Faculty".
   - Search for the desired record and view detailed information.
   - You can also print the details.

3. **Apply Leave (Student or Faculty)**:
   - Navigate to the "Apply Leave" section.
   - Select the type (Student or Faculty) and fill in the leave
application form.
   - Then submit.

4. **View Leave Details (Student or Faculty)**:
   - Navigate to the "View Leave Details" section.
   - Choose "Student" or "Faculty".
   - View the current leave status and details.
   - You can also cancel leave and print the leave sheet.

5. **Examination**:
   - Navigate to the "Examination" section.
   - Add new examination schedules.
   - Add or view student results by searching.

6. **Update (Student or Faculty)**:
   - Navigate to the "Update" section.
   - Choose "Student" or "Faculty".
   - Update the required information.

7. **Fee Details**:
   - Navigate to the "Fee Details" section.
   - Manage and record semester fee payments.
   - Update any semester fee and fill out the semester fee form for a student.

8. **Utility**:
    - Navigate to the "Utility" section.
    - You will be able to use Notepad and calculator

9. **Exit**:
    - Navigate to the "Exit" section.
    - able to gate out from project.



### Technologies Used

- **Java**: The core programming language used to develop the application.
- **Swing and AWT**: For creating the graphical user interface (GUI).
- **JDateChooser**: A date picker component used in the application.
- **MySQL**: The database used to store and manage data.
- **Eclipse IDE**: The integrated development environment used for development.


### Contributors

- **Ishrat Jahan Mim**: Developer and Maintainer.
- **Tasmia Sultana Sumi **: Contribution(Add new, View Details, Utility) .


### Contact

For any questions or support, please contact me(Ishrat Jahan Mim) at [ishratjahan7711@gmail.com]

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


## Contributing to University Management System

Thank you for considering contributing to our project! Here are some guidelines to help you get started:

** Reporting Issues **
- Ensure the issue wasn't already reported by searching through existing issues.
- Clearly describe the problem, including steps to reproduce it and any relevant screenshots.

** Submitting Pull Requests **
- Fork the repository and create your branch from `main`.
- Ensure your code follows our coding standards and is well-documented.
- Include relevant test cases and ensure all tests pass.
- Submit your pull request with a clear description of your changes.

** Coding Standards **
- Use consistent indentation (4 spaces).
- Comment your code where necessary to explain complex logic.
- Follow the project’s existing coding style.


