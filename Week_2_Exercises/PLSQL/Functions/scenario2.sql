CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) 
RETURN NUMBER 
IS
    v_monthly_installment NUMBER;
    v_monthly_rate NUMBER := p_interest_rate / 1200;
    v_total_months NUMBER := p_duration_years * 12;
BEGIN
    v_monthly_installment := p_loan_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -v_total_months));
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
