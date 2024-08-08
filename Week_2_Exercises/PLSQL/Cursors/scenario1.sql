DECLARE
    CURSOR cur_transactions IS
        SELECT c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);

    v_name Customers.Name%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN cur_transactions;

    LOOP
        FETCH cur_transactions INTO v_name, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN cur_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(v_name || ': ' || TO_CHAR(v_transaction_date, 'YYYY-MM-DD') || ', ' || v_transaction_type || ', ' || v_amount);
    END LOOP;

    CLOSE cur_transactions;
END;
/
