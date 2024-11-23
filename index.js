// script.js

let totalSteps = 0;
let totalCalories = 0;
let totalWorkoutTime = 0;

// Calories calculation constants
const CALORIES_PER_STEP = 0.04; // calories per step for a person weighing 155 lbs (70kg)
const CALORIES_PER_MINUTE_WORKOUT = 8; // average calories burned per minute during a moderate workout

function trackSteps() {
  const steps = parseInt(document.getElementById('step-input').value);
  if (!isNaN(steps) && steps >= 0) {
    totalSteps += steps;
    totalCalories += steps * CALORIES_PER_STEP; // Automatically calculate calories burned from steps
    document.getElementById('step-count').textContent = totalSteps;
    document.getElementById('total-steps').textContent = totalSteps;
    document.getElementById('total-calories').textContent = totalCalories.toFixed(2);
    document.getElementById('step-input').value = ''; // Reset input
  } else {
    alert('Please enter a valid number of steps.');
  }
}

function trackWorkout() {
  const workoutTime = parseInt(document.getElementById('workout-input').value);
  if (!isNaN(workoutTime) && workoutTime >= 0) {
    totalWorkoutTime += workoutTime;
    totalCalories += workoutTime * CALORIES_PER_MINUTE_WORKOUT; // Automatically calculate calories burned from workout time
    document.getElementById('workout-time').textContent = totalWorkoutTime + ' min';
    document.getElementById('total-workout').textContent = totalWorkoutTime + ' min';
    document.getElementById('total-calories').textContent = totalCalories.toFixed(2);
    document.getElementById('workout-input').value = ''; // Reset input
  } else {
    alert('Please enter a valid workout time.');
  }
}
