# 💰 Loan Payment Calculator (Android)

This Android app calculates the monthly payment for a loan based on user inputs: principal, interest rate, and loan term.

---

## ✅ Features

- Inputs for principal and interest rate (numbers only)
- Loan term selection using a RadioButtons (10, 15, 30 years)
- Monthly payment calculated using a formula
- UI built with LinearLayout inside a ScrollView
---

## 🧮 Formula

m = [p * (r / 1200)] / [1 - (1 + r / 1200)^(-12 * n)]

Where:
- `m` = monthly payment  
- `p` = principal  
- `r` = interest rate (%)  
- `n` = loan term (years)

---

## 💻 How to Run

1. Open the project in Android Studio
2. Run it on an emulator or device
3. Enter values and press the **Calculate** button

---
