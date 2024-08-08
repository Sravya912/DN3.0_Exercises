DECLARE
    v_age NUMBER;
    v_interest_rate NUMBER;
BEGIN
    FOR rec IN (SELECT CustomerID, ROUND((SYSDATE - DOB)/365.25) AS age FROM Customers) LOOP
        IF rec.age > 60 THEN
            SELECT InterestRate INTO v_interest_rate 
            FROM Loans 
            WHERE CustomerID = rec.CustomerID;

            v_interest_rate := v_interest_rate - 1;

            UPDATE Loans
            SET InterestRate = v_interest_rate
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
END;
/
