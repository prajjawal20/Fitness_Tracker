

function suggestExercise() {
    
    const age = parseInt(document.getElementById('age').value);
    const fitnessLevel = document.getElementById('fitness-level').value;
    const fitnessGoal = document.getElementById('fitness-goal').value;
  
    // Check if the age is valid
    if (isNaN(age) || age <= 0) {
      alert('Please enter a valid age.');
      return;
    }
  
    let suggestion = '';
  
    // Suggest exercises based on fitness goal and level
    if (fitnessGoal === 'weight-loss') {
      if (fitnessLevel === 'beginner') {
        suggestion = 'Start with cardio exercises like brisk walking, light jogging, and cycling.';
      } else if (fitnessLevel === 'intermediate') {
        suggestion = 'Try high-intensity interval training (HIIT), swimming, or moderate running.';
      } else if (fitnessLevel === 'advanced') {
        suggestion = 'Focus on HIIT, sprints, and long-distance running to burn more fat.';
      }
    } else if (fitnessGoal === 'muscle-gain') {
      if (fitnessLevel === 'beginner') {
        suggestion = 'Start with bodyweight exercises like squats, push-ups, and lunges.';
      } else if (fitnessLevel === 'intermediate') {
        suggestion = 'Include weight lifting exercises like deadlifts, bench press, and overhead press.';
      } else if (fitnessLevel === 'advanced') {
        suggestion = 'Focus on compound lifts with heavy weights and incorporate progressive overload.';
      }
    } else if (fitnessGoal === 'endurance') {
      if (fitnessLevel === 'beginner') {
        suggestion = 'Try endurance-focused activities like walking, jogging, and cycling.';
      } else if (fitnessLevel === 'intermediate') {
        suggestion = 'Incorporate longer runs, swimming, or cycling sessions with varied intensity.';
      } else if (fitnessLevel === 'advanced') {
        suggestion = 'Try marathon training, long-distance cycling, or intense swimming sets.';
      }
    }
  
    // Display the suggestion
    document.getElementById('suggestion-text').textContent = suggestion;
  }
  