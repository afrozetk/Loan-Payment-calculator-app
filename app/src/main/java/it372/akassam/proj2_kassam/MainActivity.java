package it372.akassam.proj2_kassam;
// Afroze Kassam
// Proj2_kassam - Monthly Loan Payment Calculator
// April 26th 2025

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * MainActivity class for the Loan Payment Calculator application
 * Handles user input and calculates monthly loan payments
 */
public class MainActivity extends AppCompatActivity {
    // UI component variables
    EditText principalEdit, interestEdit;
    RadioGroup termGroup;
    Button calculateButton;
    TextView resultText;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linearLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        principalEdit = findViewById(R.id.principal_edit);
        interestEdit = findViewById(R.id.interest_edit);
        termGroup = findViewById(R.id.termGroup);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        // Set button click listener using lambda expression (Method 4)
        calculateButton.setOnClickListener(v -> {
            // Get user input from text fields
            String principleText = principalEdit.getText().toString();
            String interestText = interestEdit.getText().toString();

            // Validate that input fields are not empty
            if (principleText.isEmpty() || interestText.isEmpty()) {
                resultText.setText("Please enter valid values for both fields.");
                return;
            }

            //parse inputs
            double principle = Double.parseDouble(principleText);
            double interest = Double.parseDouble(interestText);

            // Initialize loan term
            int term = 0;
            int selectedTerm = termGroup.getCheckedRadioButtonId();

            // Determine loan term based on selected radio button
            if (selectedTerm == R.id.tenYears) {
                term = 10;
            } else if (selectedTerm == R.id.fifteenYears) {
                term = 15;
            } else if (selectedTerm == R.id.thirtyYears) {
                term = 30;
            } else {
                resultText.setText("Please select a loan term.");
                return;
            }

            // Calculate monthly interest rate
            double monthlyInterest = interest / 1200.0;

            // Calculate total number of payments (years * 12 months)
            int months = term * 12;

            // Apply monthly payment formula:
            // m = (p * r/1200) / (1 - (1 + r/1200)^(-12n))
            // where p = principal, r = interest rate percentage, n = term in years
            double monthlyPayment = (principle * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -months));


            String formattedPayment = String.format("%.2f", monthlyPayment);
            resultText.setText("Monthly Payment: $" + formattedPayment);
        });
    }
}