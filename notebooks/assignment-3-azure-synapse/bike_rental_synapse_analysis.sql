-- Azure Synapse Analytics — Bike Rental Data Analysis
-- Course: MEM6287 Advanced Data Analytics | University of Ottawa | Fall 2024
-- Group 13: Maurice Williams, Scott Bailey, Nabeegh Khan
-- Dataset: Bay Area Bike Share — August 2015
--   201508_trip_data.csv  (~24MB trip records)
--   201508_station_data.csv (station metadata)
-- Executed in: Azure Synapse Analytics workspace (database: Assignment3Data)

-- ─────────────────────────────────────────────────────────────────────────────
-- QUERY 1: Top 20 zip codes for bike pickup
-- ─────────────────────────────────────────────────────────────────────────────
SELECT TOP 20
    [ZipCode],
    COUNT([TripID]) AS PickupCount
FROM
    [Assignment3Data].[dbo].[201508_trip_data]
GROUP BY
    [ZipCode]
ORDER BY
    COUNT([TripID]) DESC;

-- ─────────────────────────────────────────────────────────────────────────────
-- QUERY 2: Monthly rental duration in hours by subscriber type (descending)
-- ─────────────────────────────────────────────────────────────────────────────
SELECT
    SubscriberType,
    SUM([Duration] / 3600) AS [MonthlyRentalDurationinHours],
    FORMAT([StartDate], 'yyyy-MM') AS [YearMonth]
FROM [Assignment3Data].[dbo].[201508_trip_data]
GROUP BY
    SubscriberType,
    FORMAT([StartDate], 'yyyy-MM')
ORDER BY [MonthlyRentalDurationinHours] DESC;

-- ─────────────────────────────────────────────────────────────────────────────
-- QUERY 3: Top 5 terminals for bike pickup
-- JOIN to station_data to resolve terminal number to station name
-- ─────────────────────────────────────────────────────────────────────────────
SELECT TOP(5)
    StartTerminal,
    name,
    COUNT([TripID]) AS PickupCount
FROM [Assignment3Data].[dbo].[201508_trip_data]
JOIN [Assignment3Data].[dbo].[201508_station_data]
    ON StartTerminal = station_id
GROUP BY [StartTerminal], name
ORDER BY COUNT([TripID]) DESC;

-- ─────────────────────────────────────────────────────────────────────────────
-- QUERY 4: Top 5 terminals with the least drop-offs
-- JOIN to station_data to resolve terminal number to station name
-- ─────────────────────────────────────────────────────────────────────────────
SELECT TOP(5)
    EndTerminal,
    name,
    COUNT([TripID]) AS DropOffCount
FROM [Assignment3Data].[dbo].[201508_trip_data]
JOIN [Assignment3Data].[dbo].[201508_station_data]
    ON EndTerminal = station_id
GROUP BY [EndTerminal], name
ORDER BY COUNT([TripID]);

-- ─────────────────────────────────────────────────────────────────────────────
-- QUERY 5: Monthly summary of bike rentals (format: MM-yyyy)
-- ─────────────────────────────────────────────────────────────────────────────
SELECT
    FORMAT([StartDate], 'MM-yyyy') AS [MonthYear],
    SUM([Duration] / 3600) AS [MonthlyRentalDurationinHours],
    COUNT([TripID]) AS PickupCount
FROM [Assignment3Data].[dbo].[201508_trip_data]
GROUP BY
    YEAR([StartDate]),
    MONTH([StartDate]),
    FORMAT([StartDate], 'MM-yyyy')
ORDER BY
    YEAR([StartDate]),
    MONTH([StartDate]);
