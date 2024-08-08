DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_annual_fee CONSTANT NUMBER := 50;
BEGIN
    OPEN cur_accounts;

    LOOP
        FETCH cur_accounts INTO v_account_id, v_annual_fee;
        EXIT WHEN cur_accounts%NOTFOUND;

        UPDATE Accounts SET Balance = Balance - v_annual_fee WHERE AccountID = v_account_id;
    END LOOP;

    CLOSE cur_accounts;

    COMMIT;
END;
/
