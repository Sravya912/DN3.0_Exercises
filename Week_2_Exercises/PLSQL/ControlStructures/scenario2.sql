--add isVIP column to the table
ALTER TABLE Customers ADD (IsVIP VARCHAR2(3));

--setting VIP Flag
DECLARE
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            -- Set the IsVIP flag to TRUE for customers with a balance over $10,000
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ' promoted to VIP.');
        END IF;
    END LOOP;
END;
/

