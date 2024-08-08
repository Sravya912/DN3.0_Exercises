DECLARE
    v_due_date DATE;
BEGIN
    FOR rec IN (SELECT c.Name, l.EndDate, l.LoanID
                FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        v_due_date := rec.EndDate;
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || ', your loan (LoanID: ' || rec.LoanID || ') is due on ' || TO_CHAR(v_due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
