// Databricks Notebook — Apache Spark DataFrame & Spark SQL Retail Analysis
// Course: MEM6287 Advanced Data Analytics | University of Ottawa | Fall 2024
// Author: Nabeegh Khan

// ─────────────────────────────────────────────────────────────────────────────
// OVERVIEW
// Demonstrates high-level Spark DataFrame API and Spark SQL for retail analytics.
// Dataset: UK Online Retail dataset (Dec 2010 – Dec 2011), multi-file CSV (~25 files).
// Key analyses: transaction totals, top products by quantity & value, country revenue.
// ─────────────────────────────────────────────────────────────────────────────

// COMMAND ----------

// List uploaded retail CSV files in DBFS table space
display(dbutils.fs.ls("/FileStore/tables/by-day"))

// COMMAND ----------

// Load all CSV files using SparkSession high-level DataFrame API
// inferSchema automatically detects column data types
// header reads column names from first row
val salesData = spark
  .read
  .option("inferSchema", "true")
  .option("header", "true")
  .csv("/FileStore/tables/by-day")

// Count total number of transactions across all files
salesData.count()

// COMMAND ----------

// Preview first 2 rows
salesData.take(2)

// COMMAND ----------

// Register DataFrame as a temporary SQL view for Spark SQL queries
salesData.createOrReplaceTempView("Retail_Sales_Analysis")

// COMMAND ----------

// MAGIC %sql
// MAGIC -- Total aggregate transaction value across all records
// MAGIC -- Product Value = Unit Price × Quantity
// MAGIC SELECT SUM(UnitPrice * Quantity) AS TotalAggregateProductValue
// MAGIC FROM Retail_Sales_Analysis

// COMMAND ----------

// MAGIC %sql
// MAGIC -- Project key transaction fields with computed product value per line item
// MAGIC SELECT Description, StockCode, Quantity, UnitPrice, 
// MAGIC        UnitPrice * Quantity AS ProductValue
// MAGIC FROM Retail_Sales_Analysis

// COMMAND ----------

// MAGIC %sql
// MAGIC -- Top 5 best-selling products by total quantity sold (descending)
// MAGIC SELECT Description, StockCode, 
// MAGIC        SUM(Quantity) AS TotalQuantitySold
// MAGIC FROM Retail_Sales_Analysis
// MAGIC GROUP BY Description, StockCode
// MAGIC ORDER BY TotalQuantitySold DESC
// MAGIC LIMIT 5

// COMMAND ----------

// MAGIC %sql
// MAGIC -- Top 5 most valuable products by total revenue generated (descending)
// MAGIC SELECT Description, StockCode, 
// MAGIC        SUM(UnitPrice * Quantity) AS TotalProductValue
// MAGIC FROM Retail_Sales_Analysis
// MAGIC GROUP BY Description, StockCode
// MAGIC ORDER BY TotalProductValue DESC
// MAGIC LIMIT 5

// COMMAND ----------

// MAGIC %sql
// MAGIC -- Total purchase value by country (descending)
// MAGIC -- Identifies highest-revenue markets across the dataset
// MAGIC SELECT Country, 
// MAGIC        SUM(UnitPrice * Quantity) AS TotalPurchaseValue
// MAGIC FROM Retail_Sales_Analysis
// MAGIC GROUP BY Country
// MAGIC ORDER BY TotalPurchaseValue DESC
