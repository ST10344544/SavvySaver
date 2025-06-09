SavvySaver

SavvySaver is a personal budgeting app that we, Ahmed Kader (ST10266284) and Cameron Cowdrey (ST10344544), developed as part of our final submission for the Programming 3C module. The core idea behind this app was to create a practical and engaging solution for tracking personal finances, while also applying all the concepts we’ve learned throughout the semester.

The motivation for creating SavvySaver came from the challenge of managing money effectively in real life. We wanted the app to not just record transactions but actually help users stay within their budgets by using real-time feedback and positive reinforcement. Throughout this project, we focused on simplicity, usability, and gamification to make the budgeting process as approachable and motivating as possible.

Purpose of the App

SavvySaver was built to help users take control of their daily spending habits. The app allows users to track their expenses, view summaries of where their money is going, and receive visual indicators that show whether they're staying within the budget goals they’ve set.

One of the main goals for us was to remove the friction often associated with budgeting apps. We designed SavvySaver to be lightweight, intuitive, and responsive, so users can jump in and log their expenses with minimal effort. Over time, by logging expenses and monitoring goals, users start to gain valuable insights into their own financial behavior.

We didn’t want to create just another tracker—we wanted to make budgeting something that people could stick to. That’s why we introduced extra motivational features like visual feedback for budget progress and custom badges for consistent usage.

Features

Core Features

All the core features required by the assignment brief were implemented. These include:

User Registration and Login: Users can register using a username and password, and securely log in to access their personalized budget data.

Expense Categories: Users can define categories like Food, Transport, Entertainment, etc., making it easier to organize and analyze their spending.

Add Expense Entries: Each entry includes the amount spent, date, description, and the selected category.

Attach Receipt Photos: Users can optionally attach an image (such as a photo of a receipt) to any expense entry for better record-keeping.

Set Monthly Budget Goals: Users can define both a minimum and maximum monthly budget, providing structure and boundaries to guide their spending.

Expense History: A detailed view allows users to see all logged expenses for any date range, along with the option to view receipt images for those entries.

Category Spending Totals: Users can view summaries that show how much they’ve spent in each category for any time period.

Local Data Storage: All data is stored securely on the device using RoomDB, ensuring fast and reliable access even when offline.

Graphical Breakdown: A graph shows category-based spending over a selected time period. Users can visually compare spending against their budget goals.

Progress Dashboard: A dashboard clearly displays current budget progress. Overspending categories are highlighted to help users take action quickly.

Additional Features We Developed

To go beyond the core requirements and add real value for the user, we developed two additional features that directly support better financial decision-making:

Income vs. Expense Calculator

We implemented a feature that allows users to input both their monthly income and total expenses. The app then calculates whether the user is on track to save money or if they’re likely to overspend. This simple calculator provides instant feedback and helps users plan their budgets more realistically. It's especially useful at the beginning of the month when trying to set achievable budget goals, or anytime someone wants to check if their spending is sustainable.

Savings Goals

Another feature we added is the ability for users to create personalized savings goals. Users can add a specific item they want to save for (like a new phone, a trip, or emergency savings) and assign a target amount to it. This feature acts like a mini wishlist tied directly into the budgeting system. As users track their expenses and monitor their remaining budget, they can also keep an eye on how close they are to reaching these savings goals. It’s a small addition, but it brings a lot of motivation and purpose to budgeting.

Design Considerations

We put a lot of thought into the overall structure and flow of the user interface. The design was guided by the principle that budgeting should be simple, not stressful. We made sure that everything from navigation to input forms followed a consistent layout and theme.

The home screen provides quick access to key features like adding a new expense or viewing the dashboard. The add expense screen is designed to be fast and easy to use, with clear fields and optional photo attachments. The dashboard and graph screens provide instant feedback about how users are doing relative to their set goals.

Navigation between screens is straightforward, and we used familiar UI patterns so users wouldn’t have to learn anything new to use the app. We used ConstraintLayout and Material Design components throughout to ensure the app is responsive on different screen sizes and remains visually coherent.

We also ensured that the app handles user errors gracefully. For example, all fields are validated and feedback is provided for incorrect or incomplete input. The app doesn’t crash when incorrect data is entered; instead, it guides users to fix the issue.

GitHub and GitHub Actions

Version control was done using GitHub throughout the development process. Our repository includes a full commit history that reflects the different stages of development, from initial setup to feature implementation and debugging.

We set up GitHub Actions to automate testing and builds for the project. This allowed us to verify that our code compiles and builds correctly in a clean environment, independent of our local machines. The workflow file is located at:

.github/workflows/build.yml

This automation not only improves our workflow but also ensures code reliability and quality, which was a requirement for this project.

Demo Video

To demonstrate our app in action, we recorded a full walkthrough on a physical Android device. The video includes a voiceover that explains the app’s features and how it meets the requirements of the assignment.

Watch the demo video here:
https://youtu.be/2kJ-Da_ioyo

The video shows how users can register, log in, add expenses, view their progress, and interact with all the core and extra features of the app. It also highlights our custom additions and how they contribute to a more engaging budgeting experience.

Technology Stack and Architecture

SavvySaver was built using the following technologies:

Kotlin – Primary programming language for Android development.

Android Jetpack Libraries – Including Room, ViewModel, LiveData, and Navigation.

RoomDB – For local, structured data storage.

MVVM (Model-View-ViewModel) – We followed the MVVM architectural pattern to separate concerns and make the codebase more manageable and scalable.

Material Design – To ensure a modern, consistent UI experience.

GitHub Actions – Used for automated build and test processes on each push.

The architecture and structure of the app helped us organize the code logically and maintain readability throughout development. Each major feature is handled in its own ViewModel and Fragment, making the app modular and easier to maintain.

Final Thoughts

Working on SavvySaver has been a great opportunity for us to put everything we’ve learned into practice. We started from scratch, went through the entire planning and design process, and developed a complete Android application that is both functional and user-focused.

By using tools like RoomDB, GitHub, and GitHub Actions, and by building in both required and additional features, we believe we’ve created something that aligns perfectly with the assignment expectations while also representing our own creativity and effort.

We’re proud of the result, and we hope it reflects the amount of planning, coding, testing, and refining that went into it.
