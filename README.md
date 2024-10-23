# FinanceApp

FinanceApp is an Android application designed to help users manage and track their financial transactions. It allows users to add new transactions, view their total balances, and visualize financial data through intuitive charts. The app features distinct sections such as Dashboard, Home, and Notifications, each built using Android's ViewModel and Fragment architecture to ensure smooth and efficient performance.

## Features

- **Add Transactions**: Seamlessly add transactions with names and prices.
- **View Transactions**: A dynamic list of transactions displayed using RecyclerView.
- **Balance Calculation**: Automatically calculates and updates the total balance and expenses.
- **Data Visualization**: Visualize your financial data with bar charts of your total balance and expenses.
- **Modern and Intuitive UI**: Built with Android's Material Design for a clean and user-friendly interface.

## Technologies Used

- **Backend**: No backend is required (local data storage within the app).
- **Frontend**: Android XML layouts and Kotlin for business logic.
- **Libraries**:
  - **ViewModel & LiveData**: For lifecycle-aware data management.
  - **RecyclerView**: To efficiently display lists of transactions.
  - **WilliamChart**: For creating interactive bar charts and visualizing financial data.

## File Structure

- **`MainActivity`**: The main screen where users can view their balance and add new transactions.
- **`Transaction`**: A data class that encapsulates the details of a transaction (name and price).
- **`TransactionAdapter`**: Adapter for managing and displaying transactions in the RecyclerView.
- **`ChartActivity`**: Activity responsible for displaying a bar chart that shows the total balance and expenses.
- **`Fragments`**: Manages the various sections of the app:
  - `HomeFragment`
  - `DashboardFragment`
  - `NotificationsFragment`

## Getting Started

### Prerequisites

- Android Studio
- Minimum SDK: 21 (Android 5.0 Lollipop)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ZacharyLelievre/FinanceApp.git
   cd financeapp
