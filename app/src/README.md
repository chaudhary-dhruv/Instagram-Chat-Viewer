
# InstaChat Viewer

InstaChat Viewer is an Android application that mimics a basic Instagram-style chat interface. It allows users to view a list of dummy users, search through them by name, and view a chat screen showing dummy messages for each user using json file(download chat from instagram).

## 🚀 Features

- 🧑 User List Screen
  - Displays a list of users.
  - Search functionality to filter users by name.

- 💬 Chat Screen
  - Shows dummy chat messages between the logged-in user and selected user.
  - Displays message bubbles with timestamps.
  - Send button (UI only) to append messages.
  - Includes a date picker and back navigation.

## 📱 Screens

- `UserListActivity.kt`: Shows list of users with search capability.
- `ChatActivity.kt`: Displays dummy conversation with the selected user.
- `MessageAdapter.kt`: Handles message layout rendering.
- `UserListAdapter.kt`: Handles user list and search filtering.



## 🔧 How to Run

1. Clone the repository or download the code.
2. Open in Android Studio.
3. Sync Gradle and build the project.
4. Run the app on an emulator or physical device with at least API Level 24.

## 🧪 Testing Features

- Tap on a user to open their chat screen.
- Use the SearchView to filter user names.
- Press back to return to the user list.
- Messages are dummy data – functionality is for UI demonstration.

## 📦 Dependencies

- androidx.appcompat
- androidx.recyclerview
- androidx.constraintlayout
- androidx.core:core-ktx (version must match your compileSdk, e.g., 34)

## 🛠 Notes

- Ensure your compileSdkVersion = 34 (not 35) if you're using AGP 8.2.0-rc01 or below.
- All data is static/dummy for UI simulation only.
- ViewBinding is used for layout access.

## ✨ Future Scope (Optional Ideas)

- Firebase integration for real chat data.
- User authentication and storage.
- Image messages and multimedia support.

---

Made with ❤️ by Dhruv Chaudhary.

