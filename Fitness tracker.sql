CREATE DATABASE FitnessTracker;

USE FitnessTracker;

CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE FitnessGoals (
    GoalID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    StepsGoal INT DEFAULT 10000,
    CaloriesGoal DOUBLE DEFAULT 2000.0,
    WaterGoal DOUBLE DEFAULT 2.0,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

CREATE TABLE FitnessProgress (
    ProgressID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    StepsTaken INT DEFAULT 0,
    CaloriesBurned DOUBLE DEFAULT 0.0,
    WaterConsumed DOUBLE DEFAULT 0.0,
    ProgressDate DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

INSERT INTO Users (UserName, Email) VALUES 
('John Doe', 'john.doe@example.com'),
('Jane Smith', 'jane.smith@example.com');

INSERT INTO FitnessGoals (UserID, StepsGoal, CaloriesGoal, WaterGoal) VALUES 
(1, 12000, 2500.0, 3.0),
(2, 8000, 1800.0, 2.5);

INSERT INTO FitnessProgress (UserID, StepsTaken, CaloriesBurned, WaterConsumed, ProgressDate) VALUES 
(1, 5000, 1200.0, 1.5, '2024-11-22'),
(2, 3000, 800.0, 1.0, '2024-11-22'),
(1, 6000, 1300.0, 2.0, '2024-11-23'),
(2, 7000, 1500.0, 2.0, '2024-11-23');

SELECT * FROM Users;

SELECT 
    u.UserName, 
    g.StepsGoal, 
    g.CaloriesGoal, 
    g.WaterGoal 
FROM 
    FitnessGoals g
JOIN 
    Users u ON g.UserID = u.UserID;

SELECT 
    u.UserName, 
    p.ProgressDate, 
    p.StepsTaken, 
    p.CaloriesBurned, 
    p.WaterConsumed 
FROM 
    FitnessProgress p
JOIN 
    Users u ON p.UserID = u.UserID
WHERE 
    u.UserName = 'John Doe';

SELECT 
    u.UserName, 
    p.ProgressDate, 
    p.StepsTaken, 
    p.CaloriesBurned, 
    p.WaterConsumed 
FROM 
    FitnessProgress p
JOIN 
    Users u ON p.UserID = u.UserID
ORDER BY 
    p.ProgressDate DESC;

UPDATE FitnessGoals 
SET StepsGoal = 15000, CaloriesGoal = 2200.0, WaterGoal = 3.5 
WHERE UserID = 1;

INSERT INTO FitnessProgress (UserID, StepsTaken, CaloriesBurned, WaterConsumed, ProgressDate)
VALUES (1, 7000, 1600.0, 2.5, '2024-11-24');

DELETE FROM FitnessProgress WHERE UserID = 2 AND ProgressDate = '2024-11-22';

DELETE FROM Users WHERE UserName = 'Jane Smith';
