# FitnessTrackerApp
# Health and Fitness Tracker

The Health and Fitness Tracker is a simple Java Swing application designed to help users track their physical activity and calculate important health metrics such as calories burned, Body Mass Index (BMI), and health score. The app provides suggestions on daily calorie intake based on the user's BMI and visual feedback through color-coded health scores.

## Features

- Input fields for steps taken, distance covered, weight, and height.
- Calculation of estimated calories burned based on steps taken and distance covered.
- Calculation of BMI.
- Daily calorie intake suggestions based on BMI.
- Health score calculation with color-coded feedback.
- Error handling for invalid inputs.

## Technologies Used

- Java
- Java Swing

## Installation

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/your-username/FitnessTrackerApp.git
    ```

2. Navigate to the project directory:
    ```bash
    cd FitnessTrackerApp
    ```

3. Open the project in your preferred Java IDE (such as IntelliJ IDEA, Eclipse, or NetBeans).

4. Build and run the project.

## Usage

1. Launch the application.
2. Enter the number of steps taken in the "Steps taken" field.
3. Enter the distance covered in kilometers in the "Distance (km)" field.
4. Enter your weight in kilograms in the "Weight (kg)" field.
5. Enter your height in meters in the "Height (m)" field.
6. Click the "Track Activity" button.
7. The application will display the estimated calories burned, your BMI, a daily calorie intake suggestion, and your health score with color-coded feedback.

## Screenshots

(![Screenshot (515)](https://github.com/Abishree-senthilnathan/FitnessTrackerApp/assets/160491315/fec4de3e-8b5a-4996-80d7-22e2f6e70421)
![Screenshot (516)](https://github.com/Abishree-senthilnathan/FitnessTrackerApp/assets/160491315/6c1340c6-4303-4113-9a66-4eca3526193e)
![Screenshot (514)](https://github.com/Abishree-senthilnathan/FitnessTrackerApp/assets/160491315/10eee2b1-10b4-455a-89ad-cc9f8b77838f)


## Sample Inputs for Testing

### Underweight (BMI < 18.5)
- Steps taken: 8000
- Distance (km): 5.0
- Weight (kg): 50
- Height (m): 1.75

### Normal weight (18.5 ≤ BMI < 24.9)
- Steps taken: 10000
- Distance (km): 7.0
- Weight (kg): 70
- Height (m): 1.75

### Overweight (25 ≤ BMI < 29.9)
- Steps taken: 6000
- Distance (km): 4.0
- Weight (kg): 85
- Height (m): 1.75

### Obese (BMI ≥ 30)
- Steps taken: 3000
- Distance (km): 2.0
- Weight (kg): 100
- Height (m): 1.75

### Invalid input
- Steps taken: abc
- Distance (km): 5.0
- Weight (kg): 70
- Height (m): 1.75

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements, bug fixes, or new features.

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature/your-feature-name`.
5. Open a pull request.

## Acknowledgments

- Inspiration for the project comes from the need to track personal fitness and health metrics easily and effectively.

