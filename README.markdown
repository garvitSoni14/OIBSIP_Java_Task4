# Online Exam System

## Project Overview
This project, **Task-4 for OIB-SIP Java Internship**, is a Java-based desktop application that implements an online examination system using Swing for the GUI. The application includes a login interface and a timed multiple-choice quiz with features to save questions for review and display the final score.

## Features
- **Login Interface**: Users must enter a username and a valid password to access the quiz.
- **Timed Quiz**: The quiz consists of 10 multiple-choice questions with a 10-minute timer displayed in MM:SS format.
- **Question Navigation**: Users can save answers and proceed to the next question or mark questions for later review.
- **Review Functionality**: Users can revisit marked questions to review or change their answers.
- **Score Calculation**: The application calculates and displays the user's score at the end of the quiz or when the timer expires.
- **Error Handling**: Basic validation ensures a password is entered before starting the quiz, with appropriate error messages.

## Technologies Used
- **Java**: Core programming language.
- **Swing**: For creating the graphical user interface.
- **AWT**: For event handling and layout management.
- **Timer**: To implement the countdown timer for the quiz.

## Installation
1. **Prerequisites**:
   - Java Development Kit (JDK) 8 or higher installed.
   - A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with command-line compilation tools.

2. **Steps**:
   - Clone or download this repository to your local machine.
   - Navigate to the project directory containing the source code (`OnlineExam.java`).
   - Compile the code using:
     ```bash
     javac OnlineExam.java
     ```
   - Run the application using:
     ```bash
     java OnlineExam
     ```

## Usage
1. **Login**:
   - Launch the application.
   - Enter a username and a password in the login form.
   - Click **SUBMIT** to proceed to the quiz. If the password is empty, an error message will appear.

2. **Taking the Quiz**:
   - The quiz window displays one question at a time with four multiple-choice options.
   - Select an option and click **Save and Next** to submit the answer and move to the next question.
   - Click **Save for later** to mark the question for review, creating a review button for later access.
   - The timer in the top-right corner shows the remaining time (10 minutes total).
   - After answering all questions or when the timer expires, the final score is displayed.

3. **Reviewing Questions**:
   - Click any **Review** button to revisit a saved question, submit an answer, and return to the current question.

4. **Results**:
   - On completing the quiz or when the timer runs out, a dialog box shows the total score.
   - The application exits after displaying the score.

## File Structure
- `OnlineExam.java`: Main file containing all classes (`Login`, `OnlineTestBegin`, `OnlineExam`).
- `README.md`: This file, providing project documentation.

## Limitations
- The password validation only checks for non-empty input; no specific credentials are required.
- Questions and answers are hardcoded in the `set()` and `check()` methods.
- The application does not persist user data or scores.
- The UI uses a null layout, which may not be responsive across different screen sizes.

## Future Improvements
- Add a database to store questions, answers, and user scores.
- Implement a more robust authentication system.
- Improve the UI with a responsive layout (e.g., using GridBagLayout or other layout managers).
- Add support for randomized question order and multiple quiz categories.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes. Ensure your code follows the existing style and includes appropriate comments.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Developed as part of the **OIB-SIP Java Internship** (Task-4).
- Thanks to the Java Swing and AWT libraries for enabling the GUI functionality.