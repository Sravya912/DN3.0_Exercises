DECLARE
    CURSOR cur_loans IS
        SELECT LoanID FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_new_interest_rate CONSTANT NUMBER := 5;
BEGIN
    OPEN cur_loans;

    LOOP
        FETCH cur_loans INTO v_loan_id;
        EXIT WHEN cur_loans%NOTFOUND;

        UPDATE Loans SET InterestRate = v_new_interest_rate WHERE LoanID = v_loan_id;
    END LOOP;

    CLOSE cur_loans;

    COMMIT;
END;
/
